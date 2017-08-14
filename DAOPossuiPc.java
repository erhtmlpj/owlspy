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
public class DAOPossuiPc {

    private Connection con = null;

    public void DAOPossuiPc() {
        
    }

    public void insere(PossuiPc possuipc) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql = "insert into possuipc" + "(fk_login,fk_ip)" + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, possuipc.getFk_login());
            stmt.setString(2, possuipc.getFk_ip());

            stmt.execute();
            stmt.close();

            System.out.println("Insere PossuiPc funcionou");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altera(PossuiPc possuipc) {
        String sql = "update possuipc set fk_login=?"
                + "where fk_ip=?";
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, possuipc.getFk_login());
            stmt.setString(2, possuipc.getFk_ip());
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
    
    public PossuiPc pesquisa(PossuiPc possuipc) {

        PreparedStatement stmt;
        String fk_login = null;
        String fk_ip = null;
        PossuiPc haspc = new PossuiPc();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("select * from possuipc");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fk_login = rs.getString("login");
                fk_ip = rs.getString("ip");
                if(possuipc.getFk_ip().equals(fk_ip))
                {
                    haspc.setFk_ip(fk_ip);
                    haspc.setFk_login(fk_login);
                    break;
                }
            }

            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return haspc;
    }
}
