package pl.agh.dariuszw;

import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by dariuszw on 2014-12-23.
 */
public class IAmAnElephant extends Agent {
    private DateTime currentTime;

    private String state;

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    private static Random RANDOM_GENERATOR = new Random(new Date().getTime());

    //region VARIABLES

    private Boolean is_my_friend_up = false;

    private Integer trumpet_counter = 0;

    private DateTime trumpet_go_to_sleep_time = DATE_FORMATTER.parseDateTime("2000-01-01 18:00");

    private DateTime trumpet_wake_time = DATE_FORMATTER.parseDateTime("2000-01-01 07:00");

    //endregion VARIABLES

    @Override
    protected void setup() {
        super.setup();

        addBehaviour(new Start());

        addBehaviour(new Synchronization());


        System.out.println("Agent " + getClass().getName() + ":" + getLocalName() + " is now UP!");
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    private class Synchronization extends CyclicBehaviour {

        @Override
        public void action() {
            //System.out.println("Agent ready to continue! Synchronize with global clock " + getLocalName());
            send(Utils.createSynchronizationMessage());

            ACLMessage timeMessage = IAmAnElephant.this.blockingReceive(Utils.RUNTIME_MASSAGE);
            if (timeMessage.getPerformative() == ACLMessage.CFP) {
                System.out.println(getLocalName() + " SHUTDOWN");
                doDelete();
            } else {
                currentTime = Utils.MessageParser.parse(timeMessage).getDate();
                return;
            }
        }
    }

    private class Start extends Behaviour {

        @Override
        public void action() {
            //LATE INIT

            trumpet_go_to_sleep_time = trumpet_go_to_sleep_time.plusHours(RANDOM_GENERATOR.nextInt(4) - 2);

            //end LATE INIT
        }

        @Override
        public boolean done() {
            if (transition_one()) {
                addBehaviour(new State_PlayOnTheTrumpet());
                return true;
            }

            return false;
        }

        private boolean transition_one() {
            return true;
        }
    }

    private class State_PlayOnTheTrumpet extends SimBehaviour {


        protected State_PlayOnTheTrumpet() {
            super(getLocalName(), "Play on the Trumpet");
        }

        @Override
        public void onStep() {
            //register currentState

            if (trumpet_counter == 0) {
                System.out.println(getLocalName() + ": woke up with a wide smile");
                trumpet_counter = 0;
            }

            trumpet_counter++;
        }
        
        

        @Override
        protected void onEntry(){

        }

        @Override
        protected void onExit() {

        }

        public boolean isDone() {
            if (transition_one()) {
                addBehaviour(new State_ElephantSleeps());
                return true;
            }
            return false;
        }

        private boolean transition_one() {
            return currentTime.getHourOfDay() == trumpet_go_to_sleep_time.getHourOfDay();
        }
    }

    private class State_ElephantSleeps extends Behaviour {

        private String stringID = "Elephant sleeps ZZZZ......";

        @Override
        public void action() {
            //register currentState
            state = stringID;

            if (trumpet_counter > 0) {
                System.out.println(getLocalName() + ": played the trumpet " + trumpet_counter + " times.");
                trumpet_counter = 0;
            }
            System.out.println(getLocalName() + ": " + stringID);

        }

        @Override
        public boolean done() {
            if (transition_one()) {
                addBehaviour(new State_PlayOnTheTrumpet());
                return true;
            }
            return false;
        }

        private boolean transition_one() {
            return currentTime.getHourOfDay() == trumpet_wake_time.getHourOfDay();
        }
    }



}
