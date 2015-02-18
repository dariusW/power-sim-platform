package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import psplatform.PSStart;
import psplatform.PsplatformFactory;

public class CreatePSStartFeature extends AbstractCreateFeature {

    public CreatePSStartFeature(IFeatureProvider fp) {
        super(fp, "Start", "Create Start");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }

    @Override
    public Object[] create(ICreateContext context) {
        PSStart psStart = PsplatformFactory.eINSTANCE.createPSStart();
        psStart.setOnInit(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
        psStart.setOnEntry(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
        psStart.setOnExit(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
        psStart.setOnStep(PsplatformFactory.eINSTANCE.createPSContinuousBehaviour());
        psStart.setName("START");
        psStart.setId("start");
        
        addGraphicalRepresentation(context, psStart);
        return new Object[] { psStart };
    }

}
