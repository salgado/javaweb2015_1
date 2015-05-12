/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.DAO;

import br.lasalle.connection.ConnectionFactory;
import br.lassalle.bo.AcoesBO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salgado
 */
public class AcoesDAO {

    public ArrayList<AcoesBO> getAcoesPetroList() {
        ArrayList acoes;
        acoes = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            acoes.add(new AcoesBO("Petro ON", "2006 + i", (float) 13.0 * i));
        }

        return acoes;

    }

    public ArrayList<AcoesBO> getAcoesValeList() {
        ArrayList acoes;
        acoes = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            acoes.add(new AcoesBO("Vale ON", "2006 + i", (float) 3.0 * i));
        }

        return acoes;

    }

    /* referencia
     http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
     */
    public ArrayList<AcoesBO> getAcoesPetroCSV() {
            ConnectionFactory con = new ConnectionFactory();
            return con.getListAcoes("PETR4.SA");
    }
    public ArrayList<AcoesBO> getAcoesValeCSV() {
            ConnectionFactory con = new ConnectionFactory();
            return con.getListAcoes("VALE3.SA");
    }

}
