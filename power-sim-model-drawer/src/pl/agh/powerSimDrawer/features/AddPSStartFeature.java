package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import pl.agh.powerSimDrawer.LocalContext;
import psplatform.PSStart;
import psplatform.PSState;

public class AddPSStartFeature extends AbstractAddShapeFeature {

    // private static final IColorConstant PSSTATE_TEXT_FOREGROUND = IColorConstant.BLACK;
    //
    // private static final IColorConstant PSSTATE_FOREGROUND = new ColorConstant(98, 131, 167);
    //
    // private static final IColorConstant PSSTATE_BACKGROUND = new ColorConstant(187, 218, 247);

    public AddPSStartFeature(IFeatureProvider fp) {
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

        PSStart newState = (PSStart) context.getNewObject();
        Diagram targetDiagram = (Diagram) context.getTargetContainer();

        final IGaService gaService = Graphiti.getGaService();
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

        final int width = 20;
        final int height = 20;

        final Rectangle anchorRectangle = gaService.createInvisibleRectangle(containerShape);
        gaService.setLocationAndSize(anchorRectangle, context.getX(), context.getY(), width + INVISIBLE_RECT_RIGHT, height);

        RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(anchorRectangle, 20, 20);
        roundedRectangle.setStyle(getStyleForPSStart(getDiagram()));
        gaService.setLocationAndSize(roundedRectangle, 0, 0, width, height);

        updateModel(targetDiagram, newState);

        link(containerShape, newState);

        peCreateService.createChopboxAnchor(containerShape);

        return containerShape;
    }

    private static final IColorConstant PSSTART_COLOR = new ColorConstant(0, 0, 0);

    private static Style getStyleForPSStart(Diagram diagram) {
        final String styleId = "PSStart"; //$NON-NLS-1$
        IGaService gaService = Graphiti.getGaService();

        // this is a child style of the common-values-style
        Style style = gaService.findStyle(diagram, styleId);

        if ( style == null ) { // style not found - create new style
            style = gaService.createPlainStyle(diagram, styleId);
            style.setFilled(true);
            // style.setForeground(gaService.getForegroundColor(n, checkStyles)null );
            style.setBackground(gaService.manageColor(diagram, PSSTART_COLOR));

            // no background color here, we have a gradient instead
            // see chapter "Color Schemas" in Tutorial
            // gaService.setRenderingStyle(style, PredefinedColoredAreas.getBlueWhiteGlossAdaptions());
        }
        return style;
    }

    private void updateModel(Diagram targetDiagram, PSStart newState) {
        LocalContext.CONTEXT.addPSStart(targetDiagram, newState);
        LocalContext.CONTEXT.save(targetDiagram);

    }

}
