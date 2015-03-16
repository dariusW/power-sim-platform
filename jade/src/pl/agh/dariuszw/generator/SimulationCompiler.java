package pl.agh.dariuszw.generator;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import psplatform.PSAgent;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;

/**
 * Created by dariuszw on 2015-02-16.
 */
public class SimulationCompiler {
    private static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public static void compile(PSSimulation simulation, Collection<PSAgent> agents, String path) {
        String sources = path + "generated/";
        String target = path + "compiled/";

        (new File(target)).mkdirs();
        compileAll(simulation, agents, sources, target);

    }

    private static void compileAll(PSSimulation simulation, Collection<PSAgent> agents, String sources, String target) {
        for (PSInstance inst : simulation.getElement()) {
            String classes = sources + inst.getModelClass().replace(".", "/") + inst.getId() + ".java";
            if(compiler == null){
                throw new RuntimeException("compiler is NULL!");
            }
            int res = compiler.run(null, null, null, "-d", target, classes);
            if(res != 0){
                throw new RuntimeException("Compilation of model failed!");
            }
        }
    }
}
