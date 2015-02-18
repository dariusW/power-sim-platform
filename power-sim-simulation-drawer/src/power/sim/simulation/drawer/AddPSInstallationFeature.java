package power.sim.simulation.drawer;

import org.eclipse.graphiti.examples.tutorial.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

import pssimulation.PSInstance;

public class AddPSInstallationFeature extends AbstractAddShapeFeature {

    // private static final IColorConstant PSSTATE_TEXT_FOREGROUND = IColorConstant.BLACK;
    //
    // private static final IColorConstant PSSTATE_FOREGROUND = new ColorConstant(98, 131, 167);
    //
    // private static final IColorConstant PSSTATE_BACKGROUND = new ColorConstant(187, 218, 247);

    public AddPSInstallationFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        // check if user wants to add a State
        if ( context.getNewObject() instanceof PSInstance ) {
            // check if user wants to add to a diagram
            if ( context.getTargetContainer() instanceof Diagram
                    || (context.getTargetContainer().getLink() != null && context.getTargetContainer().getLink().getBusinessObjects() != null
                            && !context.getTargetContainer().getLink().getBusinessObjects().isEmpty() && context.getTargetContainer().getLink()
                            .getBusinessObjects().get(0) instanceof PSInstance) ) {
                return true;
            }
        }
        return false;
    }

    public static final int INVISIBLE_RECT_RIGHT = 6;

    @Override
    public PictogramElement add(IAddContext context) {
        Diagram targetDiagram = getDiagram();

        PSInstance newState = (PSInstance) context.getNewObject();
        PSInstance parentInstance = null;
        ContainerShape container = context.getTargetContainer();
        if ( container != null && container.getLink() != null && !container.getLink().getBusinessObjects().isEmpty() ) {
            parentInstance = (PSInstance) container.getLink().getBusinessObjects().get(0);
        }

        final IGaService gaService = Graphiti.getGaService();
        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final ContainerShape containerShape = peCreateService.createContainerShape(context.getTargetContainer(), true);

        final int width = context.getWidth() <= 0 ? 100 : context.getWidth();
        final int height = context.getHeight() <= 0 ? 50 : context.getHeight();

        final Rectangle anchorRectangle = gaService.createInvisibleRectangle(containerShape);

        gaService.setLocationAndSize(anchorRectangle, context.getX(), context.getY(), width + INVISIBLE_RECT_RIGHT, height);

        RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 5, 5);

        RoundedRectangle dot = gaService.createPlainRoundedRectangle(roundedRectangle, 20, 20);

        roundedRectangle.setStyle(getStyle(targetDiagram));
        dot.setStyle(getStyle(targetDiagram));
        gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);
        gaService.setLocationAndSize(dot, 10, 10, 0, 0);

        final Shape textShape = peCreateService.createShape(containerShape, false);
        final Text stateNameText = gaService.createPlainText(textShape, (newState.getName() == null ? "" : newState.getName()));
        stateNameText.setStyle(StyleUtil.getStyleForEClassText(getDiagram()));
        stateNameText.setHorizontalAlignment(Orientation.ALIGNMENT_MIDDLE);
        gaService.setLocationAndSize(stateNameText, 28, 5, width * 6, 20);

        updateModel(targetDiagram, newState, parentInstance);
        // link(roundedRectangle, newState);
        link(containerShape, newState);
        // link(textShape, newState);

        // add a chopbox anchor to the shape
        //

        peCreateService.createChopboxAnchor(containerShape);

        // FixPointAnchor f = peCreateService.createFixPointAnchor(containerShape);

        // create an additional box relative anchor at middle-right
        final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor(containerShape);
        boxAnchor.setRelativeWidth(1.0);
        boxAnchor.setRelativeHeight(0.0); // Use golden section
        // anchor references visible rectangle instead of invisible rectangle
        boxAnchor.setReferencedGraphicsAlgorithm(dot);

        // assign a graphics algorithm for the box relative anchor
        final Ellipse ellipse = gaService.createPlainEllipse(boxAnchor);

        // anchor is located on the right border of the visible rectangle
        // and touches the border of the invisible rectangle
        gaService.setLocationAndSize(ellipse, 0, 0, 10, 10);
        ellipse.setStyle(getStyl2e(getDiagram()));

        // call the layout feature
        layoutPictogramElement(containerShape);

        return containerShape;
    }

    public static Style getStyl2e(Diagram diagram) {
        final String styleId = "E-CLASS2"; //$NON-NLS-1$
        IGaService gaService = Graphiti.getGaService();

        // this is a child style of the common-values-style
        Style parentStyle = StyleUtil.getStyleForCommonValues(diagram);
        Style style = gaService.findStyle(parentStyle, styleId);

        if ( style == null ) { // style not found - create new style
            style = gaService.createPlainStyle(parentStyle, styleId);
            style.setFilled(true);
            // style.setForeground(gaService.manageColor(diagram, IColorConstant.GRAY));
            style.setBackground(gaService.manageColor(diagram, IColorConstant.GRAY));

            // no background color here, we have a gradient instead
            // see chapter "Color Schemas" in Tutorial
            // gaService.setRenderingStyle(style, PredefinedColoredAreas.getSilverWhiteGlossAdaptions());
        }
        return style;
    }

    public static Style getStyle(Diagram diagram) {
        final String styleId = "E-CLASS"; //$NON-NLS-1$
        IGaService gaService = Graphiti.getGaService();

        // this is a child style of the common-values-style
        Style parentStyle = StyleUtil.getStyleForCommonValues(diagram);
        Style style = gaService.findStyle(parentStyle, styleId);

        if ( style == null ) { // style not found - create new style
            style = gaService.createPlainStyle(parentStyle, styleId);
            style.setFilled(true);
            style.setForeground(gaService.manageColor(diagram, IColorConstant.GRAY));
            // style.setBackground(gaService.manageColor(diagram,
            // E_CLASS_BACKGROUND));

            // no background color here, we have a gradient instead
            // see chapter "Color Schemas" in Tutorial
            gaService.setRenderingStyle(style, PredefinedColoredAreas.getSilverWhiteGlossAdaptions());
        }
        return style;
    }

    private void updateModel(Diagram targetDiagram, PSInstance newState, PSInstance parentInstance) {
        LocalContext.CONTEXT.addPSInstance(targetDiagram, newState, parentInstance);
        LocalContext.CONTEXT.save(targetDiagram);

    }

}
