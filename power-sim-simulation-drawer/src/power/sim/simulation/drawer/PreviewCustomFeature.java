package power.sim.simulation.drawer;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import pssimulation.PSInstance;

public class PreviewCustomFeature extends AbstractCustomFeature {

    public PreviewCustomFeature(IFeatureProvider fp) {
        super(fp);
    }

    private boolean hasDoneChanges = false;

    @Override
    public String getName() {
        return "Preview";
    }

    @Override
    public String getDescription() {
        return "Preview installation state";
    }

    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if ( bo instanceof PSInstance ) {
                this.hasDoneChanges = true;
            }
        }
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if ( bo instanceof PSInstance ) {
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
