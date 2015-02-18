package power.sim.simulation.drawer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import pssimulation.PSInstance;

public class PSInstallationFilter extends AbstractPropertySectionFilter {

    @Override
    protected boolean accept(PictogramElement pictogramElement) {
        EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
        if ( eObject instanceof PSInstance ) {
            return true;
        }
        return false;
    }

}
