package power.sim.simulation.drawer;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class RunCustomFeature extends AbstractCustomFeature {

    public RunCustomFeature(IFeatureProvider fp) {
        super(fp);
    }

    private boolean hasDoneChanges = false;

    @Override
    public String getName() {
        return "Run";
    }

    @Override
    public String getDescription() {
        return "Compile and Run simulation";
    }

    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = pes[0];
            if ( bo instanceof Diagram ) {
                this.hasDoneChanges = true;
            }
        }
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = pes[0];
            if ( bo instanceof Diagram ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasDoneChanges() {
        return this.hasDoneChanges;
    }

}
