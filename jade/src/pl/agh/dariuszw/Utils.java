package pl.agh.dariuszw;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import psplatform.PSAgent;
import psplatform.PsplatformPackage;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;
import pssimulation.PssimulationPackage;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Created by dariuszw on 2014-12-28.
 */
public class Utils {

    public static final String VM_SIMULATION_PROJECT_PATH = "simulation.project.path";

    public static final String VM_SIMULATION_PROJECT_NAME = "simulation.project.name";

    private static final String SIMULATION_MODEL_SUFFIX = ".smodel";

    private static final String AGENT_MODEL_SUFFIX = ".dmodel";
    public static final DateTimeFormatter INIT_PARAM_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");

    public static int ENVELOPE_DATE = 1;

    public static int ENVELOPE_INT = 2;

    public static int ENVELOPE_FLOAT = 3;

    public static DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static final AID ENGINE_AGENT_ID = new AID("engine", AID.ISLOCALNAME);

    public static class VariableHolder<T> {

        private Class<T> type;

        private String key;

        private Object value;

        private AID sender;

        private VariableHolder(Class type, String key, Object value, AID sender) {
            this.type = type;
            this.key = key;
            this.value = value;
            this.sender = sender;
        }

        public DateTime getDate() {
            if ( type.equals(DateTime.class) ) {
                return (DateTime) value;
            }
            return null;
        }

        public Integer getInt() {
            if ( type.equals(Integer.class) ) {
                return (Integer) value;
            }
            return null;
        }

        public Float getFloat() {
            if ( type.equals(Float.class) ) {
                return (Float) value;
            }
            return null;
        }

        public Object getValue() {
            return value;
        }

        public Class getType() {
            return type;
        }

        public String getKey() {
            return key;
        }
    }




    public static class MessageParser {

        public static VariableHolder parse(ACLMessage message) {
            if ( message == null ) {
                return null;
            }
            String content = message.getContent();
            AID sender = message.getSender();

            VariableHolder variable;

            String[] parts = content.split(MessageBuilder.SEPARATOR);
            int type = Integer.parseInt(parts[0]);
            String key = parts[1];
            String value = parts[2];

            if ( type == ENVELOPE_DATE ) {
                DateTime val = DEFAULT_TIME_FORMATTER.parseDateTime(value);

                variable = new VariableHolder(DateTime.class, key, val, sender);

            } else if ( type == ENVELOPE_INT ) {
                int val = Integer.parseInt(value);

                variable = new VariableHolder(Integer.class, key, val, sender);

            } else {
                float val = Float.parseFloat(value);

                variable = new VariableHolder(Float.class, key, val, sender);
            }

            return variable;

        }

    }

    public static class MessageBuilder {

        static final String SEPARATOR = ":::";

        private ACLMessage message;

        private MessageBuilder() {
            message = new ACLMessage(ACLMessage.INFORM);
            message.setOntology("default");
        }

        public static MessageBuilder createMessage() {
            return new MessageBuilder();
        }

        public MessageBuilder setContent(int type, String key, String content) {
            StringBuilder sb = new StringBuilder(Integer.toString(type));
            sb.append(SEPARATOR);
            sb.append(key);
            sb.append(SEPARATOR);
            sb.append(content);

            message.setContent(sb.toString());

            return this;
        }

        public MessageBuilder setReceivers(List<AID> receivers) {
            for (AID rec : receivers) {
                message.addReceiver(rec);
            }
            return this;
        }

        public MessageBuilder setPerformative(int i) {
            message.setPerformative(i);
            return this;
        }

        public MessageBuilder setOntology(String ontology) {
            message.setOntology(ontology);
            return this;
        }

        public ACLMessage build() {
            return message;
        }

    }

    public static final MessageTemplate SYNCHRONIZATION_TEMPLATE = MessageTemplate.MatchOntology("synchronization");

    public static ACLMessage createSynchronizationMessage() {
        return MessageBuilder.createMessage().setOntology("synchronization").setReceivers(Collections.singletonList(ENGINE_AGENT_ID)).build();
    }

    public static final MessageTemplate RUNTIME_MASSAGE = MessageTemplate.or(MessageTemplate.MatchOntology("clock"), MessageTemplate.MatchPerformative(ACLMessage.CFP));

    public static ACLMessage createClockMessage(String current, Collection<AID> agents) {
        return Utils.MessageBuilder.createMessage().setContent(Utils.ENVELOPE_DATE, "currentTime", current).setOntology("clock").setReceivers(new ArrayList<AID>(agents)).build();
    }

    public static ACLMessage createKillMessage(Collection<AID> agents) {
        agents.add(new AID("storage", AID.ISLOCALNAME));
        return Utils.MessageBuilder.createMessage().setPerformative(ACLMessage.CFP).setReceivers(new ArrayList<AID>(agents)).build();
    }

    public static final MessageTemplate INNER_COMMUNICATION_MASSAGE = MessageTemplate.MatchOntology("simulation");
}
