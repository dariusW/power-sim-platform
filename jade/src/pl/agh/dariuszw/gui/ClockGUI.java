package pl.agh.dariuszw.gui;

import pl.agh.dariuszw.ClockAgent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by dariuszw on 2014-12-28.
 */
public class ClockGUI extends JFrame{
    private ClockAgent clockAgent;

    private JProgressBar progressBar;
    JLabel currentTime;


    public ClockGUI(final ClockAgent clockAgent) {
        super(clockAgent.getLocalName());

        this.clockAgent = clockAgent;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        p.add(new JLabel("TIME:"));
        currentTime = new JLabel(clockAgent.getCurrentTime());
        p.add(currentTime);

        getContentPane().add(p, BorderLayout.CENTER);

        progressBar = new JProgressBar();

        getContentPane().add(progressBar, BorderLayout.SOUTH);

        // Make the agent terminate when the user closes 
        // the GUI using the button on the upper right corner	
//        addWindowListener(new	WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                clockAgent.doDelete();
//            }
//        } );

        setResizable(false);
    }

    public void updateProgress(int state){
        progressBar.setValue(state);
    }

    public void updateTime(String time){
        currentTime.setText(time);
        currentTime.updateUI();
    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int)screenSize.getWidth() / 2 - 400;
        int centerY = (int)screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
}
