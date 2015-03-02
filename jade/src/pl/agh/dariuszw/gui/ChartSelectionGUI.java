package pl.agh.dariuszw.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.MutableComboBoxModel;

import pl.agh.dariuszw.StorageAgent;

/**
 * Created by dariuszw on 2015-03-01.
 */
public class ChartSelectionGUI extends JFrame {

    MutableComboBoxModel instanceComboBoxModel = new DefaultComboBoxModel<String>();

    JComboBox<String> instanceComboBox = new JComboBox<String>(instanceComboBoxModel);

    JComboBox<String> variableComboBox = new JComboBox<String>();

    Map<String, Set<String>> instanceUniquenessMap = new HashMap<String, Set<String>>();

    Map<String, MutableComboBoxModel<String>> instanceVariableComboBoxModelMap = new HashMap<String, MutableComboBoxModel<String>>();

    JButton showStateChartButton = new JButton("STATE CHART");

    JButton showConsumptionChartButton = new JButton("POWER CHART");

    JButton showVariableChartButton = new JButton("VARIABLE CHART");

    private StorageAgent storageAgent;

    public ChartSelectionGUI(final StorageAgent storageAgent) {
        super("CHART SELECTION");

        this.storageAgent= storageAgent;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1));

        p.add(new JLabel("SELECT CHART TO DISPLAY"));
        p.add(instanceComboBox);
        p.add(showStateChartButton);
        p.add(showConsumptionChartButton);
        p.add(variableComboBox);
        p.add(showVariableChartButton);

        showConsumptionChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instanceID = (String) instanceComboBoxModel.getSelectedItem();
                
                if(instanceID != null){
                    storageAgent.openPowerChart(instanceID);
                }
            }
        });
        showStateChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instanceID = (String) instanceComboBoxModel.getSelectedItem();

                if(instanceID != null){
                    storageAgent.openStateChart(instanceID);
                }
            }
        });
        showVariableChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instanceID = (String) instanceComboBoxModel.getSelectedItem();
                String variableKey = (String) variableComboBox.getModel().getSelectedItem();

                if(instanceID != null && variableKey != null){
                    storageAgent.openVariableChart(instanceID, variableKey);
                }
            }
        });

        getContentPane().add(p, BorderLayout.CENTER);

        instanceComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedInstanceId = (String) instanceComboBoxModel.getSelectedItem();

                MutableComboBoxModel variableModel = instanceVariableComboBoxModelMap.get(selectedInstanceId);
                if ( variableModel != null ) {
                    variableComboBox.setModel(variableModel);
                }
            }
        });
        // setResizable(false);

    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2 + 400;
        int centerY = (int) screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }

    public void registerInstance(String instanceID) {

        instanceComboBoxModel.addElement(instanceID);
        // instanceComboBox.updateUI();

    }

    public void registerVariable(String instanceID, String variableKey) {
        MutableComboBoxModel model = instanceVariableComboBoxModelMap.get(instanceID);
        if ( model == null ) {
            model = new DefaultComboBoxModel<String>();
            instanceUniquenessMap.put(instanceID, new HashSet<String>());
            instanceVariableComboBoxModelMap.put(instanceID, model);
        }

        Set<String> uniqueSet = instanceUniquenessMap.get(instanceID);
        if ( !uniqueSet.contains(variableKey) ) {
            uniqueSet.add(variableKey);
            model.addElement(variableKey);
        }
    }
}
