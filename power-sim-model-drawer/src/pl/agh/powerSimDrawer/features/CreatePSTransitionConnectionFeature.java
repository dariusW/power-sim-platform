package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import psplatform.PSStart;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PsplatformFactory;

public class CreatePSTransitionConnectionFeature extends AbstractCreateConnectionFeature implements ICreateConnectionFeature {

    public CreatePSTransitionConnectionFeature(IFeatureProvider fp) {
        super(fp, "Transition", "Creates a new Transition between two states or start node");
    }

    @Override
    public boolean canStartConnection(ICreateConnectionContext context) {
        return isState(context.getSourcePictogramElement());
    }

    @Override
    public boolean canCreate(ICreateConnectionContext context) {
        PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
        PictogramElement targetPictogramElement = context.getTargetPictogramElement();

        return sourcePictogramElement != null && targetPictogramElement != null && sourcePictogramElement != targetPictogramElement
                && isState(sourcePictogramElement) && isNotStart(targetPictogramElement);
    }

    @Override
    public Connection create(ICreateConnectionContext context) {
        Connection newConnection = null;
        PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
        PictogramElement targetPictogramElement = context.getTargetPictogramElement();

        PSState source = (PSState) getBusinessObjectForPictogramElement(sourcePictogramElement);
        PSState target = (PSState) getBusinessObjectForPictogramElement(targetPictogramElement);

        if ( source != null && target != null && !(target instanceof PSStart) ) {
            PSTransition transition = PsplatformFactory.eINSTANCE.createPSTransition();
            transition.setSource(source);
            transition.setTarget(target);
            source.getTransitions().add(transition);

            AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            addContext.setNewObject(transition);
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
        return newConnection;
    }

    private boolean isNotStart(PictogramElement sourcePictogramElement) {
        return !(getBusinessObjectForPictogramElement(sourcePictogramElement) instanceof PSStart);
    }

    private boolean isState(PictogramElement sourcePictogramElement) {
        return getBusinessObjectForPictogramElement(sourcePictogramElement) instanceof PSState;
    }
}
