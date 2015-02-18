package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import psplatform.PSState;
import psplatform.PsplatformFactory;

public class CreatePSStateFeature extends AbstractCreateFeature {

    public CreatePSStateFeature(IFeatureProvider fp) {
        super(fp, "State", "Create State");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }

    @Override
    public Object[] create(ICreateContext context) {
        PSState state = PsplatformFactory.eINSTANCE.createPSState();
        state.setOnEntry(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
        state.setOnExit(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
        state.setOnStep(PsplatformFactory.eINSTANCE.createPSContinuousBehaviour());
        state.setName("New State");
        state.setId("default");
        
        addGraphicalRepresentation(context, state);
        return new Object[] { state };
    }

}
