/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.controller;

import br.lasalle.BO.Usuario;
import br.lasalle.DAO.UsuarioJpaController;
import com.sun.faces.facelets.util.Path;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.transaction.UserTransaction;


/**
 *
 * @author salgado
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
     public List<Usuario> getUsuarios()
     {
         
         UsuarioJpaController jpaController = new UsuarioJpaController();
         
         return jpaController.findUsuarioEntities();
         
     }
         
}
