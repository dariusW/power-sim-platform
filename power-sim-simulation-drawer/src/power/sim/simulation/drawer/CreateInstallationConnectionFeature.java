package power.sim.simulation.drawer;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import pssimulation.PSInstance;
import pssimulation.PssimulationFactory;

public class CreateInstallationConnectionFeature extends AbstractCreateConnectionFeature implements ICreateConnectionFeature {

    public CreateInstallationConnectionFeature(IFeatureProvider fp) {
        super(fp, "Hierarchical Relation", "Creates a regerence beetwen parent and child installation");
    }

    @Override
    public boolean canStartConnection(ICreateConnectionContext context) {
        return isInstallation(context.getSourcePictogramElement());
    }

    @Override
    public boolean canCreate(ICreateConnectionContext context) {
        PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
        PictogramElement targetPictogramElement = context.getTargetPictogramElement();

        return sourcePictogramElement != null && targetPictogramElement != null && sourcePictogramElement != targetPictogramElement
                && isInstallation(sourcePictogramElement) && isInstallation(targetPictogramElement);
    }

    @Override
    public Connection create(ICreateConnectionContext context) {
        Connection newConnection = null;
        PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
        PictogramElement targetPictogramElement = context.getTargetPictogramElement();

        PSInstance source = (PSInstance) getBusinessObjectForPictogramElement(sourcePictogramElement);
        PSInstance target = (PSInstance) getBusinessObjectForPictogramElement(targetPictogramElement);

        if ( source != null && target != null ) {

            AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(PssimulationFactory.eINSTANCE.createPSHierarchy());
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
        return newConnection;
    }

    private boolean isInstallation(PictogramElement sourcePictogramElement) {
        return getBusinessObjectForPictogramElement(sourcePictogramElement) instanceof PSInstance;
    }
}
