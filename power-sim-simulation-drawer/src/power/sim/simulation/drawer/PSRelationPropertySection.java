package power.sim.simulation.drawer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import power.sim.simulation.drawer.PropertyBuilder.Modify;
import pssimulation.PSComunication;

public class PSRelationPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private CCombo pubVar;

    private CCombo extVar;

    volatile PSComunication current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        pubVar = builder.createCombo("Public variable:", getPublic(), new Modify() {
            @Override
            public void modify() {
                if ( current.getPublicVariable() == null || !current.getPublicVariable().equals(pubVar.getText()) ) {
                    try {
                        current.setPublicVariable(pubVar.getText());
                    } catch (Exception e) {
                    }
                }
            }
        });
        extVar = builder.createCombo("Exteranal variable:", getExternal(), new Modify() {
            @Override
            public void modify() {
                if ( current.getExernalVariable() == null || !current.getExernalVariable().equals(extVar.getText()) ) {
                    try {
                        current.setExernalVariable(extVar.getText());
                    } catch (Exception e) {
                    }
                }
            }
        });

    }

    private String[] getPublic() {
        try {
            if ( current == null || current.getBegin() == null ) {
                return new String[] {};
            }
            if ( "".equals(LocalContext.getBasePath()) ) {
                return new String[] {};
            }
            File propertyFile = new File(LocalContext.getBasePath() + "/public.properties");
            if ( !propertyFile.exists() ) {
                return new String[] {};
            }
            FileInputStream inputStream = new FileInputStream(propertyFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

            String classs = current.getBegin().getModelClass();
            ArrayList<String> list = new ArrayList<String>();
            for (Object item : properties.keySet()) {
                String propClass = properties.getProperty((String) item);
                if ( propClass.equals(classs) ) {
                    list.add((String) item);
                }
            }

            return list.toArray(new String[] {});

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[] {};
    }

    private String[] getExternal() {
        try {
            if ( current == null || current.getBegin() == null ) {
                return new String[] {};
            }
            if ( "".equals(LocalContext.getBasePath()) ) {
                return new String[] {};
            }
            File propertyFile = new File(LocalContext.getBasePath() + "/external.properties");
            if ( !propertyFile.exists() ) {
                return new String[] {};
            }
            FileInputStream inputStream = new FileInputStream(propertyFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

            String classs = current.getEnd().getModelClass();
            ArrayList<String> list = new ArrayList<String>();
            for (Object item : properties.keySet()) {
                String propClass = properties.getProperty((String) item);
                if ( propClass.equals(classs) ) {
                    list.add((String) item);
                }
            }

            return list.toArray(new String[] {});

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[] {};
    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if ( pe != null ) {

            Object obj = (PSComunication) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

            if ( obj == null ) {
                return;
            }

            current = (PSComunication) obj;

            String pub = current.getPublicVariable();
            pubVar.setText(pub == null ? "" : pub);

            pubVar.setItems(getPublic());

            String ext = current.getExernalVariable();
            extVar.setText(ext == null ? "" : ext);

            extVar.setItems(getExternal());

        }
    }

}
