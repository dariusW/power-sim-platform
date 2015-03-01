package pl.agh.dariuszw.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import pssimulation.PSInstance;
import pssimulation.PSSimulation;

/**
 * Created by dariuszw on 2015-02-17.
 */
public class SimulationRunner {

    private static final String BASE_PATH = "C:/Users/dariuszw/graphiti/jade/out/artifacts/simulation_core/";

    private static final String CLASSPATH = "java -cp ./jcommon-1.0.23.jar:./jfreechart-1.0.19.jar:./log4j-api-2.2.jar:./log4j-core-2.2.jar:./h2.jar:./commons-lang3-3.3.2.jar:./jade.jar:./joda-time-2.5.jar:./power-sim-model.jar:./org.eclipse.emf.ecore.xmi_2.10.1.v20140901-1043.jar:./simulation-core.jar:";

    private static final String BOOT = " jade.Boot -gui -agents storage:pl.agh.dariuszw.StorageAgent();engine:pl.agh.dariuszw.ClockAgent(simulation=";
    private static final String P1 = "simulationStep=PT1H,startTime=2015-01-01T10:00,endTime=2015-01-03T00:00,";

    public static void run(PSSimulation simulation, String path) {
        StringBuilder whole = new StringBuilder(CLASSPATH.replace(":", File.pathSeparator).replace("./", BASE_PATH));
        whole.append(path);
        whole.append(BOOT);
        whole.append(simulation.getId());
        whole.append(",simulationStep=");
        whole.append(simulation.getSimulationStep());
        whole.append(",startTime=");
        whole.append(simulation.getSimulationStartDate());
        whole.append(",endTime=");
        whole.append(simulation.getSimulationEndDate());
        whole.append(",");

        for (PSInstance inst : simulation.getElement()) {
            whole.append(inst.getModelClass());
            whole.append(inst.getId());
            whole.append(",");
        }
        whole.deleteCharAt(whole.length() - 1);
        whole.append(");");
        for (PSInstance inst : simulation.getElement()) {
            whole.append(inst.getModelClass());
            whole.append(inst.getId());
            whole.append(":");
            whole.append(inst.getModelClass());
            whole.append(inst.getId());
            whole.append("();");
        }
        System.out.println(whole.toString());

        final Process p;
        try {
            p = Runtime.getRuntime().exec(whole.toString());

            new Thread(new Runnable() {
                public void run() {
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    String line = null;

                    try {
                        while ((line = input.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(new Runnable() {
                public void run() {
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = null;

                    try {
                        while ((line = input.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
