package pl.agh.dariuszw.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import psplatform.PSAgent;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;
import psplatform.PSVariableScope;
import pssimulation.PSComunication;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;

/**
 * Created by dariuszw on 2015-02-16.
 */
public class SimulationContextGenerator {

    static String INJECT_VALUES = "// inject-";

    static String PACKAGE_PLACE = "package ";

    static String CLASS_NAME_PLACE = " class ";

    public static void generateOne(PSSimulation simulation, PSInstance inst, PSAgent agent, String pth) {

        try {
            String p = (new File(".")).getCanonicalPath();
            FileReader reader = new FileReader(p + "/src/pl/agh/dariuszw/generator/BaseAgent.java");
            if ( reader == null || !reader.ready() ) {
                throw new IllegalStateException();
            }
            StringWriter writer = new StringWriter();
            int c;
            int matchIndex = 0;
            int generationFaze = 0;
            while ((c = reader.read()) != -1) {
                char currentChar = (char) c;
                if ( generationFaze == 0 ) {
                    // append package
                    if ( PACKAGE_PLACE.length() == matchIndex ) {
                        while ((c = reader.read()) != '\n') {
                        }
                        writer.append(agent.getPackage());
                        writer.append(";\n");
                        generationFaze++;
                        matchIndex = 0;
                        continue;
                    }
                    if ( PACKAGE_PLACE.length() > matchIndex && PACKAGE_PLACE.charAt(matchIndex) == currentChar ) {
                        matchIndex++;
                    } else {
                        matchIndex = 0;
                    }
                } else if ( generationFaze == 1 ) {
                    if ( CLASS_NAME_PLACE.length() == matchIndex ) {
                        for (int i = 0; i < 9; i++) {
                            reader.read();
                        }
                        writer.append(agent.getId() + inst.getId());
                        writer.append(" ");
                        generationFaze++;
                        matchIndex = 0;
                        continue;
                    }
                    if ( CLASS_NAME_PLACE.length() > matchIndex && CLASS_NAME_PLACE.charAt(matchIndex) == currentChar ) {
                        matchIndex++;
                    } else {
                        matchIndex = 0;
                    }
                } else {

                    if ( INJECT_VALUES.length() == matchIndex ) {
                        String type = Character.toString(currentChar) + Character.toString((char) reader.read()) + Character.toString((char) reader.read());
                        writer.append("\n");
                        appendSection(type, simulation, inst, agent, writer);
                        matchIndex = 0;
                        continue;
                    }
                    if ( INJECT_VALUES.length() > matchIndex && INJECT_VALUES.charAt(matchIndex) == currentChar ) {
                        matchIndex++;
                    } else {
                        matchIndex = 0;
                    }
                }
                writer.append((char) currentChar);
            }
            reader.close();

            String outputClass = pth + preparePackage(agent) + agent.getId() + inst.getId() + ".java";
            File target = new File(outputClass);
            target.mkdirs();
            target.delete();
            FileOutputStream fileOutputStream = new FileOutputStream(outputClass);
            fileOutputStream.write(writer.getBuffer().toString().getBytes());
            writer.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String preparePackage(PSAgent agent) {
        return agent.getPackage().replace(".", "/") + "/";
    }

    private static void appendSection(String type, PSSimulation simulation, PSInstance inst, PSAgent agent, StringWriter writer) {
        if ( type.equals("var") ) {
            appendVariables(simulation, inst, agent, writer);
        } else if ( type.equals("sgo") ) {

            appendFields(inst, agent, writer);

            appendStart(writer);
        } else if ( type.equals("ini") ) {
            appendInitialization(simulation, inst, agent, writer);
        }
    }

    private static void appendFields(PSInstance inst, PSAgent agent, StringWriter writer) {
        writer.append("         instanceID = \"");
        writer.append(agent.getPackage());
        writer.append(".");
        writer.append(agent.getId());
        writer.append(inst.getId());
        writer.append("\";\n\n");
        writer.append("         instanceClass = \"");
        writer.append(agent.getPackage());
        writer.append(".");
        writer.append(agent.getId());
        writer.append("\";\n\n");
        if(inst.getSuperinstance() != null) {

            writer.append("         parent = \"");
            writer.append(inst.getSuperinstance().getModelClass());
            writer.append(inst.getSuperinstance().getId());
            writer.append("\";\n\n");
        }

        for(PSState state :agent.getStates()){
            writer.append("         registerState(\"");
            writer.append(agent.getPackage());
            writer.append(".");
            writer.append(agent.getId());
            writer.append(inst.getId());
            writer.append("\",\"");
            writer.append(state.getName());
            writer.append("\");\n\n");
        }
    }

    private static void appendStart(StringWriter writer) {
        writer.append("        addBehaviour(new Start());\n");
    }

    private static void appendInitialization(PSSimulation simulation, PSInstance inst, PSAgent agent, StringWriter writer) {
        writeBehaviour(writer, "Start", "Start", inst.getInitBehaviour(), "", "", prepareConditionStateMap(agent.getStart().getTransitions()));

        for (PSState state : agent.getStates()) {
            writeBehaviour(writer, "State_" + state.getId(), state.getName(), state.getOnStep().getOnAction(), state.getOnEntry().getOnAction(), state
                    .getOnExit().getOnAction(), prepareConditionStateMap(state.getTransitions()));
        }
    }

    private static Map<String, String> prepareConditionStateMap(EList<PSTransition> transitions) {
        Map<String, String> map = new HashMap<String, String>();
        for (PSTransition transition : transitions) {
            String condition = transition.getCondition();
            String targetState = "State_" + transition.getTarget().getId();
            map.put(condition, targetState);
        }

        return map;
    }

    private static void writeBehaviour(StringWriter writer, String behaviourName, String stateName, String behaviourCode, String entryCode, String exitCode,
            Map<String, String> transitionConditionTargetStateMap) {
        writer.append("    private class ");
        writer.append(behaviourName);
        writer.append(" extends SimBehaviour {\n\n");
        writer.append("        protected ");
        writer.append(behaviourName);
        writer.append("(){\n            super(getLocalName(), \"");
        writer.append(stateName);
        writer.append("\");\n        }\n\n        @Override\n        public void onStep() {\n        ");
        writer.append(behaviourCode);
        writer.append("\n        }\n\n        @Override\n        public void onEntry(){\n");
        writer.append(entryCode);
        writer.append("\n        }\n\n        @Override\n        public void onExit(){\n");
        writer.append(exitCode);
        writer.append("\n        }\n\n        @Override\n        public boolean isDone(){\n");
        int counter = 0;
        for (Map.Entry<String, String> entry : transitionConditionTargetStateMap.entrySet()) {
            String nextStateName = entry.getValue();
            writer.append("            if(transition_");
            writer.append(Integer.toString(counter));
            writer.append("()){\n                addBehaviour(new ");
            writer.append(nextStateName);
            writer.append("());\n                return true;\n            }\n");
            counter++;
        }
        writer.append("            return false;\n        }\n");
        counter = 0;
        for (Map.Entry<String, String> entry : transitionConditionTargetStateMap.entrySet()) {
            String condition = entry.getKey();
            writer.append("        private boolean transition_");
            writer.append(Integer.toString(counter));
            writer.append("(){\n");
            writer.append(condition);
            writer.append("\n        }\n");
            counter++;
        }
        if("Start".equals(behaviourName)){
            writer.append("       protected boolean isStart(){ return true; }\n\n");
        }

        writer.append("    }\n\n");
    }

    private static void appendVariables(PSSimulation simulation, PSInstance inst, PSAgent agent, StringWriter writer) {
        for (PSVariable variable : agent.getVariables()) {
            String relatedAgents = "";
            String extaernalId = "";
            if ( variable.getScope().equals(PSVariableScope.PUBLIC) ) {
                for (PSComunication communication : inst.getOutgoingConnections()) {
                    if ( communication.getPublicVariable().equals(variable.getKey()) ) {
                        relatedAgents += ", \"" + communication.getEnd().getModelClass() + communication.getEnd().getId() + "\"";
                    }
                }
            } else if ( variable.getScope().equals(PSVariableScope.EXTERNAL) ) {
                for (PSComunication communication : inst.getIncomingConnections()) {
                    if ( communication.getExernalVariable().equals(variable.getKey()) ) {
                        relatedAgents += ", \"" + communication.getBegin().getModelClass() + communication.getBegin().getId() + "\"";
                        extaernalId = communication.getPublicVariable();
                    }
                }
            }

            writer.write("    Variable " + variable.getKey() + " = Variable.create(this, \"" + variable.getKey() + "\", \"" + extaernalId + "\", Variable.Type."
                    + variable.getType().getName().toUpperCase() + ", Variable.Scope." + variable.getScope().getName().toUpperCase() + ", \""
                    + variable.getDefault() + "\"" + relatedAgents + ");\n");
        }

    }
}
