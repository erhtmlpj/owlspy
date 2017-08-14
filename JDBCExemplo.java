/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
* @author Aparicio
 */
public class JDBCExemplo {
    public static void main(String[] args) throws SQLException {
        //Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/gestsite", "root", "");
        //System.out.println("Conectado!");
        //conexao.close();
        
        Computador computador = new Computador();
        
        try {
            
            Connection con = new ConnectionFactory().getConnection();
            
            String sql = "insert into computador" + "(ip,nome)" + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, "127.0.0.1");
            stmt.setString(2, "meu");

            stmt.execute();
            stmt.close();

            System.out.println("Insere Computador funcionou");

        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
