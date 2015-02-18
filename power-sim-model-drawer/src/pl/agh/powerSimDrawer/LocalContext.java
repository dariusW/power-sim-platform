package pl.agh.powerSimDrawer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
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

import pl.agh.powerSimDrawer.diagram.PowerSimDiagramTypeProvider;
import psplatform.PSAgent;
import psplatform.PSStart;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;
import psplatform.PSVariableScope;
import psplatform.PsplatformFactory;

public class LocalContext {

    public static LocalContext CONTEXT = new LocalContext();

    private final Map<String, URI> uriMap = new HashMap<String, URI>();

    private final Map<String, PSAgent> modelMap = new HashMap<String, PSAgent>();

    private final Set<Diagram> all = new HashSet<Diagram>();

    private LocalContext() {

    }

    public PSAgent getPlatform(Diagram targetDiagram) {
        all.add(targetDiagram);
        return modelMap.get(targetDiagram.getName());
    }

    public void addPSStart(Diagram targetDiagram, PSStart psStart) {
        getPlatform(targetDiagram).setStart(psStart);
    }

    public void addPSVariable(Diagram targetDiagram, PSVariable psVar) {
        getPlatform(targetDiagram).getVariables().add(psVar);
    }

    public void addPSState(Diagram targetDiagram, PSState psState) {
        getPlatform(targetDiagram).getStates().add(psState);
    }

    public void addTransition(Diagram targetDiagram, PSTransition psTransition, PSState source, PSState target) {
        getPlatform(targetDiagram).getTransactions().add(psTransition);
        // psTransition.setId("pstransition_" + UUID.randomUUID());

        source.getTransitions().add(psTransition);
        psTransition.setSource(source);

        psTransition.setTarget(target);

    }

    // public PSState findState(PSState psState) {
    // for (PSState state : platform.getStates()) {
    // if ( state.getId().equals(psState.getId()) ) {
    // return state;
    // }
    // }
    // return null;
    // }
    //
    // public PSStart getStart() {
    // return platform.getStart();
    // }
    //
    // public PSTransition findTransition(PSTransition psTransition) {
    // for (PSTransition transition : platform.getTransactions()) {
    // // if ( transition.getId().equals(psTransition.getId()) ) {
    // // return transition;
    // // }
    // }
    // return null;
    // }

    public void save(Diagram diag) {
        // Diagram diag = diagramProvider.getDiagram();
        if ( diag != null ) {
            System.out.println("Saving content! " + diag.getName());
            PSAgent platform = modelMap.get(diag.getName());
            if ( platform.eResource() == null ) {
                try {
                    saveToModelFile(platform, diag);

                } catch (CoreException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void generateProperties() {
        // Diagram diag = diagramProvider.getDiagram();
        try {
            //global path to model to folder
            if(!all.iterator().hasNext()){
                return;
            }
            Diagram diag = all.iterator().next();
            
            String path = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString().substring(6);
            path = path + "/" +(diag.eResource().getURI().toString().substring(19));
            //String diagName = path.substring(path.lastIndexOf("/"));
            path = path.substring(0, path.lastIndexOf("/"));

            Properties modelListProperties = new Properties();
            Properties externalVarListProperties = new Properties();
            Properties publicVarListProperties = new Properties();
            
            File propertyFile = new File(path+"/models.properties");
            if ( !propertyFile.exists() ) {
                propertyFile.createNewFile();
            }
            FileInputStream inputStream = new FileInputStream(propertyFile);
            modelListProperties.load(inputStream);
            inputStream.close();

            File propertyFile2 = new File(path+"/public.properties");
            if ( !propertyFile2.exists() ) {
                propertyFile2.createNewFile();
            }
            inputStream = new FileInputStream(propertyFile2);
            publicVarListProperties.load(inputStream);
            inputStream.close();
            
            File propertyFile3 = new File(path+"/external.properties");
            if ( !propertyFile3.exists() ) {
                propertyFile3.createNewFile();
            }
            inputStream = new FileInputStream(propertyFile3);
            externalVarListProperties.load(inputStream);
            inputStream.close();
            
            modelListProperties.clear();
            externalVarListProperties.clear();
            publicVarListProperties.clear();

            for(Diagram d: all){
                String name = d.eResource().getURI().toString();
                name = name.substring(name.lastIndexOf("/"));
                
                PSAgent agent = getPlatform(d);
                String id = agent.getPackage()+"."+agent.getId();
                
                modelListProperties.put(id, path+name);
                
                for(PSVariable v: agent.getVariables()){
                    if(v.getScope().equals(PSVariableScope.EXTERNAL)){
                        externalVarListProperties.put(v.getKey(), id);
                        
                        
                    } else if(v.getScope().equals(PSVariableScope.PUBLIC)){
                        publicVarListProperties.put(v.getKey(), id);
                        
                        
                    }
                }
                
                
            }
            
            modelListProperties.store(new FileOutputStream(propertyFile), "");
            
            externalVarListProperties.store(new FileOutputStream(propertyFile3), "");
            
            publicVarListProperties.store(new FileOutputStream(propertyFile2), "");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFullID(Diagram d) {
        return getFullID(getPlatform(d));
    }

    public String getFullID(PSAgent a) {
        return a.getPackage() + "." + a.getId();
    }

    private static void saveToModelFile(final EObject obj, final Diagram d) throws CoreException, IOException {
        URI uri = d.eResource().getURI();
        uri = uri.trimFragment();
        uri = uri.trimFileExtension();
        uri = uri.appendFileExtension("dmodel"); //$NON-NLS-1$
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

    // public PowerSimDiagramTypeProvider getDiagramProvider() {
    // return diagramProvider;
    // }

    public void addDiagramProvider(PowerSimDiagramTypeProvider diagramProvider) {
        // this.diagramProvider = diagramProvider;
        if ( diagramProvider.getDiagram() != null ) {
            Diagram diag = diagramProvider.getDiagram();
            if ( diag == null ) {
                return;
            }
            try {
                Resource res = diag.eResource().getResourceSet().getResource(getURI(diag), true);
                for (EObject eobject : res.getContents()) {
                    if ( eobject instanceof PSAgent ) {
                        modelMap.put(diag.getName(), (PSAgent) eobject);
                    }
                }
            } catch (Exception e) {
                PSAgent a = PsplatformFactory.eINSTANCE.createPSAgent();
                a.setId(diag.getName());
                a.setPackage("default");
                a.setName(diag.getName());
                modelMap.put(diag.getName(), a);
            }
        }
    }

    private URI getURI(Diagram diagram) {
        URI uri;
        if ( (uri = uriMap.get(diagram.getName())) != null ) {
            return uri;
        }

        uri = diagram.eResource().getURI();
        uri = uri.trimFragment();
        uri = uri.trimFileExtension();
        uri = uri.appendFileExtension("dmodel");

        uriMap.put(diagram.getName(), uri);

        return uri;
    }

}
