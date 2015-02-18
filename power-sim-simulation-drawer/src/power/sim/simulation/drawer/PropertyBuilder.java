package power.sim.simulation.drawer;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class PropertyBuilder {

    private static final int STANDARD_LABEL_WIDTH = 85;

    private static final int VSPACE = 4;

    private static final int HSPACE = 5;

    TabbedPropertySheetWidgetFactory factory;

    Composite composite;

    FormData data;
   
    Scrollable prev = null;

    public PropertyBuilder(TabbedPropertySheetWidgetFactory factory, Composite parent) {
        this.factory = factory;
        composite = factory.createFlatFormComposite(parent);
    }

    public Text createInput(String label, final Modify modify) {
        Text text = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = getTopRef();
        text.setLayoutData(data);
        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                try {
                    modify.modify();
                } catch (IllegalStateException ex) {
                }
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, label);
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(text, -HSPACE);
        data.top = new FormAttachment(text, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        prev = text;
        return text;
    }

    public CCombo createCombo(String label, Enumerator[] options, final Modify modify) {
        String[] a =new String[options.length];
        for(int i = 0 ;i < options.length; i++){
            a[i] = options[i].getName();
        }
        return createCombo(label, a, modify);
    }
    
    

    public CCombo createCombo(String label, String[] options, final Modify modify) {
        CCombo text = factory.createCCombo(composite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = getTopRef();
        data.height = 20;
        
        for(String e: options){
            text.add(e);
        }
        text.setLayoutData(data);
        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                try {
                    modify.modify();
                } catch (IllegalStateException ex) {
                }
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, label);
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(text, -HSPACE);
        data.top = new FormAttachment(text, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        prev = text;
        return text;
    }

    public Text createTextarea(String label, final Modify modify) {
        Text text = factory.createText(composite, "", SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = getTopRef();
        data.height = 100;
        text.setLayoutData(data);
        text.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                try {
                    modify.modify();
                } catch (IllegalStateException ex) {
                }
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, label);
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(text, -HSPACE);
        data.top = new FormAttachment(text, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        prev = text;
        return text;
    }

    public static interface Modify {
        public void modify();
    }

    private FormAttachment getTopRef() {
        if ( prev == null ) {
            return new FormAttachment(0, VSPACE);
        }
        return new FormAttachment(prev, VSPACE);
    }
}
