/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author salgado
 */
public class ConnectionFactory {
    
    public final static EntityManagerFactory getConnection()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Semana11_JPA1PU");
        return emf;
        
    }
    
}
