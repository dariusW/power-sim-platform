package pl.agh.powerSimDrawer.property;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import pl.agh.powerSimDrawer.property.PropertyBuilder.Modify;
import psplatform.PSTransition;

public class PSTransitionPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private Text conditionText;
    
    PSTransition current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        conditionText = builder.createTextarea("condition:", new Modify() {
            @Override
            public void modify() {
                if ( current.getCondition() == null || !current.getCondition().equals(conditionText.getText()) ) {
                    current.setCondition(conditionText.getText());
                }
            }
        });
    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if ( pe != null ) {
            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if ( bo == null )
                return;

            current = ((PSTransition) bo);


            String condition = current.getCondition();
            conditionText.setText(condition == null ? "" : condition);
        }
    }

}
