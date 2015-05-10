/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.DAO;

import br.lassalle.bo.AcoesBO;
import java.util.ArrayList;

/**
 *
 * @author salgado
 */
public class AcoesDAO {
    
    public ArrayList<AcoesBO> getAcoesPetroList()
    {
        ArrayList<AcoesBO> acoes = new ArrayList<AcoesBO>;
        acoes.add(new AcoesBO("Petro ON", 2006, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2007, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2008, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2009, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2010, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2011, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2012, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2013, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2014, 13.0));
        acoes.add(new AcoesBO("Petro ON", 2015, 13.0));
        
    }
    
}
