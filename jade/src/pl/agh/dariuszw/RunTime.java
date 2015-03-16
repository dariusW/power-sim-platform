package pl.agh.dariuszw;

import org.apache.commons.lang3.StringUtils;
import pl.agh.dariuszw.generator.SimulationCompiler;
import pl.agh.dariuszw.generator.SimulationContextGenerator;
import pl.agh.dariuszw.generator.SimulationReader;
import pl.agh.dariuszw.generator.SimulationRunner;
import psplatform.PSAgent;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dariuszw on 2015-02-16.
 */
public class RunTime {

    static PSSimulation simulation;

    static Map<PSInstance, PSAgent> agents = new HashMap<PSInstance, PSAgent>();

    public static void main(String[] args) {

        boolean run = false;

        if(args.length > 0 && isPath(args[0])){
            simulation = SimulationReader.getSimulationConfigurationObject(args[0]);

            String pth = args[0].substring(0, args[0].lastIndexOf('/'));
            pth = pth.substring(0, pth.lastIndexOf('/')) + "/generated/";

            (new File(pth)).mkdirs();

            for (PSInstance inst : simulation.getElement()) {
                PSAgent agent = SimulationReader.getAgentConfigurationObject(inst);
                agents.put(inst, agent);
            }
        }

        if ( args.length > 1 && isPath(args[0]) && args[1].contains("g")) {
            run = true;
            String pth = args[0].substring(0, args[0].lastIndexOf('/'));
            pth = pth.substring(0, pth.lastIndexOf('/')) + "/generated/";

            for (Map.Entry<PSInstance, PSAgent> entry : agents.entrySet()) {
                SimulationContextGenerator.generateOne(simulation, entry.getKey(), entry.getValue(), pth);
            }
        }
        if ( args.length > 1 && isPath(args[0]) && args[1].contains("c")) {
            run = true;
            String pth = args[0].substring(0, args[0].lastIndexOf('/'));
            pth = pth.substring(0, pth.lastIndexOf('/')) + "/";
            SimulationCompiler.compile(simulation, agents.values(), pth);
        }
        if ( args.length > 1 && isPath(args[0]) && args[1].contains("r")) {
            run = true;
            String pth = args[0].substring(0, args[0].lastIndexOf('/'));
            pth = pth.substring(0, pth.lastIndexOf('/')) + "/compiled/";


            String basePath = args.length > 2 ? args[2]: "";
            if(StringUtils.isBlank(basePath)){
                URL url = RunTime.class.getResource("RunTime.class");
                basePath = url.toString();
                basePath = basePath.substring(basePath.indexOf("/"), url.toString().length()-50);
                System.out.println("BASEPATH -> "+basePath);
            }


            SimulationRunner.run(simulation, pth, basePath);
        }


        if ( !run ) {
            printHelp();
        }

    }


    private static void printHelp() {
        System.out.println("Usage [path] -[g]?[c]?[r]\n\n-g generate agent code\n-c compile agents\n-r run simulation");
    }


    private static boolean isPath(String arg) {
        return true;
    }
}
