package agh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import pl.agh.dariuszw.ExtendedAgent;
import pl.agh.dariuszw.SimBehaviour;
import pl.agh.dariuszw.Utils;
import pl.agh.dariuszw.variable.Variable;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Created by dariuszw on 2014-12-23.
 */
public class kuchniaKuchnia extends ExtendedAgent {

    private static String STORAGE_AGENT_NAME = "storage";

    private AID storageAID = new AID(STORAGE_AGENT_NAME, AID.ISLOCALNAME);

    private DateTime currentTime = null;


    private String instanceID;

    private String instanceClass;

    private String parent = null;

    private AID parentAID = null;

    // region VARIABLES

    // inject-


    // endregion VARIABLES

    @Override
    protected void setup() {
        super.setup();

        // send message to store point
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                StringBuilder messageBuilder = new StringBuilder();
                messageBuilder.append(instanceID);
                messageBuilder.append("#");
                messageBuilder.append(instanceClass);

                ACLMessage initSimulationMessage = new ACLMessage(ACLMessage.INFORM);
                initSimulationMessage.setOntology("instance");
                initSimulationMessage.addReceiver(storageAID);
                initSimulationMessage.setContent(messageBuilder.toString());
                send(initSimulationMessage);

            }
        });

        // inject-
         instanceID = "agh.kuchniaKuchnia";

         instanceClass = "agh.kuchnia";

         registerState("agh.kuchniaKuchnia","New State");

        addBehaviour(new Start());


        addBehaviour(new Synchronization());

        log("READY!");
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    public DateTime getCurrentDate() {
        return currentTime;
    }

    public String getInstance() {
        return instanceID;
    }

    // region BEHAVIOURS
    private class Synchronization extends CyclicBehaviour {

        @Override
        public void action() {
            // System.out.println("Agent ready to continue! Synchronize with global clock " + getLocalName());
            send(Utils.createSynchronizationMessage());

            ACLMessage timeMessage = blockingReceive(Utils.RUNTIME_MASSAGE);
            if ( timeMessage.getPerformative() == ACLMessage.CFP ) {
                System.out.println(getLocalName() + " SHUTDOWN");
                doDelete();
            } else {
                sendPowerConsumptionSummary();
                currentTime = new DateTime(Utils.MessageParser.parse(timeMessage).getDate());
                return;
            }
        }
    }

    // private boolean notConsumingPower = false;

    private void sendPowerConsumptionSummary() {
        if ( currentTime == null ) {
            return;
        }

        collect();

        // boolean notNeedToSaveData = false;
        //
        // // save 0Watt usage only once
        // if ( powerUsagePoints.isEmpty() ) {
        // if ( notConsumingPower ) {
        // notNeedToSaveData = true;
        // } else {
        // notConsumingPower = true;
        // }
        // } else {
        // notConsumingPower = false;
        // }
        //
        // if ( notNeedToSaveData ) {
        // return;
        // }
        //
        // if ( !notConsumingPower ) {
        // notConsumingPower = true;
        // }

        Integer totalPower = 0;
        for (Integer i : powerUsagePoints) {
            totalPower += i;
        }
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(instanceID);
        messageBuilder.append("#");
        messageBuilder.append(Utils.DEFAULT_TIME_FORMATTER.print(currentTime));
        messageBuilder.append("#");
        messageBuilder.append(totalPower.toString());

        ACLMessage initSimulationMessage = new ACLMessage(ACLMessage.INFORM);
        initSimulationMessage.setOntology("power");
        initSimulationMessage.addReceiver(storageAID);
        initSimulationMessage.setContent(messageBuilder.toString());
        send(initSimulationMessage);

        powerUsagePoints.clear();

    }

    // inject-
    private class Start extends SimBehaviour {

        protected Start(){
            super(getLocalName(), "Start");
        }

        @Override
        public void onStep() {
        
        }

        @Override
        public void onEntry(){

        }

        @Override
        public void onExit(){

        }

        @Override
        public boolean isDone(){
            if(transition_0()){
                addBehaviour(new State_default());
                return true;
            }
            return false;
        }
        private boolean transition_0(){
return true;
        }
       protected boolean isStart(){ return true; }

    }

    private class State_default extends SimBehaviour {

        protected State_default(){
            super(getLocalName(), "New State");
        }

        @Override
        public void onStep() {
        
        }

        @Override
        public void onEntry(){

        }

        @Override
        public void onExit(){

        }

        @Override
        public boolean isDone(){
            return false;
        }
    }



    // endregion BEHAVIOURS

    private List<Integer> powerUsagePoints = new ArrayList<Integer>();

    private void consume(Integer power) {
        if ( power == null ) {
            return;
        }
        if ( parent == null ) {
            return;
        }
        if ( parentAID == null ) {
            parentAID = new AID(parent, AID.ISLOCALNAME);
        }

        powerUsagePoints.add(power);

        if ( parentAID != null ) {
            ACLMessage powerInfo = new ACLMessage(ACLMessage.INFORM);
            powerInfo.setContent(power.toString());
            powerInfo.setOntology("powerPoint");
            powerInfo.addReceiver(parentAID);
            send(powerInfo);
        }
    }

    MessageTemplate powerMessageTemplate = MessageTemplate.MatchOntology("powerPoint");

    private void collect() {
        ACLMessage powerMessage = null;
        while ((powerMessage = receive(powerMessageTemplate)) != null) {
            Integer powerPoint = Integer.parseInt(powerMessage.getContent());
            powerUsagePoints.add(powerPoint);
        }
    }

    private Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    private void log(String msg) {
        log.info("LOG[" + getLocalName() + "]:" + msg);
    }

    private final Integer i1 = new Integer(1);

    private final Float i2 = null;

    private final String i3 = new String();

    private final DateTime i4 = null;

    private final Boolean i5 = null;

    private final Date i6 = null;

    private SimBehaviour i7 = null;

    private Variable i8 = null;
}
