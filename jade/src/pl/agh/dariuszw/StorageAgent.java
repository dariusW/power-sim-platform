package pl.agh.dariuszw;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.MutablePeriod;

import pl.agh.dariuszw.db.DatabaseManager;
import pl.agh.dariuszw.gui.ChartSelectionGUI;
import pl.agh.dariuszw.gui.PowerChartGUI;
import pl.agh.dariuszw.gui.StateChartGUI;
import pl.agh.dariuszw.gui.SummaryGUI;
import pl.agh.dariuszw.gui.VariableChartGUI;
import pl.agh.dariuszw.variable.Variable;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Created by dariuszw on 2015-02-28.
 */
public class StorageAgent extends Agent {

    public static final MessageTemplate SIMULATION_CONTEXT_MESSAGE_MATCHER = MessageTemplate.MatchOntology("simulation");

    DatabaseManager databaseManager;

    private Date executionDate;

    private String simulationID;

    private boolean simulationContextStored = false;

    private MutablePeriod step = null;

    private boolean shutDown;

    private Date simulationStart;

    private Date simulationEnd;

    ChartSelectionGUI chartSelectionGUI = new ChartSelectionGUI(this);

    private SummaryGUI summary = null;

    @Override
    protected void setup() {
        super.setup();

        databaseManager = DatabaseManager.getInstance();

        chartSelectionGUI.showGui();

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                if ( !simulationContextStored ) {
                    // first store context then other incoming messages
                    ACLMessage incomingMessage = receive(SIMULATION_CONTEXT_MESSAGE_MATCHER);

                    if ( incomingMessage != null ) {
                        storeSimulationData(incomingMessage.getContent());
                        simulationContextStored = true;

                    } else {
                        block();
                    }

                } else {
                    ACLMessage incomingMessage = receive();

                    if ( incomingMessage != null ) {

                        if ( incomingMessage.getPerformative() == ACLMessage.CFP ) {
                            System.out.println(getLocalName() + " SHUTDOWN AFTER ALL MESSAGES PROCESSED");
                            shutDown = true;
                        } else if ( "instance".equals(incomingMessage.getOntology()) ) {
                            storeInstanceData(incomingMessage.getContent());
                        } else if ( "state".equals(incomingMessage.getOntology()) ) {
                            storeStateData(incomingMessage.getContent());
                        } else if ( "variable".equals(incomingMessage.getOntology()) ) {
                            storeVariableData(incomingMessage.getContent());
                        } else if ( "power".equals(incomingMessage.getOntology()) ) {
                            storePowerData(incomingMessage.getContent());
                        } else if ( "powerChart".equals(incomingMessage.getOntology()) ) {
                            buildPowerChart(incomingMessage.getContent());
                        } else if ( "stateChart".equals(incomingMessage.getOntology()) ) {
                            buildStateChart(incomingMessage.getContent());
                        } else if ( "variableChart".equals(incomingMessage.getOntology()) ) {
                            buildVariableChart(incomingMessage.getContent());
                        }

                    } else {
                        if ( shutDown ) {
                            if(summary == null) {
                                summary = new SummaryGUI(StorageAgent.this);
                                summary.showGui();
                            }
                            // close when X is pressed in summary window
                            // doDelete();
                        }
                        block();
                    }

                }
            }
        });

    }

    @Override
    public void doDelete() {
        databaseManager.dispose();
        super.doDelete();
    }

    private void storeVariableData(String content) {
        String[] parts = content.split("#");
        if ( parts.length != 6 ) {
            throw new IllegalStateException("Variable insert message is invalid!");
        }
        String instance = parts[0];
        Date currentTime = Utils.DEFAULT_TIME_FORMATTER.parseDateTime(parts[1]).toDate();
        String key = parts[2];
        String oldValue = parts[3];
        String newValue = parts[4];
        Long increment = Long.parseLong(parts[5]);

        chartSelectionGUI.registerVariable(instance, key);

        databaseManager.executeVariableInsert(simulationID, executionDate, instance, currentTime, key, oldValue, newValue, increment);
    }

    private void storeInstanceData(String content) {
        String[] parts = content.split("#");
        if ( parts.length != 2 ) {
            throw new IllegalStateException("Instance insert message is invalid!");
        }
        String instanceID = parts[0];
        String instanceClass = parts[1];

        chartSelectionGUI.registerInstance(instanceID);

        databaseManager.executeInstanceInsert(simulationID, executionDate, instanceID, instanceClass);

    }

    private void storeStateData(String content) {
        // System.err.println("STORE START! "+ content);
        String[] parts = content.split("#");
        if ( parts.length != 3 ) {
            throw new IllegalStateException("State insert message is invalid!");
        }
        String instance = parts[0];
        Date currentTime = Utils.DEFAULT_TIME_FORMATTER.parseDateTime(parts[1]).toDate();
        String state = parts[2];

        databaseManager.executeStateInsert(simulationID, executionDate, instance, currentTime, state);
    }

    private void storeSimulationData(String content) {
        // System.err.println("STORE START! "+ content);
        String[] parts = content.split("#");
        if ( parts.length != 6 ) {
            throw new IllegalStateException("Simulation init message is invalid!");
        }
        simulationID = parts[0];
        executionDate = Utils.DEFAULT_TIME_FORMATTER.parseDateTime(parts[1]).toDate();
        // System.err.println(executionDate);
        String step = parts[2];
        this.step = MutablePeriod.parse(step);
        simulationStart = Utils.INIT_PARAM_DATE_FORMATTER.parseDateTime(parts[3]).toDate();
        simulationEnd = Utils.INIT_PARAM_DATE_FORMATTER.parseDateTime(parts[4]).toDate();
        String url = parts[5];

        databaseManager.executeSimulationInitialization(simulationID, executionDate, step, simulationStart, simulationEnd, url);

    }

    private void storePowerData(String content) {
        // System.err.println("STORE START! "+ content);
        String[] parts = content.split("#");
        if ( parts.length != 3 ) {
            throw new IllegalStateException("Power insert message is invalid!");
        }
        String instance = parts[0];
        Date currentTime = Utils.DEFAULT_TIME_FORMATTER.parseDateTime(parts[1]).toDate();
        Integer power = Integer.parseInt(parts[2]);

        long work = power * toSeconds(step); // J
        Double consumption = ((double) work) / 3600000.0; // kWh

        databaseManager.executePowerInsert(simulationID, executionDate, instance, currentTime, power, step.toString(), consumption);

        PowerChartGUI chart = powerCharts.get(instance);
        if ( chart != null ) {
            DateTime time = new DateTime(currentTime);
            chart.appendPower(time, power);
            chart.appendConsumption(time, consumption);
        }
    }

    private Long toSeconds(MutablePeriod step) {
        long sum = (long) step.getSeconds();
        sum += TimeUnit.MINUTES.toSeconds((long) step.getMinutes());
        sum += TimeUnit.HOURS.toSeconds((long) step.getHours());
        sum += TimeUnit.DAYS.toSeconds((long) step.getDays());

        return sum;
    }

    public String getSimulationID() {
        return simulationID;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public MutablePeriod getStep() {
        return step;
    }

    public Date getSimulationStart() {
        return simulationStart;
    }

    public Date getSimulationEnd() {
        return simulationEnd;
    }

    private Map<String, PowerChartGUI> powerCharts = new ConcurrentHashMap<String, PowerChartGUI>();

    private Map<String, StateChartGUI> stateCharts = new ConcurrentHashMap<String, StateChartGUI>();

    private Map<String, VariableChartGUI> variableCharts = new ConcurrentHashMap<String, VariableChartGUI>();

    private void buildVariableChart(String content) {
        String[] parts = content.split("#");
        if ( parts.length != 2 ) {
            throw new IllegalStateException("Variable message is invalid!" + content);
        }
        String instanceID = parts[0];
        String variableKey = parts[1];

        VariableChartGUI chart = variableCharts.get(instanceID);
        if ( chart == null ) {

            Map<DateTime, String> dataMap = databaseManager.collectVariableData(simulationID, executionDate, instanceID, variableKey);

            System.err.println(Variable.getVariable(instanceID, variableKey));

            chart = new VariableChartGUI(instanceID, Variable.getVariable(instanceID, variableKey), this, dataMap);
            // System.err.println("POWER ITEMS FOUND SIZE " + dataMap.size());

            // for (Map.Entry<DateTime, String> item : dataMap.entrySet()) {
            // chart.appendValue(item.getKey(), item.getValue());
            // }
            variableCharts.put(instanceID, chart);
            chart.showGUI();
        }
    }

    private void buildPowerChart(String instanceID) {
        PowerChartGUI chart = powerCharts.get(instanceID);
        if ( chart == null ) {
            chart = new PowerChartGUI(instanceID, this);

            Map<DateTime, PowerStamp> dataMap = databaseManager.collectPowerData(simulationID, executionDate, instanceID);

            // System.err.println("POWER ITEMS FOUND SIZE " + dataMap.size());

            for (Map.Entry<DateTime, PowerStamp> item : dataMap.entrySet()) {
                chart.appendPower(item.getKey(), item.getValue().power);
                chart.appendConsumption(item.getKey(), item.getValue().work);
            }
            powerCharts.put(instanceID, chart);
            chart.showChart();
        }
    }

    public void disposePowerChart(String instanceID) {
        powerCharts.remove(instanceID);
    }

    private void buildStateChart(String instanceID) {
        StateChartGUI chart = stateCharts.get(instanceID);
        if ( chart == null ) {
            chart = new StateChartGUI(instanceID, this, ExtendedAgent.getStates(instanceID));

            Map<DateTime, String> dataMap = databaseManager.collectStateChanges(simulationID, executionDate, instanceID);
            //
            //
            for (Map.Entry<DateTime, String> item : dataMap.entrySet()) {
                chart.appendState(item.getKey(), item.getValue());
            }
            stateCharts.put(instanceID, chart);
            chart.showGUI();
        }
    }

    public void disposeStateChart(String instanceID) {
        stateCharts.remove(instanceID);
    }

    public void disposeVariableChart(String instanceID) {
        variableCharts.remove(instanceID);
    }

    public static class PowerStamp {

        public PowerStamp(int power, double work) {
            this.power = power;
            this.work = work;
        }

        private int power;

        private double work;
    }

    public void openPowerChart(String instanceID) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setOntology("powerChart");
        message.setContent(instanceID);
        message.addReceiver(getAID());
        send(message);

    }

    public void openStateChart(String instanceID) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setOntology("stateChart");
        message.setContent(instanceID);
        message.addReceiver(getAID());
        send(message);

    }

    public void openVariableChart(String instanceID, String variableKey) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setOntology("variableChart");
        message.setContent(instanceID + "#" + variableKey);
        message.addReceiver(getAID());
        send(message);
    }

}
