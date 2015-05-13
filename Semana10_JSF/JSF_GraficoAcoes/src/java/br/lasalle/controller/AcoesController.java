/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.controller;

import br.lasalle.DAO.AcoesDAO;
import br.lassalle.bo.AcoesBO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.validator.internal.util.logging.Log;
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
public class AcoesController implements Serializable {

    private static final long serialVersionUID = 1L;

    private LineChartModel model;

    public AcoesController() {
        model = new LineChartModel();
        
        ChartSeries petro = new ChartSeries();
        petro.setLabel("Petrobras ON");
        AcoesDAO acoesDAO = new AcoesDAO();
        
       ArrayList<AcoesBO> acaoPetro = acoesDAO.getAcoesPetroCSV();
       //  acaoPetro = acoesDAO.getAcoesPetroList();
        
        for (AcoesBO acaoPetro1 : acaoPetro) {
            petro.set(acaoPetro1.getAno(), acaoPetro1.getValor());
            System.out.println(acaoPetro1.getAno() + ":" + acaoPetro1.getValor());
        }
        
        
        ChartSeries vale = new ChartSeries();
        vale.setLabel("Vale ON");
        ArrayList<AcoesBO> acaoVale = acoesDAO.getAcoesValeCSV();
        for (AcoesBO acaoVale1 : acaoVale) {
            vale.set(acaoVale1.getAno(), acaoVale1.getValor());
        }
        
        model.addSeries(petro);
        model.addSeries(vale);
        
        model.setTitle("Ações Bovespa Fev/2015");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Ano"));
        
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Valor");
        yAxis.setMin(0);

    }

    public LineChartModel getModel() {
        return model;
    }
    
}

