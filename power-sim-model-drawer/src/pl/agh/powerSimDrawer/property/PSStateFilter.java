package pl.agh.powerSimDrawer.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import psplatform.PSStart;
import psplatform.PSState;

public class PSStateFilter extends AbstractPropertySectionFilter {

    @Override
    protected boolean accept(PictogramElement pictogramElement) {
        EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
        if ( eObject instanceof PSState && !(eObject instanceof PSStart) ) {
            return true;
        }
        return false;
    }

}
