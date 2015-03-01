package power.sim.simulation.drawer;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import power.sim.simulation.drawer.PropertyBuilder.Modify;
import pssimulation.PSSimulation;

public class PSSimulationPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private Text nameText;

    private Text idText;

    private Text descText;

    private Text startT;

    private Text endT;

    private Text stepT;

    volatile PSSimulation current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        idText = builder.createInput("ID:", new Modify() {
            @Override
            public void modify() {
                if ( current.getId() == null || !current.getId().equals(idText.getText()) ) {
                    current.setId(idText.getText());
                }
            }
        });

        nameText = builder.createInput("NAME:", new Modify() {
            @Override
            public void modify() {
                if ( current.getName() == null || !current.getName().equals(nameText.getText()) ) {
                    current.setName(nameText.getText());
                }
            }
        });
        descText = builder.createTextarea("Description:", new Modify() {

            @Override
            public void modify() {
                if ( current.getDescription() == null || !current.getDescription().equals(descText.getText()) ) {
                    current.setDescription(descText.getText());
                }

            }
        });

        startT = builder.createInput("Start Time:", new Modify() {

            @Override
            public void modify() {
                if ( current.getSimulationStartDate() == null || !current.getSimulationStartDate().equals(startT.getText()) ) {
                    current.setSimulationStartDate(startT.getText());
                }

            }
        });

        endT = builder.createInput("End Time:", new Modify() {

            @Override
            public void modify() {
                if ( current.getSimulationEndDate() == null || !current.getSimulationEndDate().equals(endT.getText()) ) {
                    current.setSimulationEndDate(endT.getText());
                }

            }
        });

        stepT = builder.createInput("Step:", new Modify() {

            @Override
            public void modify() {
                if ( current.getSimulationStep() == null || !current.getSimulationStep().equals(stepT.getText()) ) {
                    current.setSimulationStep(stepT.getText());
                }

            }
        });

    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if ( pe != null ) {

            current = LocalContext.CONTEXT.getSimulation(getDiagram());

            if ( current == null ) {
                return;
            }

            String name = current.getName();
            nameText.setText(name == null ? "" : name);

            String id = current.getId();
            idText.setText(id == null ? "" : id);

            String desc = current.getDescription();
            descText.setText(desc == null ? "" : desc);

            String start = current.getSimulationStartDate();
            startT.setText(start == null ? "" : start);

            String end = current.getSimulationEndDate();
            endT.setText(end == null ? "" : end);

            String step = current.getSimulationStep();
            stepT.setText(step == null ? "" : step);

        }
    }

}
