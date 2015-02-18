package power.sim.simulation.drawer;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class SimulationDiagramTypeProvider extends AbstractDiagramTypeProvider {

    private IToolBehaviorProvider[] toolBehaviorProviders;

    public SimulationDiagramTypeProvider() {
        super();
        setFeatureProvider(new SimulationDiagramFeatureProvider(this));
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
        super.resourceReloaded(diagram);
    }

    @Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if ( toolBehaviorProviders == null ) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new PSSimulationToolBehaviourProvider(this) };
        }
        return toolBehaviorProviders;
    }
}
