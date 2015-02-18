package pl.agh.dariuszw;

import org.junit.Assert;
import org.junit.Test;
import psplatform.PSAgent;
import pssimulation.PSSimulation;

/**
 * Created by dariuszw on 2015-01-18.
 */
public class UtilsTests {

    @Test
    public void test_getSimulationConfigurationObject_whenResourcesExist(){
        System.setProperty(Utils.VM_SIMULATION_PROJECT_PATH, "C:\\Users\\dariuszw\\runtime-EclipseApplication\\exampl\\src\\diagrams");
        System.setProperty(Utils.VM_SIMULATION_PROJECT_NAME, "test1");

        //PSSimulation instance = Utils.getSimulationConfigurationObject();

        //Assert.assertNotNull(instance);
    }

    @Test
    public void test_getAgentConfigurationObject_whenResourcesExist(){
        System.setProperty(Utils.VM_SIMULATION_PROJECT_PATH, "C:\\Users\\dariuszw\\runtime-EclipseApplication\\exampl\\src\\diagrams");
        System.setProperty(Utils.VM_SIMULATION_PROJECT_NAME, "test1");

        //PSSimulation simulation = Utils.getSimulationConfigurationObject();

        //Assert.assertNotNull(simulation);
        //Assert.assertFalse(simulation.getElement().isEmpty());

        //PSAgent instance = Utils.getAgentConfigurationObject(simulation.getElement().get(0));

        //Assert.assertNotNull(instance);

    }


}
