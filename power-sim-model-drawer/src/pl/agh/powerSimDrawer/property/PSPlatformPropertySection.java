package pl.agh.powerSimDrawer.property;

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import pl.agh.powerSimDrawer.LocalContext;
import pl.agh.powerSimDrawer.property.PropertyBuilder.Modify;
import psplatform.PSAgent;


public class PSPlatformPropertySection extends GFPropertySection implements ITabbedPropertyConstants {

//    private Text globalsText;
//
//    private Text localsText;

    private Text packageText;

    private Text idText;

    private Text nameText;
    
    PSAgent current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        idText = builder.createInput("ID:", new Modify() {
            @Override
            public void modify() {
                if ( current.getId() == null || !current.getId().equals(idText.getText()) ) {
                    //String oldName = LocalContext.CONTEXT.getFullID(current);       
                    //String newName = LocalContext.CONTEXT.getFullID(current);   
                    //LocalContext.CONTEXT.saveName(getDiagram(), oldName, newName);      
                    
                    current.setId(idText.getText());
                }
            }
        });

        packageText = builder.createInput("package:", new Modify() {
            @Override
            public void modify() {
                if ( current.getPackage() == null || !current.getPackage().equals(packageText.getText()) ) {
                    //String oldName = LocalContext.CONTEXT.getFullID(current);          
                    //String newName = LocalContext.CONTEXT.getFullID(current);   
                    //LocalContext.CONTEXT.saveName(getDiagram(), oldName, newName);
                    
                    current.setPackage(packageText.getText());
                }
            }
        });
        

        nameText = builder.createInput("name:", new Modify() {
            @Override
            public void modify() {
                if ( current.getName() == null || !current.getName().equals(nameText.getText()) ) {
                    current.setName(nameText.getText());
                }
            }
        });
//
//        localsText = builder.createTextarea("Locals:", new Modify() {
//            @Override
//            public void modify() {
//                String locals = stringify(current.getLocals());
//                if ( !locals.equals(localsText.getText()) ) {
//                    try {
//                        current.getLocals().clear();
//                    } catch (IllegalStateException e) {
//
//                    }
//                    current.getLocals().addAll(asList(localsText.getText()));
//                }
//            }
//        });
//
//        globalsText = builder.createTextarea("Globals:", new Modify() {
//            @Override
//            public void modify() {
//                String globals = stringify(current.getGlobals());
//                if ( !globals.equals(globalsText.getText()) ) {
//                    try {
//                        current.getGlobals().clear();
//                    } catch (IllegalStateException e) {
//
//                    }
//                    current.getGlobals().addAll(asList(globalsText.getText()));
//                }
//            }
//        });
    }

    @Override
    public void refresh() {
            current = LocalContext.CONTEXT.getPlatform(getDiagram());

            String id = current.getId();
            idText.setText(id == null ? "" : id);

            String pack = current.getPackage();
            packageText.setText(pack == null ? "" : pack);
            
            String name = current.getName();
            nameText.setText(name == null ? "" : name);

//            localsText.setText(stringify(current.getLocals()));
//
//            globalsText.setText(stringify(current.getGlobals()));
       
    }

//    private static final String SEPARATOR = "\n";
//
//    private String stringify(List<String> list) {
//        if ( list == null || list.isEmpty() ) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        boolean first = true;
//        for (String part : list) {
//            if ( first ) {
//                first = false;
//            } else {
//                sb.append(SEPARATOR);
//            }
//            sb.append(part);
//        }
//        return sb.toString();
//    }
//
//    private List<String> asList(String properties) {
//        properties = properties.replace("\r", "");
//        if ( StringUtils.isBlank(properties) ) {
//            return new ArrayList<String>();
//        }
//        List<String> list = new ArrayList<String>();
//        String[] parts = properties.split(SEPARATOR);
//        for (String part : parts) {
//            if ( StringUtils.isNotBlank(part) ) {
//                list.add(StringUtils.trimToEmpty(part));
//            }
//        }
//        return list;
//    }

}
