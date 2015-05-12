/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.connection;

import br.lassalle.bo.AcoesBO;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salgado
 */
public class ConnectionFactory {

    private String url1 = "http://real-chart.finance.yahoo.com/table.csv?s=";
    private String url2 = "&a=01&b=1&c=2015&d=02&e=1&f=2015&g=d&ignore=.csv";

    public ArrayList<AcoesBO> getListAcoes(String nomeAcao) {
        
        ArrayList<AcoesBO> acoes = new ArrayList<AcoesBO>();
        
        URL yahoo;
        try {
            yahoo = new URL(url1 + nomeAcao+url2);
            URLConnection data = yahoo.openConnection();

            Scanner inputStream = new Scanner(data.getInputStream());
            if(inputStream.hasNext())
            {
                String line = inputStream.nextLine();
                System.out.println("linha" + line);
            }
            
            while(inputStream.hasNext())
            {
                String line = inputStream.nextLine();
                String[] valores = line.split(",");
                AcoesBO acao = new AcoesBO("PETR4", valores[0], new Float(valores[6]));
                acoes.add(acao);
                
                System.out.println("linha:" + valores[0] +"/"+ valores[6]);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return acoes;
    }
 }
