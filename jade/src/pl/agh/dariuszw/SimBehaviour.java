package pl.agh.dariuszw;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

/**
 * Created by dariuszw on 2015-02-16.
 */
public abstract class SimBehaviour extends Behaviour {

    protected final String id;

    protected final String localName;

    private boolean init = true;

    public boolean firstBehaviourCall = true;

    private static String STORAGE_AGENT_NAME = "storage";

    private AID storageAID = new AID(STORAGE_AGENT_NAME, AID.ISLOCALNAME);

    protected boolean isStart(){
        return false;
    }

    protected SimBehaviour(String localName, String name) {
        this.id = name;
        this.localName = localName;
    }

    @Override
    public final void action() {
        if ( init ) {
            init = false;
            firstBehaviourCall = true;
            log("onEntry");
            sendStateMessage();
            Agent a = getAgent();
            if(a != null && a instanceof ExtendedAgent){
                ((ExtendedAgent) a).addState(id);
            }
            onEntry();
        }
        log("onStep");
        onStep();
        if(firstBehaviourCall) {
            firstBehaviourCall = false;
        }
    }

    private void sendStateMessage(){
        if(isStart()){
            return;
        }

        ExtendedAgent ex = (ExtendedAgent) getAgent();

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(ex.getInstance());
        messageBuilder.append("#");
        messageBuilder.append(Utils.DEFAULT_TIME_FORMATTER.print(ex.getCurrentDate()));
        messageBuilder.append("#");
        messageBuilder.append(id);

        ACLMessage initSimulationMessage = new ACLMessage(ACLMessage.INFORM);
        initSimulationMessage.setOntology("state");
        initSimulationMessage.addReceiver(storageAID);
        initSimulationMessage.setContent(messageBuilder.toString());
        getAgent().send(initSimulationMessage);

    }


    @Override
    public final boolean done() {
        boolean isDone = isDone();
        if ( isDone ) {
            log("onExit");
            Agent a = getAgent();
            if(a != null && a instanceof ExtendedAgent){
                ((ExtendedAgent) a).removeState(id);
            }
            onExit();
        }
        return isDone;
    }

    private Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    private void log(String msg) {
        log.info("LOG[" + localName + ":" + id + "]:" + msg);
    }

    protected abstract boolean isDone();

    protected abstract void onStep();

    protected abstract void onEntry();

    protected abstract void onExit();
}
