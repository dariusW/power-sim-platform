package power.sim.simulation.drawer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import pssimulation.PSComunication;
import pssimulation.PSInstance;

public class SimulationDiagramFeatureProvider extends DefaultFeatureProvider {

    public SimulationDiagramFeatureProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }

    @Override
    public ICreateFeature[] getCreateFeatures() {
        return new ICreateFeature[] { new CreatePSInstallationFeature(this) };
    }

    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
        return new ICreateConnectionFeature[] { /*new CreateInstallationConnectionFeature(this), */new CreateRelationConnectionFeature(this) };
    }

    @Override
    public IAddFeature getAddFeature(IAddContext context) {
        /*if ( context instanceof IAddConnectionContext && context.getNewObject() instanceof PSHierarchy ) {
            return new AddInstallationConnectionFeature(this);
        } else */if ( context instanceof IAddConnectionContext && context.getNewObject() instanceof PSComunication ) {
            return new AddRelationConnectionFeature(this);
        }  else if ( context instanceof IAddContext && context.getNewObject() instanceof PSInstance ) {
            return new AddPSInstallationFeature(this);
        }
        return super.getAddFeature(context);
    }

    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
        // TODO: check for right domain object instances below
//        if ( context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
//            return new LayoutDomainObjectFeature(this);
//        }

        return super.getLayoutFeature(context);
    }

    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        if ( pictogramElement instanceof ContainerShape ) {
            Object bo = getBusinessObjectForPictogramElement(pictogramElement);
            if ( bo instanceof PSInstance ) {
                return new UpdatePSInstallationFeature(this);
            }
        }
        return super.getUpdateFeature(context);
    }

    @Override
    public ICustomFeature[] getCustomFeatures(ICustomContext context) {
        List<ICustomFeature> customFeatures = new ArrayList<ICustomFeature>();
        customFeatures.addAll(Arrays.asList(super.getCustomFeatures(context)));
        customFeatures.add(new RunCustomFeature(this));
        customFeatures.add(new PreviewCustomFeature(this));
        return customFeatures.toArray(new ICustomFeature[]{});
    }
    
    @Override
    public void link(PictogramElement pictogramElement, Object[] businessObjects) {
        // TODO Auto-generated method stub
        super.link(pictogramElement, businessObjects);
    }
}
