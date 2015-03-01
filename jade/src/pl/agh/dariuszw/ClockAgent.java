package pl.agh.dariuszw;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.MutablePeriod;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import pl.agh.dariuszw.gui.ClockGUI;

/**
 * Created by dariuszw on 2014-12-28.
 */
public class ClockAgent extends Agent {

    private static String STORAGE_AGENT_NAME = "storage";

    private AID storageAID = new AID(STORAGE_AGENT_NAME, AID.ISLOCALNAME);

    private DateTime currentDate;

    private int UPDATE_STEP = 1000; // ??

    private MutablePeriod simulationStep = new MutablePeriod(); // minutes

    private DateTime startDate;

    private String simulationID;

    private String configurationURL;

    private DateTime endDate;

    private static final String UPDATE_STEP_PREFIX = "updateStep=";

    private static final String SIMULATION_STEP_PREFIX = "simulationStep=";

    private static final String START_TIME_PREFIX = "startTime=";

    private static final String END_TIME_PREFIX = "endTime=";

    private static final String SIMULATION_ID_PREFIX = "simulation=";

    private static final String CONFIGURATION_URL_PREFIX = "configuration=";

    Set<AID> receivers = new HashSet<AID>();

    Set<AID> synchronizedAgents = new HashSet<AID>();

    ClockGUI clockGUI;

    @Override
    protected void setup() {
        super.setup();
        simulationStep.setMinutes(1);

        for (Object argument : getArguments()) {
            if ( argument instanceof String && ((String) argument).startsWith(UPDATE_STEP_PREFIX) ) {
                UPDATE_STEP = Integer.parseInt(((String) argument).substring(UPDATE_STEP_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(SIMULATION_STEP_PREFIX) ) {
                simulationStep = MutablePeriod.parse(((String) argument).substring(SIMULATION_STEP_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(START_TIME_PREFIX) ) {
                startDate = Utils.INIT_PARAM_DATE_FORMATTER.parseDateTime(((String) argument).substring(START_TIME_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(END_TIME_PREFIX) ) {
                endDate = Utils.INIT_PARAM_DATE_FORMATTER.parseDateTime(((String) argument).substring(END_TIME_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(SIMULATION_ID_PREFIX) ) {
                simulationID = ((String) argument).substring(SIMULATION_ID_PREFIX.length());
            } else if ( argument instanceof String && ((String) argument).startsWith(CONFIGURATION_URL_PREFIX) ) {
                configurationURL = ((String) argument).substring(CONFIGURATION_URL_PREFIX.length());
            } else if ( argument instanceof String ) {
                AID aid = new AID((String) argument, AID.ISLOCALNAME);
                receivers.add(aid);
            }
        }

        currentDate = startDate == null ? new DateTime() : startDate;

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                StringBuilder messageBuilder = new StringBuilder();
                messageBuilder.append(simulationID);
                messageBuilder.append("#");
                messageBuilder.append(Utils.DEFAULT_TIME_FORMATTER.print(new DateTime()));
                messageBuilder.append("#");
                messageBuilder.append(simulationStep);
                messageBuilder.append("#");
                messageBuilder.append(Utils.INIT_PARAM_DATE_FORMATTER.print(startDate));
                messageBuilder.append("#");
                messageBuilder.append(Utils.INIT_PARAM_DATE_FORMATTER.print(endDate));
                messageBuilder.append("#");
                messageBuilder.append(configurationURL);

                ACLMessage initSimulationMessage = new ACLMessage(ACLMessage.INFORM);
                initSimulationMessage.setOntology("simulation");
                initSimulationMessage.addReceiver(storageAID);
                initSimulationMessage.setContent(messageBuilder.toString());
                send(initSimulationMessage);

            }
        });

        addBehaviour(new Synchronization());

        clockGUI = new ClockGUI(this);
        clockGUI.showGui();

        log("SIMULATION RUNTIME INITIALIZED");

    }

    public String getCurrentTime() {
        return Utils.DEFAULT_TIME_FORMATTER.print(currentDate);
    }

    private class ClockPublisher extends OneShotBehaviour {

        @Override
        public void action() {
            currentDate = currentDate.plus(simulationStep);
            clockGUI.updateTime(getCurrentTime());

            if ( !receivers.isEmpty() ) {

                ACLMessage message = Utils.createClockMessage(getCurrentTime(), receivers);
                ClockAgent.this.send(message);
                log("------------------------\n" + getCurrentTime());
                clockGUI.updateProgress(calculateProgress());
            }
        }
    }

    private int calculateProgress() {
        long start = startDate.toDate().getTime();
        long scaledEnd = endDate.toDate().getTime() - start;
        long scaledCurrent = currentDate.toDate().getTime() - start;
        return (int) (((((double) scaledCurrent) / ((double) scaledEnd)) * 100.0));
    }

    private class KillOperation extends OneShotBehaviour {

        @Override
        public void action() {
            if ( !receivers.isEmpty() ) {

                ACLMessage message = Utils.createKillMessage(receivers);
                ClockAgent.this.send(message);
                log("Shutdown process begun");
                doDelete();
            }
        }
    }

    private class Synchronization extends Behaviour {

        private boolean simulationShutdown = false;

        @Override
        public void action() {
            ACLMessage synchronizationMessage = receive(Utils.SYNCHRONIZATION_TEMPLATE);
            if ( synchronizationMessage != null ) {
                log("Synchronization acknowledge received from " + synchronizationMessage.getSender().getName());
                AID agent = synchronizationMessage.getSender();
                synchronizedAgents.add(agent);
                if ( synchronizedAgents.size() == receivers.size() ) {
                    if ( endDate != null && !endDate.isAfter(currentDate) ) {
                        // shutdown process begun
                        addBehaviour(new KillOperation());
                    } else {
                        synchronizedAgents.clear();
                        addBehaviour(new ClockPublisher());
                    }
                }
            } else {
                block();
            }
        }

        @Override
        public boolean done() {
            return simulationShutdown;
        }
    }

    private Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    private void log(String msg) {
        log.info("CORE:" + msg);
    }
}
