/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aparicio
 */
public class DAOUsuario {

    private Connection con = null;

    public void DAOUsuario() {
        //con = new ConnectionFactory().getConnection();
    }

    public void insere(Usuario usuario) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql = "insert into usuario" + "(email,senha)" + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();
            stmt.close();

            System.out.println("Insere Usuario funcionou");
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altera(Usuario usuario) {
        String sql = "update usuario set senha=?"
                + "where email=?";
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getEmail());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Usuario usuario) {
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete"
                    + "from usuario where email=?");
            stmt.setString(1, usuario.getEmail());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Usuario pesquisa(Usuario usuario) {

        PreparedStatement stmt;
        String email = null;
        String senha = null;
        Usuario user = new Usuario();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("select * from usuario");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
                senha = rs.getString("senha");
                if(usuario.getEmail().equals(email))
                {
                    user.setEmail(email);
                    user.setSenha(senha);
                    break;
                }
            }

            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
}
