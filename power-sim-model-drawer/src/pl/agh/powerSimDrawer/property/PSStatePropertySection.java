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
import psplatform.PSState;
import psplatform.PsplatformFactory;

public class PSStatePropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private Text nameText;

    private Text idText;

    private Text onEntryText;

    private Text onExitText;

    private Text onStepText;

    PSState current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        idText = builder.createInput("ID:", new Modify() {
            @Override
            public void modify() {
                if ( !current.getId().equals(idText.getText()) ) {
                    current.setId(idText.getText());
                }
            }
        });

        nameText = builder.createInput("Name:", new Modify() {
            @Override
            public void modify() {
                if ( !current.getName().equals(nameText.getText()) ) {
                    current.setName(nameText.getText());
                }
            }
        });

        onEntryText = builder.createTextarea("onEntry:", new Modify() {
            @Override
            public void modify() {
                if ( current.getOnEntry() == null || current.getOnEntry().getOnAction() == null || !current.getOnEntry().getOnAction().equals(onEntryText.getText()) ) {
                    if(current.getOnEntry() == null){
                        current.setOnEntry(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
                    }
                    current.getOnEntry().setOnAction(onEntryText.getText());
                }
            }
        });

        onStepText = builder.createTextarea("onStep:", new Modify() {
            @Override
            public void modify() {
                if ( current.getOnStep() == null || current.getOnStep().getOnAction() == null || !current.getOnStep().getOnAction().equals(onStepText.getText()) ) {
                    if(current.getOnStep() == null){
                        current.setOnStep(PsplatformFactory.eINSTANCE.createPSContinuousBehaviour());
                    }
                    current.getOnStep().setOnAction(onStepText.getText());
                }
            }
        });

        onExitText = builder.createTextarea("onExit:", new Modify() {
            @Override
            public void modify() {
                if ( current.getOnExit() == null || current.getOnExit().getOnAction() == null || !current.getOnExit().getOnAction().equals(onExitText.getText()) ) {
                    if(current.getOnExit() == null){
                        current.setOnExit(PsplatformFactory.eINSTANCE.createPSSingleBehaviour());
                    }
                    current.getOnExit().setOnAction(onExitText.getText());
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

            current = ((PSState) bo);

            String name = current.getName();
            nameText.setText(name == null ? "" : name);
            
             String onEntry = current.getOnEntry() == null ? "" : current.getOnEntry().getOnAction();
             onEntryText.setText(onEntry == null ? "" : onEntry);
            
             String onStep = current.getOnStep() == null ? "" : current.getOnStep().getOnAction();
             onStepText.setText(onStep == null ? "" : onStep);
            
             String onExit = current.getOnExit() == null ? "" : current.getOnExit().getOnAction();
             onExitText.setText(onExit == null ? "" : onExit);
        }
    }

}
