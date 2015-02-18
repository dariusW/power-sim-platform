package pl.agh.dariuszw.generator;

import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pl.agh.dariuszw.variable.Variable;
import pl.agh.dariuszw.Utils;
import pl.agh.dariuszw.SimBehaviour;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * Created by dariuszw on 2014-12-23.
 */
public class BaseAgent extends Agent {

    private DateTime currentTime;

    private String state;

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    private static Random RANDOM_GENERATOR = new Random(new Date().getTime());

    //region VARIABLES

    //inject-var

    //endregion VARIABLES

    @Override
    protected void setup() {
        super.setup();

        //inject-sgo

        addBehaviour(new Synchronization());


        System.out.println("Agent " + getClass().getName() + ":" + getLocalName() + " is now UP!");
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    //region BEHAVIOURS
    private class Synchronization extends CyclicBehaviour {

        @Override
        public void action() {
            //System.out.println("Agent ready to continue! Synchronize with global clock " + getLocalName());
            send(Utils.createSynchronizationMessage());

            ACLMessage timeMessage = blockingReceive(Utils.RUNTIME_MASSAGE);
            if (timeMessage.getPerformative() == ACLMessage.CFP) {
                System.out.println(getLocalName() + " SHUTDOWN");
                doDelete();
            } else {
                currentTime = new DateTime(Utils.MessageParser.parse(timeMessage).getDate());
                return;
            }
        }
    }


     //inject-ini


    //endregion BEHAVIOURS


    private void consume(Variable variable){

    }
    
    private final Integer i1 = new Integer(1);
    private final Float i2 = null;
    private final String i3 = new String();
    private final DateTime i4 = null;
    private final Boolean i5 = null;
    private final Date i6 = null;
}
