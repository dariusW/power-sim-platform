package pl.agh.dariuszw.variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import pl.agh.dariuszw.ExtendedAgent;
import pl.agh.dariuszw.Utils;

/**
 * Created by dariuszw on 2015-02-10.
 */
public class Variable {

    private static Map<String, Map<String, Variable>> allInstancesMap = new HashMap<String, Map<String, Variable>>();

    public static Variable getVariable(String instanceID, String variableKey){
        Map<String, Variable> vMap = allInstancesMap.get(instanceID);
        if(vMap == null){
            return null;
        }
        return vMap.get(variableKey);
    }

    private Object value;

    private Type type;

    private Scope scope;

    public static final DateTimeFormatter DATE_TYPE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter TIME_TYPE_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss");

    private List<AID> relatedAgentsIds = new ArrayList<AID>();

    private Agent agent;

    private String key;

    private MessageTemplate externalMessageTemplate;

    private static String STORAGE_AGENT_NAME = "storage";

    private AID storageAID = new AID(STORAGE_AGENT_NAME, AID.ISLOCALNAME);

    long increment = 0;


    public DateTime timeValue() {
        verifyClassAndUpdateIfExternal();
        return (DateTime) value;
    }

    public DateTime dateValue() {
        return timeValue();
    }

    public Float floatValue() {
        verifyClassAndUpdateIfExternal();
        return (Float) value;
    }

    public Integer integerValue() {
        verifyClassAndUpdateIfExternal();
        return (Integer) value;
    }

    public String stringValue() {
        verifyClassAndUpdateIfExternal();
        return (String) value;
    }

    public Boolean booleanValue() {
        verifyClassAndUpdateIfExternal();
        return (Boolean) value;
    }

    public static Variable create(Agent agent, String prop, String exernalProperty, Type type, Scope scope, String defaultVal, String... relatedAgents) {
        Variable variable = new Variable();
        variable.agent = agent;
        variable.key = prop;
        variable.type = type;
        variable.scope = scope;

        if ( relatedAgents != null ) {
            for (String relatedAgentId : relatedAgents) {
                variable.relatedAgentsIds.add(new AID(relatedAgentId, AID.ISLOCALNAME));
            }
        }

        variable.externalMessageTemplate = MessageTemplate.MatchOntology(exernalProperty);

        variable.value = variable.deserialize(defaultVal);

        variable.log(variable.toString());

        Map<String, Variable> vList = allInstancesMap.get(agent.getLocalName());
        if(vList == null){
            vList = new HashMap<String, Variable>();
            allInstancesMap.put(agent.getClass().getName(), vList);
        }
        vList.put(prop, variable);

        return variable;

    }

    public void set(Object newValue) {
        if ( !type.assignedClass.equals(newValue.getClass()) ) {
            throw new IllegalArgumentException("Illegal value");
        }
        sendVariableToStorage(newValue);
        value = newValue;
        log(key + ": newValue! " + toString());
        if ( scope.equals(Scope.PUBLIC) ) {
            // publish value
            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            for (AID a : relatedAgentsIds) {
                message.addReceiver(a);
            }
            message.setOntology(key);
            message.setContent(serialize());
            agent.send(message);
            log(key + ": publishing!");
        }
    }

    private void sendVariableToStorage(Object newValue) {
        if(value == null && newValue == null){
            return;
        }
        if(value != null && value.equals(newValue)){
            return;
        }


        ExtendedAgent ex = (ExtendedAgent) agent;

        if(ex.getCurrentDate() == null){
            return;
        }

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(ex.getInstance());
        messageBuilder.append("#");
        messageBuilder.append(Utils.DEFAULT_TIME_FORMATTER.print(ex.getCurrentDate()));
        messageBuilder.append("#");
        messageBuilder.append(key);
        messageBuilder.append("#");
        messageBuilder.append(serialize());
        messageBuilder.append("#");
        messageBuilder.append(newValue);
        messageBuilder.append("#");
        messageBuilder.append(increment++);

        ACLMessage initSimulationMessage = new ACLMessage(ACLMessage.INFORM);
        initSimulationMessage.setOntology("variable");
        initSimulationMessage.addReceiver(storageAID);
        initSimulationMessage.setContent(messageBuilder.toString());
        agent.send(initSimulationMessage);

    }

    private String serialize() {
        return serialize(this.value);
    }

    private String serialize(Object value) {
        if ( type == Type.BOOLEAN ) {
            return Boolean.toString((Boolean) value);
        }
        if ( type == Type.STRING ) {
            return (String) value;
        }
        if ( type == Type.FLOAT ) {
            return Float.toString((Float) value);
        }
        if ( type == Type.INTEGER ) {
            return Integer.toString((Integer) value);
        }
        if ( type == Type.DATE ) {
            DATE_TYPE_FORMATTER.print((DateTime) value);
        }
        if ( type == Type.TIME ) {
            TIME_TYPE_FORMATTER.print((DateTime) value);
        }
        throw new IllegalStateException();
    }

    private Object deserialize(String content) {
        if ( type == Type.BOOLEAN ) {
            return Boolean.parseBoolean(content);
        }
        if ( type == Type.STRING ) {
            return content;
        }
        if ( type == Type.FLOAT ) {
            return Float.parseFloat(content);
        }
        if ( type == Type.INTEGER ) {
            return Integer.parseInt(content);
        }
        if ( type == Type.DATE ) {
            return DATE_TYPE_FORMATTER.parseDateTime(content);
        }
        if ( type == Type.TIME ) {
            return TIME_TYPE_FORMATTER.parseDateTime(content);
        }
        return null;
    }

    private void verifyClassAndUpdateIfExternal() {
        if ( !type.assignedClass.equals(value.getClass()) ) {
            throw new IllegalArgumentException();
        }

        if ( scope.equals(Scope.EXTERNAL) ) {
            log(key + ": lookup!");
            ACLMessage message;
            while ((message = agent.receive(externalMessageTemplate)) != null) {
                set(deserialize(message.getContent()));
            }
        }

    }

    private Variable() {
    }

    public String getKey() {
        return key;
    }

    public Type getType() {
        return type;
    }

    public static enum Scope {
        LOCAL, EXTERNAL, PUBLIC
    };

    public static enum Type {
        BOOLEAN(Boolean.class), DATE(DateTime.class), TIME(DateTime.class), STRING(String.class), FLOAT(Float.class), INTEGER(Integer.class);

        private Type(Class clazz) {
            assignedClass = clazz;
        }

        Class assignedClass;
    };

    private static Logger log = org.apache.logging.log4j.LogManager.getLogger(Variable.class);

    private void log(String o) {
        log.info("LOG:V:" + agent.getLocalName() + ":" + o);
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }
}
