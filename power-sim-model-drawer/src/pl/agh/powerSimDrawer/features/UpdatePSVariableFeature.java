package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import psplatform.PSVariable;
import psplatform.PSVariableScope;

public class UpdatePSVariableFeature extends AbstractUpdateFeature {

    public UpdatePSVariableFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canUpdate(IUpdateContext context) {
        return getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof PSVariable;
    }

    @Override
    public IReason updateNeeded(IUpdateContext context) {
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement  instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramName = text.getValue();
                }
            }
        }
 
        // retrieve name from business model
        String businessName = null;
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof PSVariable) {
            PSVariable eClass = (PSVariable) bo;
            businessName = eClass.getKey();
        }
 
        // update needed, if names are different
        boolean updateNameNeeded =
            ((pictogramName == null && businessName != null) || 
                (pictogramName != null && !pictogramName.equals(businessName)));
        if (updateNameNeeded) {
            return Reason.createTrueReason("Key is out of date");
        } else {
            return Reason.createFalseReason();
        }
    }

    @Override
    public boolean update(IUpdateContext context) {
        String businessName = null;
        PSVariableScope s = null;
        
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if ( bo instanceof PSVariable ) {
            PSVariable state = (PSVariable) bo;
            businessName = state.getKey();
            s = state.getScope();
        }

        // Set name in pictogram model
        if ( pictogramElement instanceof ContainerShape ) {
            ContainerShape cs = (ContainerShape) pictogramElement;    

            for(GraphicsAlgorithm ga: pictogramElement.getGraphicsAlgorithm().getGraphicsAlgorithmChildren()){
                if(ga instanceof Polygon){
                    if(s.equals(PSVariableScope.EXTERNAL)){
                        ga.setStyle(AddPSVariableFeature.getStyleForPSVariable(getDiagram(), AddPSVariableFeature.PSSTART_COLOR_IN));                        
                    } else if(s.equals(PSVariableScope.PUBLIC)){
                        ga.setStyle(AddPSVariableFeature.getStyleForPSVariable(getDiagram(), AddPSVariableFeature.PSSTART_COLOR_OUT));                        
                    } else {
                        ga.setStyle(AddPSVariableFeature.getStyleForPSVariable(getDiagram(), AddPSVariableFeature.PSSTART_COLOR_LOCAL));                        
                    }
                }
            }   
            
            for (Shape shape : cs.getChildren()) {       
                
                if ( shape.getGraphicsAlgorithm() instanceof Text ) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
                }
            }
        }

        return false;
    }

}
