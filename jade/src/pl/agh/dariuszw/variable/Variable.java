package pl.agh.dariuszw.variable;

import jade.core.AID;
import org.joda.time.DateTime;
import pl.agh.dariuszw.Utils;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dariuszw on 2015-02-10.
 */
public class Variable<T> {

    private Object value;

    private MessageTemplate updateTemplate;

    private MessageTemplate publishTemplate;

    public DateTime timeValue() {
        return null;
    }

    public DateTime dateValue() {
        return null;
    }

    private Class classType;

    private Variable(Type type, Scope scope) {
        switch (type) {
            case BOOLEAN:
                classType = Boolean.class;
                value = false;
                break;
            case DATE:
            case TIME:
                classType = DateTime.class;
                break;
            case FLOAT: classType = Float.class;
                break;
            case INTEGER: classType = Integer.class;
                break;
            case STRING: classType = String.class;
        }
        switch (scope) {
            case EXTERNAL:
                this.scope = Scope.EXTERNAL;
                break;
            case LOCAL:
                this.scope = Scope.LOCAL;
                break;
            case PUBLIC:
                this.scope = Scope.PUBLIC;
        }
    }

    private String key;

    private MessageTemplate externalMessageTemplate;

    public static Variable create(Agent agent, String prop, String exernalProperty, Type type, Scope scope, String defaultVal, String... relatedAgents) {
        Variable variable = new Variable(type, scope);
        variable.agent = agent;
        variable.key = prop;

        if(relatedAgents != null) {
            for (String relatedAgentId : relatedAgents) {
                variable.relatedAgentsIds.add(new AID(relatedAgentId, AID.ISLOCALNAME));
            }
        }

        variable.externalMessageTemplate =MessageTemplate.MatchOntology(exernalProperty);

        return variable;

    }

   private List<AID> relatedAgentsIds = new ArrayList<AID>();

    private Agent agent;

    public void set(Object newValue){
        log(newValue);
        if(!newValue.getClass().equals(classType)){
            throw new IllegalArgumentException("Illegal value");
        }
        value = newValue;
        if(scope.equals(Scope.PUBLIC)){
            //publish value
            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            for(AID a: relatedAgentsIds){
                message.addReceiver(a);
            }
            message.setOntology(key);
            message.setContent(value.toString());
            agent.send(message);
        }
    }

    public Boolean booleanValue(){
        if(!value.getClass().equals(classType)){
            throw new IllegalArgumentException();
        }
        if(scope.equals(Scope.EXTERNAL)){
            ACLMessage message;
            while((message = agent.receive(externalMessageTemplate)) != null){
                set(prepareValue(message.getContent()));
            }

        }

        return (Boolean)value;
    }

    private Object prepareValue(String content) {



        return null;
    }

    private Scope scope;

    public static enum Scope {
        LOCAL, EXTERNAL, PUBLIC
    };

    public static enum Type {
        BOOLEAN, DATE, TIME, STRING, FLOAT, INTEGER
    };

    private void log(Object o){
        System.err.println(o);
    }

}
