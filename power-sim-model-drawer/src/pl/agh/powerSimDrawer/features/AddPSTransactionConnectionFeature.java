package pl.agh.powerSimDrawer.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import pl.agh.powerSimDrawer.LocalContext;
import psplatform.PSState;
import psplatform.PSTransition;

public class AddPSTransactionConnectionFeature extends AbstractAddFeature implements IAddFeature {

    private static final IColorConstant PSTRANZITION_COLOR = IColorConstant.BLACK;

    public AddPSTransactionConnectionFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && context.getNewObject() instanceof PSTransition;
    }

    @Override
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;

        PSTransition transition = (PSTransition) context.getNewObject();

        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        IGaService gaService = Graphiti.getGaService();

        Connection connection = peCreateService.createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
        
        PSState start = getBO(addConContext.getSourceAnchor());
        PSState end = getBO(addConContext.getTargetAnchor());

        Diagram targetDiagram = (Diagram) getDiagram();
        LocalContext.CONTEXT.addTransition(targetDiagram, transition, start, end);
        LocalContext.CONTEXT.save(targetDiagram);
        
        Polyline polyline = gaService.createPlainPolyline(connection);
        polyline.setForeground(manageColor(IColorConstant.BLACK));

        link(connection, transition);

        ConnectionDecorator cd;
        cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
        createArrow(cd);

        return connection;
    }

    private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
        IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15, -10 });
        polyline.setForeground(manageColor(PSTRANZITION_COLOR));
        polyline.setLineWidth(2);
        return polyline;
    }

    private PSState getBO(Anchor anchor) {
        if ( anchor != null ) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());
            if ( object instanceof PSState ) {
                return (PSState) object;
            }
        }
        return null;
    }

}
