package power.sim.simulation.drawer;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import pssimulation.PSInstance;
import pssimulation.PssimulationFactory;

public class CreatePSInstallationFeature extends AbstractCreateFeature {

    public CreatePSInstallationFeature(IFeatureProvider fp) {
        super(fp, "Instance", "Create simulation instance installation");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram
                || (context.getTargetContainer().getLink() != null && context.getTargetContainer().getLink().getBusinessObjects() != null
                        && !context.getTargetContainer().getLink().getBusinessObjects().isEmpty() && context.getTargetContainer().getLink()
                        .getBusinessObjects().get(0) instanceof PSInstance);
    }

    @Override
    public Object[] create(ICreateContext context) {
        PSInstance installation = PssimulationFactory.eINSTANCE.createPSInstance();

        addGraphicalRepresentation(context, installation);
        return new Object[] { installation };
    }

}
