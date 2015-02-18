package pl.agh.powerSimDrawer.property;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import pl.agh.powerSimDrawer.property.PropertyBuilder.Modify;
import psplatform.PSVariable;
import psplatform.PSVariableScope;
import psplatform.PSVariableType;

public class PSVariablePropertySection extends GFPropertySection implements ITabbedPropertyConstants {

    private CCombo typeText;

    private CCombo scopeText;

    private Text keyText;

    private Text defaultText;

    PSVariable current;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();

        PropertyBuilder builder = new PropertyBuilder(factory, parent);

        keyText = builder.createInput("Key:", new Modify() {
            @Override
            public void modify() {
                if ( current.getKey() == null || !current.getKey().equals(keyText.getText()) ) {
                    current.setKey(keyText.getText());
                }
            }
        });

        defaultText = builder.createInput("Default:", new Modify() {
            @Override
            public void modify() {
                if ( current.getDefault() == null || !current.getDefault().equals(defaultText.getText()) ) {
                    current.setDefault(defaultText.getText());
                }
            }
        });

        scopeText = builder.createCombo("Scope:", PSVariableScope.values() ,new Modify() {
            @Override
            public void modify() {
                if ( current.getScope() == null || !current.getScope().toString().equals(scopeText.getText()) ) {
                    PSVariableScope s = PSVariableScope.getByName(scopeText.getText());
                    if ( s != null ) {
                        current.setScope(s);
                    }
                }
            }
        });

        typeText = builder.createCombo("Type:", PSVariableType.values(),  new Modify() {
            @Override
            public void modify() {

                if ( current.getType() == null || !current.getType().toString().equals(typeText.getText()) ) {
                    PSVariableType s = PSVariableType.getByName(typeText.getText());
                    if ( s != null ) {
                        current.setType(s);
                    }
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

            current = ((PSVariable) bo);

            String key = current.getKey();
            keyText.setText(key == null ? "" : key);

            String def = (String)current.getDefault();
            defaultText.setText(def == null ? "" : def);

            String scope = current.getScope().toString();
            scopeText.setText(scope);

            String type = current.getType().toString();
            typeText.setText(type);
        }
    }

}
