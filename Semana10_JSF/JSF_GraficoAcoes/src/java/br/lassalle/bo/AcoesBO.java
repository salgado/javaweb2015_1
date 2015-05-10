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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

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
        
        ChartSeries petro = new ChartSeries();
        petro.setLabel("Petrobras ON");
        petro.set("2004", 120);
        petro.set("2005", 100);
        petro.set("2006", 44);
        petro.set("2007", 150);
        petro.set("2008", 25);
        
        ChartSeries vale = new ChartSeries();
        vale.setLabel("Vale ON");
        vale.set("2004", 52);
        vale.set("2005", 60);
        vale.set("2006", 110);
        vale.set("2007", 90);
        vale.set("2008", 120);
        
        model.addSeries(petro);
        model.addSeries(vale);
        
        model.setTitle("Ações Bovespa");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Ano"));
        
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Valor");
        yAxis.setMin(0);
        yAxis.setMax(200);

    }

    public LineChartModel getModel() {
        return model;
    }

}
