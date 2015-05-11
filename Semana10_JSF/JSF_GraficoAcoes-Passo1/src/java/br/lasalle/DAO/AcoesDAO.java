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
        ArrayList acoes;
        acoes = new ArrayList();
        for(int i=1;i<=10;i++)
        {
            acoes.add(new AcoesBO("Petro ON", 2006+i, (float) 13.0*i));
        }
        
        return acoes;
        
    }
    
    public ArrayList<AcoesBO> getAcoesValeList()
    {
        ArrayList acoes;
        acoes = new ArrayList();
        for(int i=1;i<=10;i++)
        {
            acoes.add(new AcoesBO("Vale ON", 2006+i, (float) 3.0*i));
        }
        
        return acoes;
        
    }
}
