package pl.agh.dariuszw.gui;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.joda.time.DateTime;

import pl.agh.dariuszw.StorageAgent;

import javax.swing.JFrame;

/**
 * Created by dariuszw on 2015-03-01.
 */
public class PowerChartGUI extends JFrame {

    private TimeSeries powerSeries;

    private TimeSeries workSeries;

    private StorageAgent storageAgent;

    private String instanceID;

    public PowerChartGUI(final String instanceID, final StorageAgent storageAgent) {

        super(instanceID);

        this.instanceID = instanceID;
        this.storageAgent = storageAgent;

        // create a title...
        final String chartTitle = "Power Consumption Chart of: " + instanceID;
        final XYDataset dataset = createDataset1();

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(chartTitle, "Date", "Power [W]", dataset, true, true, false);

        // final StandardLegend legend = (StandardLegend) chart.getLegend();
        // legend.setDisplaySeriesShapes(true);

        final XYPlot plot = chart.getXYPlot();
        final NumberAxis axis2 = new NumberAxis("Consumption [kWh]");
        axis2.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(1, axis2);
        plot.setDataset(1, createDataset2());
        plot.mapDatasetToRangeAxis(1, 1);
        final XYItemRenderer renderer = plot.getRenderer();
        renderer.setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        if ( renderer instanceof StandardXYItemRenderer ) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            // rr.setPlotShapes(true);
            rr.setShapesFilled(true);
        }

        final StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.black);
        // renderer2.setPlotShapes(true);
        renderer.setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        plot.setRenderer(1, renderer2);

        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MM-dd HH:mm"));

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                storageAgent.disposePowerChart(instanceID);
            }
        });

    }

    private XYDataset createDataset1() {

        powerSeries = new TimeSeries("Power");

        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(powerSeries);

        return dataset;

    }

    private XYDataset createDataset2() {

        workSeries = new TimeSeries("Work");

        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(workSeries);

        return dataset;

    }

    public void appendPower(DateTime time, int power) {
        powerSeries.add(new Minute(time.toDate()), (double) power);
    }

    double totalConsumption = 0.0;

    public void appendConsumption(DateTime time, double consumption) {
        totalConsumption += consumption;
        workSeries.add(new Minute(time.toDate()), totalConsumption);
    }

    public void showChart(){
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

}
