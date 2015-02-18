package pl.agh.dariuszw.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import pssimulation.PSInstance;
import pssimulation.PSSimulation;

/**
 * Created by dariuszw on 2015-02-17.
 */
public class SimulationRunner {

    private static final String BASE_PATH = "C:/developer/jade/out/artifacts/simulation_core/";

    private static final String CLASSPATH = "java -cp ./commons-lang3-3.3.2.jar:./jade.jar:./joda-time-2.5.jar:./power-sim-model.jar:./org.eclipse.emf.ecore.xmi_2.10.1.v20140901-1043.jar:./simulation-core.jar:";

    private static final String BOOT = " jade.Boot -gui -agents engine:pl.agh.dariuszw.ClockAgent(simulationStep=30,startTime=2015-01-01T10:00,endTime=2015-01-03T00:00,";

    public static void run(PSSimulation simulation, String path) {
        StringBuilder whole = new StringBuilder(CLASSPATH.replace(":", File.pathSeparator).replace("./", BASE_PATH));
        whole.append(path);
        whole.append(BOOT);
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

            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
