package pl.agh.dariuszw;

import java.util.HashSet;
import java.util.Set;

import jade.core.behaviours.Behaviour;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by dariuszw on 2014-12-28.
 */
public class ClockAgent extends Agent {

    private DateTime currentDate;

    private int UPDATE_STEP = 1000; // ??

    private int SIMULATION_STEP = 60; // minutes

    private DateTime startDate;

    private DateTime endDate;

    private static final String UPDATE_STEP_PREFIX = "updateStep=";

    private static final String SIMULATION_STEP_PREFIX = "simulationStep=";

    private static final String START_TIME_PREFIX = "startTime=";

    private static final String END_TIME_PREFIX = "endTime=";

    private static final DateTimeFormatter INIT_PARAM_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");

    Set<AID> receivers = new HashSet<AID>();

    Set<AID> synchronizedAgents = new HashSet<AID>();

    ClockGUI clockGUI;

    @Override
    protected void setup() {
        super.setup();

        for (Object argument : getArguments()) {
            if ( argument instanceof String && ((String) argument).startsWith(UPDATE_STEP_PREFIX) ) {
                UPDATE_STEP = Integer.parseInt(((String) argument).substring(UPDATE_STEP_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(SIMULATION_STEP_PREFIX) ) {
                SIMULATION_STEP = Integer.parseInt(((String) argument).substring(SIMULATION_STEP_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(START_TIME_PREFIX) ) {
                startDate = INIT_PARAM_DATE_FORMATTER.parseDateTime(((String) argument).substring(START_TIME_PREFIX.length()));
            } else if ( argument instanceof String && ((String) argument).startsWith(END_TIME_PREFIX) ) {
                endDate = INIT_PARAM_DATE_FORMATTER.parseDateTime(((String) argument).substring(END_TIME_PREFIX.length()));
            } else if ( argument instanceof String ) {
                AID aid = new AID((String) argument, AID.ISLOCALNAME);
                receivers.add(aid);
            }
        }

        currentDate = startDate == null ? new DateTime() : startDate;

        addBehaviour(new Synchronization());

        clockGUI = new ClockGUI(this);
        clockGUI.showGui();

        System.out.println("SIMULATION RUNTIME INITIALIZED");

    }

    public String getCurrentTime() {
        return Utils.DEFAULT_TIME_FORMATTER.print(currentDate);
    }

    private class ClockPublisher extends OneShotBehaviour {

        @Override
        public void action() {
            currentDate = currentDate.plusMinutes(SIMULATION_STEP);
            clockGUI.updateTime(getCurrentTime());

            if ( !receivers.isEmpty() ) {

                ACLMessage message = Utils.createClockMessage(getCurrentTime(), receivers);
                ClockAgent.this.send(message);
                System.out.println("TIME: " + getCurrentTime());
            }
        }
    }

    private class KillOperation extends OneShotBehaviour {

        @Override
        public void action() {
            if ( !receivers.isEmpty() ) {

                ACLMessage message = Utils.createKillMessage(receivers);
                ClockAgent.this.send(message);
                System.out.println("Shutdown process begun");
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
                // System.out.println("Synchronization acknowledge received from "+synchronizationMessage.getSender().getName());
                AID agent = synchronizationMessage.getSender();
                synchronizedAgents.add(agent);
                if ( synchronizedAgents.size() == receivers.size() ) {
                    if(endDate != null && !endDate.isAfter(currentDate)){
                        //shutdown process begun
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
}
