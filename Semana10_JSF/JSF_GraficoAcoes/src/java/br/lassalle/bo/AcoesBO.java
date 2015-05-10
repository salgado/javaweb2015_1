/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lassalle.bo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author salgado
 */
@ManagedBean
@SessionScoped
public class AcoesBO implements Serializable {
 
	private static final long serialVersionUID = 1L;

    private LineChartModel model;

    public AcoesBO() {
        model = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Petrobras ON");
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Vale ON");
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.setTitle("Ações Bovespa");
        model.setLegendPosition("e");
        
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public LineChartModel getModel() {
        return model;
    }

}
