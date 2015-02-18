package power.sim.simulation.drawer;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import pssimulation.PSComunication;
import pssimulation.PSHierarchy;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;
import pssimulation.PssimulationFactory;

public class LocalContext {

    public static LocalContext CONTEXT = new LocalContext();

    private final Map<String, PSSimulation> modelMap = new HashMap<String, PSSimulation>();

    private static Set<Diagram> all = new HashSet<Diagram>();

    private LocalContext() {

    }

    public static String getBasePath() {
        if(!all.iterator().hasNext()){
            return "";
        }
        Diagram d = all.iterator().next();
        String path = d.eResource().getURI().toString().substring(19);
        String path2 = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString().substring(6);
        return path2 + "/" + path.substring(0, path.lastIndexOf("/"));

    }

    public PSSimulation getSimulation(Diagram targetDiagram) {
        all.add(targetDiagram);
        return modelMap.get(targetDiagram.getName());
    }

    public void addPSInstance(Diagram targetDiagram, PSInstance psInstallation, PSInstance psParent) {
        PSSimulation simulation = getSimulation(targetDiagram);
        simulation.getElement().add(psInstallation);
        if ( psParent != null ) {
            psParent.getSubinstance().add(psInstallation);
            psInstallation.setSuperinstance(psParent);
        }
        // psInstallation.setId("psInstallation_" + UUID.randomUUID());
    }

    public void addPSHierarchy(Diagram targetDiagram, PSHierarchy connection, PSInstance source, PSInstance target) {
        getSimulation(targetDiagram).getConnections().add(connection);
        connection.setParent(source);
        connection.setChild(target);
        connectHirarchy(targetDiagram, source, target, connection);
    }

    public void addPSRelation(Diagram targetDiagram, PSComunication connection, PSInstance source, PSInstance target) {
        getSimulation(targetDiagram).getRelations().add(connection);
        connection.setBegin(source);
        connection.setEnd(target);
        connectRelation(targetDiagram, source, target, connection);
    }

    private void connectHirarchy(Diagram targetDiagram, PSInstance masterInstalation, PSInstance slaveInstallation, PSHierarchy connection) {
        masterInstalation.getChildren().add(connection);
        slaveInstallation.setParent(connection);
    }

    private void connectRelation(Diagram targetDiagram, PSInstance masterInstalation, PSInstance slaveInstallation, PSComunication connection) {
        masterInstalation.getOutgoingConnections().add(connection);
        slaveInstallation.getIncomingConnections().add(connection);
    }

    public void save(Diagram targDiagram) {
        System.out.println("Saving content! " + getSimulation(targDiagram).toString());
        if ( getSimulation(targDiagram).eResource() == null ) {
            try {
                saveToModelFile(getSimulation(targDiagram), targDiagram);
            } catch (CoreException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveToModelFile(final EObject obj, final Diagram d) throws CoreException, IOException {
        URI uri = d.eResource().getURI();
        uri = uri.trimFragment();
        uri = uri.trimFileExtension();
        uri = uri.appendFileExtension("smodel"); //$NON-NLS-1$
        ResourceSet rSet = d.eResource().getResourceSet();
        final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
        if ( file == null || !file.exists() ) {
            Resource createResource = rSet.createResource(uri);
            createResource.save(Collections.emptyMap());
            createResource.setTrackingModification(true);
        }
        final Resource resource = rSet.getResource(uri, true);
        resource.getContents().add(obj);

    }

    public void addDiagramProvider(SimulationDiagramTypeProvider diagramProvider) {
        // this.diagramProvider = diagramProvider;
        if ( diagramProvider.getDiagram() != null ) {
            Diagram diag = diagramProvider.getDiagram();
            if ( diag == null ) {
                return;
            }
            try {
                Resource res = diag.eResource().getResourceSet().getResource(getURI(diag), true);
                if ( res.getContents() == null || res.getContents().isEmpty() ) {
                    throw new IllegalStateException("Empty content of resource");
                }
                for (EObject eobject : res.getContents()) {
                    if ( eobject instanceof PSSimulation ) {
                        modelMap.put(diag.getName(), (PSSimulation) eobject);
                    }
                }
            } catch (Exception e) {
                PSSimulation a = PssimulationFactory.eINSTANCE.createPSSimulation();
                a.setId(diag.getName());
                a.setName(diag.getName());
                modelMap.put(diag.getName(), a);
            }
        }
    }

    private URI getURI(Diagram diagram) {
        URI modelURI = null;
        if ( diagram != null ) {
            modelURI = diagram.eResource().getURI();
            modelURI = modelURI.trimFragment();
            modelURI = modelURI.trimFileExtension();
            modelURI = modelURI.appendFileExtension("smodel");
        }
        return modelURI;
    }

}
