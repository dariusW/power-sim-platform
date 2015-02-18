package power.sim.simulation.drawer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import power.sim.simulation.drawer.PropertyBuilder.Modify;
import pssimulation.PSInstance;

public class PSInstallationPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private CCombo idText;

    private Text iidText;

    private Text nameText;

    private Text initText;

    PSInstance current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        iidText = builder.createInput("ID:", new Modify() {
            @Override
            public void modify() {
                if ( current.getId() == null || !current.getId().equals(iidText.getText()) ) {
                    current.setId(iidText.getText());
                }
            }
        });

        nameText = builder.createInput("Name:", new Modify() {
            @Override
            public void modify() {
                if ( current.getName() == null || !current.getName().equals(nameText.getText()) ) {
                    current.setName(nameText.getText());
                }
            }
        });

        idText = builder.createCombo("Model:", getIDs(), new Modify() {
            @Override
            public void modify() {
                if ( current.getModelClass() == null || !current.getModelClass().equals(idText.getText()) ) {
                    try {
                        current.setModelClass(idText.getText());
                    } catch (Exception e) {
                        try {
                            current.setModelPath(getPath(idText.getText()));
                        } catch (Exception e2) {

                        }
                    }
                }
            }
        });

        initText = builder.createTextarea("init:", new Modify() {
            @Override
            public void modify() {
                if ( current.getInitBehaviour() == null || !current.getInitBehaviour().equals(initText.getText()) ) {
                    current.setInitBehaviour(initText.getText());
                }
            }
        });

    }

    private String getPath(String key) {
        try {
            File propertyFile = new File(LocalContext.getBasePath() + "/models.properties");
            if ( !propertyFile.exists() ) {
                propertyFile.createNewFile();
            }
            FileInputStream inputStream = new FileInputStream(propertyFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

            return properties.getProperty(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String[] getIDs() {
        try {
            if ( "".equals(LocalContext.getBasePath()) ) {
                return new String[] {};
            }
            File propertyFile = new File(LocalContext.getBasePath() + "/models.properties");
            if ( !propertyFile.exists() ) {
                return new String[] {};
            }
            FileInputStream inputStream = new FileInputStream(propertyFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

            return properties.keySet().toArray(new String[] {});

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[] {};
    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if ( pe != null ) {
            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if ( bo == null )
                return;

            current = ((PSInstance) bo);

            String classs = current.getModelClass();
            idText.setText(classs == null ? "" : classs);

            String id = current.getId();
            iidText.setText(id == null ? "" : id);

            String name = current.getName();
            nameText.setText(name == null ? "" : name);

            String init = current.getInitBehaviour();
            initText.setText(init == null ? "" : init);
        }
    }

}
