package power.sim.simulation.drawer;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;

public class PSSimulationToolBehaviourProvider extends DefaultToolBehaviorProvider {

    public PSSimulationToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
        super(diagramTypeProvider);
    }

    @Override
    public IContextMenuEntry[] getContextMenu(ICustomContext context) { 
        // create a sub-menu for all custom features
        ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
        subMenu.setText("Simulation");
        subMenu.setDescription("Simulation features submenu");
        // display sub-menu hierarchical or flat
        subMenu.setSubmenu(true);

        // create a menu-entry in the sub-menu for each custom feature
        ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
        for (int i = 0; i < customFeatures.length; i++) {
            ICustomFeature customFeature = customFeatures[i];
            if ( customFeature.isAvailable(context) ) {
                ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
                subMenu.add(menuEntry);
            }
        }

        IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenu };
        return ret;
    }

}
