package id.co.telkomsigma.tgf.swing.component.chart;

import id.co.telkomsigma.tgf.swing.component.exception.TGFSwingException;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

import java.util.List;

/**
 * Created on 5/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <DATA>
 */
public interface IChartGenerator<DATA> {

    void insertDataSet(List<DATA> dataSetList);

    Dataset getDataSet() throws TGFSwingException;

    JFreeChart getChart(String p_ChartTitle, Dataset p_DataSet);
}
