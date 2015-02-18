package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import psplatform.PSVariable;
import psplatform.PsplatformFactory;

public class CreatePSVariableFeature extends AbstractCreateFeature {

    public CreatePSVariableFeature(IFeatureProvider fp) {
        super(fp, "Variable", "Create Variable");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }

    @Override
    public Object[] create(ICreateContext context) {
        PSVariable state = PsplatformFactory.eINSTANCE.createPSVariable();
        // PSTransition t = PsplatformFactory.eINSTANCE.createPSTransition();
        // t.setSource(state);t.setCondition("DFGHYUJK");
        // state.getTransitions().add(t);
        // state.setOnEntry("OKROPNY LOSSS");
        // PSState states = PsplatformFactory.eINSTANCE.createPSState();
        // t.setTarget(states);
        // PSPlatform platform = PsplatformFactory.eINSTANCE.createPSPlatform();
        // platform.getStates().add(state);
        // platform.getStates().add(states);
        // try {
        // TutorialUtil.saveToModelFile(platform, getDiagram());
        // } catch (CoreException | IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // getDiagram().eResource().getContents().add(platform);

        addGraphicalRepresentation(context, state);
        return new Object[] { state };
    }

}
