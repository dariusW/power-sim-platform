package power.sim.simulation.drawer;

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
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import pssimulation.PSHierarchy;
import pssimulation.PSInstance;

public class AddInstallationConnectionFeature extends AbstractAddFeature implements IAddFeature {

    private static final IColorConstant PSTRANZITION_COLOR = IColorConstant.BLACK;

    public AddInstallationConnectionFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && context.getNewObject() instanceof PSHierarchy;
    }

    @Override
    public PictogramElement add(IAddContext context) {
        IAddConnectionContext addConContext = (IAddConnectionContext) context;

        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        IGaService gaService = Graphiti.getGaService();

        Connection connection = peCreateService.createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
        
        PSInstance start = getBO(addConContext.getSourceAnchor());
        PSInstance end = getBO(addConContext.getTargetAnchor());

        PSHierarchy PSHierarchy = (PSHierarchy)context.getNewObject();
        LocalContext.CONTEXT.addPSHierarchy(getDiagram(), PSHierarchy, start, end);
        //LocalContext.CONTEXT.save();

        Polyline polyline = gaService.createPlainPolyline(connection);
        polyline.setForeground(manageColor(IColorConstant.BLACK));
        
        link(connection, PSHierarchy);

        ConnectionDecorator cd;
        cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
        createArrow(cd);
        
        LocalContext.CONTEXT.save(getDiagram());

        return connection;
    }

    private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
        IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPlainPolyline(gaContainer, new int[] { -30, 0, -15, 10, 0, 0, -15, -10, -30, 0 });
        polyline.setForeground(manageColor(PSTRANZITION_COLOR));
        polyline.setBackground(manageColor(PSTRANZITION_COLOR));
        polyline.setFilled(true);
        polyline.setLineWidth(2);
        return polyline;
    }

    private PSInstance getBO(Anchor anchor) {
        if ( anchor != null ) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());
            if ( object instanceof PSInstance ) {
                return (PSInstance) object;
            }
        }
        return null;
    }

}
