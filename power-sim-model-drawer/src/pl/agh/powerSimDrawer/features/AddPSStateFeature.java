package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.examples.tutorial.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import pl.agh.powerSimDrawer.LocalContext;
import psplatform.PSState;

public class AddPSStateFeature extends AbstractAddShapeFeature {

    // private static final IColorConstant PSSTATE_TEXT_FOREGROUND = IColorConstant.BLACK;
    //
    // private static final IColorConstant PSSTATE_FOREGROUND = new ColorConstant(98, 131, 167);
    //
    // private static final IColorConstant PSSTATE_BACKGROUND = new ColorConstant(187, 218, 247);

    public AddPSStateFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a State
        if ( context.getNewObject() instanceof PSState ) {
            // check if user wants to add to a diagram
            if ( context.getTargetContainer() instanceof Diagram ) {
                return true;
            }
        }
        return false;
    }

    public static final int INVISIBLE_RECT_RIGHT = 6;

    @Override
    public PictogramElement add(IAddContext context) {

        PSState newState = (PSState) context.getNewObject();
        Diagram targetDiagram = (Diagram) context.getTargetContainer();

        final IGaService gaService = Graphiti.getGaService();
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

        final int width = context.getWidth() <= 0 ? 150 : context.getWidth();
        final int height = context.getHeight() <= 0 ? 50 : context.getHeight();

        final Rectangle anchorRectangle = gaService.createInvisibleRectangle(containerShape);
        gaService.setLocationAndSize(anchorRectangle, context.getX(), context.getY(), width + INVISIBLE_RECT_RIGHT, height);

        RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(anchorRectangle, 5, 5);
        roundedRectangle.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
        gaService.setLocationAndSize(roundedRectangle, 0, 0, width, height);

        final Shape textShape = peCreateService.createShape(containerShape, false);
        final Text stateNameText = gaService.createPlainText(textShape, newState.getName());
        stateNameText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
        stateNameText.setStyle(StyleUtil.getStyleForEClassText(getDiagram()));
        gaService.setLocationAndSize(stateNameText, 0, 15, width-10, 20);

        updateModel(targetDiagram, newState);

        link(containerShape, newState);
        link(textShape, newState);

        peCreateService.createChopboxAnchor(containerShape);

        return containerShape;
    }

    private void updateModel(Diagram targetDiagram, PSState newState) {
        LocalContext.CONTEXT.addPSState(targetDiagram, newState);
        LocalContext.CONTEXT.save(targetDiagram);

    }

}
