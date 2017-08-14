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
public class DAOConta {

    private Connection con = null;

    public void DAOConta() {
        //con = new ConnectionFactory().getConnection();
    }

    public void insere(Conta conta) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql = "insert into conta" + "(email,login)" + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, conta.getEmail());
            stmt.setString(2, conta.getLogin());

            stmt.execute();
            stmt.close();

            System.out.println("Insere Conta funcionou");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altera(Conta conta) {
        String sql = "update conta set login=?"
                + "where email=?";
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, conta.getLogin());
            stmt.setString(2, conta.getEmail());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Conta conta) {
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete"
                    + "from conta where login=?");
            stmt.setString(1, conta.getLogin());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Conta pesquisa(Conta conta) {
        
        PreparedStatement stmt;
        String email = null;
        String login = null;
        Conta account = new Conta();
        account.setEmail("null");
        account.setLogin("null");
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("select * from conta");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
                login = rs.getString("login");
                if(conta.getLogin().equals(login))
                {
                    account.setLogin(login);
                    account.setEmail(email);
                    break;
                }
            }

            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return account;
    }
}
