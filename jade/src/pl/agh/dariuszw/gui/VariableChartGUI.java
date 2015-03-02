package pl.agh.dariuszw.gui;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.joda.time.DateTime;

import pl.agh.dariuszw.StorageAgent;
import pl.agh.dariuszw.variable.Variable;

public class VariableChartGUI extends JFrame {

    private final StorageAgent storageAgent;

    private final List<String> allowedStates = new ArrayList<String>();

    private final String instanceID;

    private final TimeSeriesCollection dataSet = new TimeSeriesCollection();

    private final JFreeChart chart;

    public VariableChartGUI(final String instanceID, final Variable variable, final StorageAgent storageAgent, Map<DateTime, String> values) {
        super(instanceID);

        this.instanceID = instanceID;
        this.storageAgent = storageAgent;

        final DateAxis xAxis = new DateAxis("date");
        xAxis.setDateFormatOverride(new SimpleDateFormat("MM-dd HH:mm"));
        //
        final ValueAxis yAxis = doMagic(variable, values);// new SymbolAxis("Symbol", states);
        //
        final XYItemRenderer renderer = new XYShapeRenderer();
        final XYPlot plot = new XYPlot(dataSet, xAxis, yAxis, renderer);
        chart = new JFreeChart("Variable " + variable.getKey() + " -> " + instanceID, new Font("Tahoma", 0, 18), plot, true);

        chart.getLegend().setVisible(false);

        setContentPane(new ChartPanel(chart));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                VariableChartGUI.this.storageAgent.disposeVariableChart(instanceID);
            }
        });
    }

    private ValueAxis doMagic(Variable variable, Map<DateTime, String> values) {
        if ( variable == null ) {
            return null;
        }
        if ( variable.getType() == Variable.Type.DATE ) {
            DateAxis axis = new DateAxis("Value");
            axis.setDateFormatOverride(new SimpleDateFormat("MM-dd HH:mm"));
            TimeSeries series = new TimeSeries("");
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                series.add(new Minute(val.getKey().toDate()), Variable.DATE_TYPE_FORMATTER.parseDateTime(val.getValue()).toDate().getTime());
            }
            dataSet.addSeries(series);
            return axis;
        }
        if ( variable.getType() == Variable.Type.TIME ) {
            DateAxis axis = new DateAxis("Value");
            axis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
            TimeSeries series = new TimeSeries("");
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                series.add(new Minute(val.getKey().toDate()), Variable.TIME_TYPE_FORMATTER.parseDateTime(val.getValue()).toDate().getTime());
            }
            dataSet.addSeries(series);
            return axis;
        }
        if ( variable.getType() == Variable.Type.BOOLEAN ) {
            SymbolAxis axis = new SymbolAxis("Value", new String[] { "true", "false" });
            TimeSeries series = new TimeSeries("");
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                series.add(new Minute(val.getKey().toDate()), Boolean.parseBoolean(val.getValue()) ? 0 : 1);
            }
            dataSet.addSeries(series);
            return axis;
        }
        if ( variable.getType() == Variable.Type.FLOAT || variable.getType() == Variable.Type.INTEGER ) {
            NumberAxis axis = new NumberAxis();
            TimeSeries series = new TimeSeries("");
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                series.add(new Minute(val.getKey().toDate()), Float.parseFloat(val.getValue()));
            }
            dataSet.addSeries(series);
            return axis;
        }
        if ( variable.getType() == Variable.Type.STRING ) {
            Set<String> valueSet = new LinkedHashSet<String>();
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                valueSet.add(val.getValue());
            }
            List<String> valueList = new ArrayList<String>(valueSet);

            SymbolAxis axis = new SymbolAxis("Value", valueList.toArray(new String[valueList.size()]));
            TimeSeries series = new TimeSeries("");
            for (Map.Entry<DateTime, String> val : values.entrySet()) {
                series.add(new Minute(val.getKey().toDate()), valueList.indexOf(val.getValue()));
            }
            dataSet.addSeries(series);
            return axis;
        }

        return null;
    }

    // public void appendValue(DateTime time, String value) {
    //
    // }

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
