package pl.agh.dariuszw.gui;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.joda.time.DateTime;

import pl.agh.dariuszw.StorageAgent;

public class StateChartGUI extends JFrame {

    private final StorageAgent storageAgent;

    private final List<String> allowedStates = new ArrayList<String>();

    private final String instanceID;

    private final TimeSeriesCollection dataSet = new TimeSeriesCollection();

    private List<TimeSeries> allTimeSeries = new ArrayList<TimeSeries>();

    private final JFreeChart chart;

    public StateChartGUI(final String instanceID, final StorageAgent storageAgent, String[] states) {
        super(instanceID);

        this.instanceID = instanceID;
        this.storageAgent = storageAgent;
        allowedStates.addAll(Arrays.asList(states));

        final DateAxis xAxis = new DateAxis("date");
        xAxis.setDateFormatOverride(new SimpleDateFormat("MM-dd HH:mm"));

        final ValueAxis yAxis = new SymbolAxis("Symbol", states);

        final XYItemRenderer renderer = new XYShapeRenderer();
        final XYPlot plot = new XYPlot(dataSet, xAxis, yAxis, renderer);
        chart = new JFreeChart("State Chart of " + instanceID, new Font("Tahoma", 0, 18), plot, true);

        chart.getLegend().setVisible(false);

        setContentPane(new ChartPanel(chart));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                storageAgent.disposeStateChart(instanceID);
            }
        });
    }

    public void appendState(DateTime time, String state) {
        if ( allTimeSeries.isEmpty() ) {
            TimeSeries series = new TimeSeries("");
            dataSet.addSeries(series);
            allTimeSeries.add(series);
        }
        Minute timeSeriesItem = new Minute(time.toDate());

        int index = 0;
        TimeSeriesDataItem storedItem = allTimeSeries.get(index).getDataItem(timeSeriesItem);
        while (storedItem != null) {
            index++;
            if ( allTimeSeries.size() == index ) {
                TimeSeries series = new TimeSeries("");
                dataSet.addSeries(series);
                allTimeSeries.add(series);
                break;
            }
            storedItem = allTimeSeries.get(index).getDataItem(timeSeriesItem);
        }
        allTimeSeries.get(index).add(timeSeriesItem, allowedStates.indexOf(state));
        // System.err.println(allowedStates.indexOf(state));
    }

    public void showGUI() {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // public static void main(String[] args) {
    // StateChartGUI gui = new StateChartGUI("testInstance", null, new String[] {"UNO", "DOS" , "TRES"});
    //
    // DateTime baseDate = new DateTime();
    // gui.appendState(baseDate, "UNO");
    // gui.appendState(baseDate.plusDays(1), "UNO");
    // gui.appendState(baseDate.plusDays(1), "DOS");
    // gui.appendState(baseDate.plusDays(2), "DOS");
    // gui.appendState(baseDate.plusDays(3), "DOS");
    // gui.appendState(baseDate.plusDays(4), "UNO");
    // gui.appendState(baseDate.plusDays(4), "TRES");
    //
    //
    // gui.showGUI();
    // }
}
