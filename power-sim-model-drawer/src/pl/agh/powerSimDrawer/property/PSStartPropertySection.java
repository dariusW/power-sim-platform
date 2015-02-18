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
import psplatform.PSStart;
import psplatform.PsplatformFactory;

public class PSStartPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private Text onInitText;
    
    PSStart current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        onInitText = builder.createTextarea("onInit:", new Modify() {
            @Override
            public void modify() {
                if ( current.getOnInit() == null || current.getOnInit().getOnAction() == null || !current.getOnInit().getOnAction().equals(onInitText.getText()) ) {
                    if(current.getOnInit() == null){
                        current.setOnInit(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
                    }
                    current.getOnInit().setOnAction(onInitText.getText());
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

            current = ((PSStart) bo);


            String onInit = current.getOnInit() == null ? "" : current.getOnInit().getOnAction();
            onInitText.setText(onInit == null ? "" : onInit);
        }
    }

}
