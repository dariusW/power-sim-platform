package pl.agh.dariuszw.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.ui.ApplicationFrame;
import org.joda.time.DateTime;
import org.joda.time.Period;

import pl.agh.dariuszw.StorageAgent;
import pl.agh.dariuszw.Utils;

/**
 * Created by dariuszw on 2015-03-01.
 */
public class SummaryGUI extends ApplicationFrame {

    StorageAgent storage;

    public SummaryGUI(final StorageAgent storage) {
        super(storage.getLocalName());
        this.storage = storage;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 2));

        p.add(new JLabel("SIMULATION NAME:"));
        p.add(new JLabel(storage.getSimulationID()));

        p.add(new JLabel("EXECUTION:"));
        DateTime executionStart = new DateTime(storage.getExecutionDate());
        p.add(new JLabel(Utils.DEFAULT_TIME_FORMATTER.print(executionStart)));

        Period durationPeriod = new Period(executionStart, new DateTime());
        p.add(new JLabel("DURATION:"));
        p.add(new JLabel(durationPeriod.toString()));

        p.add(new JLabel("SIMULATION STEP:"));
        p.add(new JLabel(storage.getStep().toString()));

        p.add(new JLabel("SIMULATION START:"));
        p.add(new JLabel(Utils.DEFAULT_TIME_FORMATTER.print(new DateTime(storage.getSimulationStart()))));

        p.add(new JLabel("SIMULATION END:"));
        p.add(new JLabel(Utils.DEFAULT_TIME_FORMATTER.print(new DateTime(storage.getSimulationEnd()))));

        getContentPane().add(p, BorderLayout.CENTER);
        setResizable(false);

        // Make the agent terminate when the user closes
        // the GUI using the button on the upper right corner
        addWindowListener(new	WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                storage.doDelete();
            }
        } );

    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }

}
