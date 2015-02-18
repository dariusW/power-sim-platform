package pl.agh.powerSimDrawer.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import pl.agh.powerSimDrawer.features.AddPSStartFeature;
import pl.agh.powerSimDrawer.features.AddPSStateFeature;
import pl.agh.powerSimDrawer.features.AddPSTransactionConnectionFeature;
import pl.agh.powerSimDrawer.features.AddPSVariableFeature;
import pl.agh.powerSimDrawer.features.CreatePSStartFeature;
import pl.agh.powerSimDrawer.features.CreatePSStateFeature;
import pl.agh.powerSimDrawer.features.CreatePSTransitionConnectionFeature;
import pl.agh.powerSimDrawer.features.CreatePSVariableFeature;
import pl.agh.powerSimDrawer.features.LayoutDomainObjectFeature;
import pl.agh.powerSimDrawer.features.UpdatePSStateFeature;
import pl.agh.powerSimDrawer.features.UpdatePSVariableFeature;
import psplatform.PSStart;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;

public class PowerSimFeatureProvider extends DefaultFeatureProvider {

    public PowerSimFeatureProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }

    @Override
    public ICreateFeature[] getCreateFeatures() {
        return new ICreateFeature[] { new CreatePSStateFeature(this), new CreatePSStartFeature(this), new CreatePSVariableFeature(this) };
    }

    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
        return new ICreateConnectionFeature[] { new CreatePSTransitionConnectionFeature(this) };
    }

    @Override
    public IAddFeature getAddFeature(IAddContext context) {
        if ( context instanceof IAddConnectionContext && context.getNewObject() instanceof PSTransition ) {
            return new AddPSTransactionConnectionFeature(this);
        } else if ( context instanceof IAddContext && context.getNewObject() instanceof PSStart ) {
            return new AddPSStartFeature(this);
        } else if ( context instanceof IAddContext && context.getNewObject() instanceof PSState ) {
            return new AddPSStateFeature(this);
        } else if ( context instanceof IAddContext && context.getNewObject() instanceof PSVariable ) {
            return new AddPSVariableFeature(this);
        } 

        return super.getAddFeature(context);
    }

    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
        // TODO: check for right domain object instances below
        if ( context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
            return new LayoutDomainObjectFeature(this);
        }

        return super.getLayoutFeature(context);
    }

    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        if ( pictogramElement instanceof ContainerShape ) {
            Object bo = getBusinessObjectForPictogramElement(pictogramElement);
            if ( bo instanceof PSState ) {
                return new UpdatePSStateFeature(this);
            } else if ( bo instanceof PSVariable ) {
                return new UpdatePSVariableFeature(this);
            }
        }
        return super.getUpdateFeature(context);
    }
}
