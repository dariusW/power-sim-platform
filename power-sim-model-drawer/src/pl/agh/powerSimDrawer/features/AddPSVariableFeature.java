package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.examples.tutorial.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import pl.agh.powerSimDrawer.LocalContext;
import psplatform.PSVariable;

public class AddPSVariableFeature extends AbstractAddShapeFeature {

    // private static final IColorConstant PSSTATE_TEXT_FOREGROUND = IColorConstant.BLACK;
    //
    // private static final IColorConstant PSSTATE_FOREGROUND = new ColorConstant(98, 131, 167);
    //
    // private static final IColorConstant PSSTATE_BACKGROUND = new ColorConstant(187, 218, 247);

    public AddPSVariableFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a State
        if ( context.getNewObject() instanceof PSVariable ) {
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

        PSVariable newState = (PSVariable) context.getNewObject();
        Diagram targetDiagram = (Diagram) context.getTargetContainer();

        final IGaService gaService = Graphiti.getGaService();
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

        final int width = context.getWidth() <= 0 ? 200 : context.getWidth();
        final int height = context.getHeight() <= 0 ? 35 : context.getHeight();

        final Rectangle anchorRectangle = gaService.createInvisibleRectangle(containerShape);
        gaService.setLocationAndSize(anchorRectangle, context.getX(), context.getY(), width + INVISIBLE_RECT_RIGHT, height);

        Polygon roundedRectangle = gaService.createPlainPolygon(anchorRectangle, new int[] { 0, 0, 20, 0, 25, 5, 25, 35, 0, 35 });
        roundedRectangle.setStyle(getStyleForPSVariable(getDiagram(), PSSTART_COLOR_IN));
        gaService.setLocationAndSize(roundedRectangle, 0, 0, width, height);

        final Shape textShape = peCreateService.createShape(containerShape, false);
        final Text stateNameText = gaService.createPlainText(textShape, newState.getKey());
        stateNameText.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
        stateNameText.setStyle(StyleUtil.getStyleForEClassText(getDiagram()));
        gaService.setLocationAndSize(stateNameText, 30, 5, width, 20);

        updateModel(targetDiagram, newState);

        link(containerShape, newState);
        link(textShape, newState);

        peCreateService.createChopboxAnchor(containerShape);

        return containerShape;
    }

    public static final IColorConstant PSSTART_COLOR_LOCAL = new ColorConstant(255, 255, 255);

    public static final IColorConstant PSSTART_COLOR_OUT = ColorConstant.LIGHT_GREEN;

    public static final IColorConstant PSSTART_COLOR_IN = ColorConstant.YELLOW;

    public static Style getStyleForPSVariable(Diagram diagram, IColorConstant color) {
        final String styleId = "PSVariable"+color.getBlue(); //$NON-NLS-1$
        IGaService gaService = Graphiti.getGaService();

        // this is a child style of the common-values-style
        Style style = gaService.findStyle(diagram, styleId);

        if ( style == null ) { // style not found - create new style
            style = gaService.createPlainStyle(diagram, styleId);
            style.setFilled(true);
            // style.setForeground(gaService.getForegroundColor(n, checkStyles)null );
            style.setBackground(gaService.manageColor(diagram, color));

            // no background color here, we have a gradient instead
            // see chapter "Color Schemas" in Tutorial
            // gaService.setRenderingStyle(style, PredefinedColoredAreas.getBlueWhiteGlossAdaptions());
        }
        return style;
    }

    private void updateModel(Diagram targetDiagram, PSVariable newState) {
        LocalContext.CONTEXT.addPSVariable(targetDiagram, newState);
        LocalContext.CONTEXT.save(targetDiagram);

    }

}
