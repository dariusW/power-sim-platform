package power.sim.simulation.drawer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.management.RuntimeErrorException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.osgi.framework.Bundle;

public class RunCustomFeature extends AbstractCustomFeature {

    public RunCustomFeature(IFeatureProvider fp) {
        super(fp);
    }

    private boolean hasDoneChanges = false;

    @Override
    public String getName() {
        return "Run";
    }

    @Override
    public String getDescription() {
        return "Compile and Run simulation";
    }

    private static final String CP = ";tools.jar;commons-lang3-3.3.2.jar;h2.jar;jade.jar;javax.annotation_1.2.0.v201401042248.jar;javax.inject_1.0.0.v20091030.jar;jcommon-1.0.23.jar;jfreechart-1.0.19.jar;joda-time-2.5.jar;log4j-api-2.2.jar;log4j-core-2.2.jar;org.eclipse.core.contenttype_3.4.200.v20140207-1251.jar;org.eclipse.core.jobs_3.6.0.v20140424-0053.jar;org.eclipse.core.runtime_3.10.0.v20140318-2214.jar;org.eclipse.emf.common_2.10.1.v20140901-1043.jar;org.eclipse.emf.ecore.xmi_2.10.1.v20140901-1043.jar;org.eclipse.emf.ecore_2.10.1.v20140901-1043.jar;org.eclipse.equinox.app_1.3.200.v20130910-1609.jar;org.eclipse.equinox.common_3.6.200.v20130402-1505.jar;org.eclipse.equinox.preferences_3.5.200.v20140224-1527.jar;org.eclipse.equinox.registry_3.5.400.v20140428-1507.jar;org.eclipse.osgi.compatibility.state_1.0.0.v20140403-1907.jar;org.eclipse.osgi_3.10.0.v20140606-1445.jar;power-sim-model.jar;simulation-core.jar";

    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = pes[0];
            if ( bo instanceof Diagram ) {
                
                String pathPart2 = ((Diagram) bo).eResource().getURI().toString();
                pathPart2 = pathPart2.substring(18, pathPart2.lastIndexOf(".")) + ".smodel";
                String parhPart1 = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString();
                parhPart1 = parhPart1.substring(parhPart1.indexOf(":") + 2);
                String dmodelPath = parhPart1 + pathPart2;

                String eclipsePath = File.pathSeparator + getPluginDir() + "simulation/";
                final StringBuilder command = new StringBuilder();
                command.append("java -Djava.home=\"");
                command.append(System.getenv("JAVA_HOME"));
                command.append("/jre\" -cp ");
                command.append('"');
                command.append(".");
                command.append(CP.replace(";", eclipsePath));
                //command.append(File.pathSeparator);
                //command.append(getHome());
                //command.append("/lib/*");
                //command.append(File.pathSeparator);
               // command.append(getHome());
                //command.append("/bin/*");
                command.append('"');
                command.append(" pl.agh.dariuszw.RunTime ");
                command.append(dmodelPath);
                command.append(" -gcr");

                
                
                final MessageConsole myConsole = findConsole("JADE_CONSOLE");
                final MessageConsoleStream out = myConsole.newMessageStream();

                new Thread(new Runnable() {
                    
                    @Override
                    public void run() {
                        out.println("\n-----------------------\n"+command.toString()+"\n---------------------\n");
                        
                        System.setProperty("java.home", System.getenv("JAVA_HOME"));
                        
                        final Process p;
                        try {
                            p = Runtime.getRuntime().exec(command.toString());

                            new Thread(new Runnable() {
                                public void run() {
                                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                                    String line = null;

                                    try {
                                        while ((line = input.readLine()) != null) {
                                            out.println(line);
                                        }
                                    } catch (IOException e) {
                                        out.println(e.getMessage());
                                        throw new RuntimeException(e);
                                    }
                                }
                            }).start();

                            new Thread(new Runnable() {
                                public void run() {
                                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                    String line = null;

                                    try {
                                        while ((line = input.readLine()) != null) {
                                            out.println(line);
                                        }
                                    } catch (IOException e) {
                                        out.println(e.getMessage());
                                        throw new RuntimeException(e);
                                    }
                                }
                            }).start();

                            p.waitFor();
                        } catch (IOException e) {
                            out.println(e.getMessage());
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            out.println(e.getMessage());
                            throw new RuntimeException(e);
                        }
                        
                    }
                }).start();
                

                this.hasDoneChanges = true;
            }
        }
    }

    private Object getHome() {
        return System.getenv("JAVA_HOME").replace("\\", "/");
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if ( pes != null && pes.length == 1 ) {
            Object bo = pes[0];
            if ( bo instanceof Diagram ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasDoneChanges() {
        return this.hasDoneChanges;
    }

    public static String getPluginDir() {
        String pluginId = System.getProperty("eclipse.home.location");
        return pluginId.substring(pluginId.indexOf(":") + 2);
    }

    private MessageConsole findConsole(String name) {
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++)
            if ( name.equals(existing[i].getName()) )
                return (MessageConsole) existing[i];
        // no console found, so create a new one
        MessageConsole myConsole = new MessageConsole(name, null);
        conMan.addConsoles(new IConsole[] { myConsole });
        return myConsole;
    }
}
