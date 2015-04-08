/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.dao;

import br.lasalle.BO.Usuario;
import br.lasalle.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salgado
 */
public class UsuarioDAO {
    // conexao com banco de dados
    private Connection connection;
    
    public UsuarioDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    public boolean inserir(Usuario usuario)
    {
        String sql = "insert into usuario " + 
                " (login, senha) values (?, ?)";
        
        try{
            //prepared statment para inserir
            PreparedStatement query = connection.prepareStatement(sql);
                
            //define os valores dos parametros
            query.setString(1, usuario.getLogin() ); // login
        
            query.setString(2, usuario.getSenha() ); // senha

            //executa
            query.execute();
            query.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }

    public ArrayList<Usuario> ler()
    {
        String sql = "select * from usuario ";
        ArrayList<Usuario> listUsuario = new ArrayList<Usuario>();
        try{
            //prepared statment para inserir
            PreparedStatement query = connection.prepareStatement(sql);
            
            ResultSet rs =  query.executeQuery();
            
            while(rs.next())
            {
                //le os valores dos parametros
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                listUsuario.add(usuario);
            }
    
            //fecha
            rs.close();
            query.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listUsuario;
    }

}
