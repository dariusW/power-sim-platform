package pl.agh.dariuszw.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import psplatform.PSAgent;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;
import psplatform.PsplatformPackage;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;
import pssimulation.PssimulationPackage;

/**
 * Created by dariuszw on 2015-02-15.
 */
public class SimulationReader {

    public static PSSimulation getSimulationConfigurationObject(String projectPath) {

        // String projectPath = System.getProperty(VM_SIMULATION_PROJECT_PATH, "");
        // String simulationFileName = System.getProperty(VM_SIMULATION_PROJECT_NAME, "");
        if ( StringUtils.isBlank(projectPath) ) {
            throw new IllegalStateException("Simulation project path is missing");
        }
        File simulationFile = new File(projectPath);// + File.separator + simulationFileName + SIMULATION_MODEL_SUFFIX);
        if ( !simulationFile.exists() ) {
            throw new IllegalStateException("Simulation model file do no exists");
        }
        return loadEObject(simulationFile, PSSimulation.class, PssimulationPackage.eINSTANCE);
    }

    public static PSAgent getAgentConfigurationObject(PSInstance instance) {

        String projectPath = instance.getModelPath().substring(0, instance.getModelPath().lastIndexOf('.')) + ".dmodel";
        if ( StringUtils.isBlank(projectPath) ) {
            throw new IllegalStateException("Simulation project path is missing");
        }
        File simulationFile = new File(projectPath);
        if ( !simulationFile.exists() ) {
            throw new IllegalStateException("Simulation model file do no exists");
        }
        return loadEObject(simulationFile, PSAgent.class, PsplatformPackage.eINSTANCE);
    }

    private static <T extends org.eclipse.emf.ecore.EObject> T loadEObject(File simulationFile, Class<? extends org.eclipse.emf.ecore.EObject> eclass,
            EPackage ePackage) {
        URI uri = URI.createFileURI(simulationFile.getAbsolutePath());

        // Create a resource set to hold the resources.
        //
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file extensions.
        //
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        //
        resourceSet.getPackageRegistry().put(PssimulationPackage.eNS_URI, ePackage);

        try {
            // Demand load resource for this file.
            //
            Resource resource = resourceSet.getResource(uri, true);
            System.out.println("Loaded " + uri);

            // Validate the contents of the loaded resource.
            //
            for (EObject eObject : resource.getContents()) {
                Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
                if ( diagnostic.getSeverity() != Diagnostic.OK ) {
                    // printDiagnostic(diagnostic, "");
                }
                if ( eclass.isAssignableFrom(eObject.getClass()) ) {
                    return (T) eObject;
                }

            }
        } catch (RuntimeException exception) {
            System.out.println("Problem loading " + uri);
            exception.printStackTrace();
            throw new IllegalStateException(exception);
        }
        return null;
    }



}
