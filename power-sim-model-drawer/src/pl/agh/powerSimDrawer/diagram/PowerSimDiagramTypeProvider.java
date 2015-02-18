package pl.agh.powerSimDrawer.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramBehavior;

import pl.agh.powerSimDrawer.LocalContext;

public class PowerSimDiagramTypeProvider extends AbstractDiagramTypeProvider {

    public PowerSimDiagramTypeProvider() {
        super();
        setFeatureProvider(new PowerSimFeatureProvider(this));
    }
    
    @Override
    public void init(Diagram diagram, IDiagramBehavior diagramBehavior) {
        super.init(diagram, diagramBehavior);
        LocalContext.CONTEXT.addDiagramProvider(this);        
    }

    @Override
    public boolean isAutoUpdateAtStartup() {
        return true;
    }

    @Override
    public boolean isAutoUpdateAtReset() {
        return true;
    }

    @Override
    public boolean isAutoUpdateAtRuntime() {
        return true;
    }
    
    @Override
    public void resourceReloaded(Diagram diagram) {
        // TODO Auto-generated method stub
        super.resourceReloaded(diagram);
    }
    
}
