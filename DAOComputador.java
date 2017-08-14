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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aparicio
 */
public class DAOComputador {

    private Connection con = null;

    public void DAOComputador() {

    }

    public void insere(Computador computador) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql = "insert into computador" + "(ip,nome,fk_login)" + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, computador.getIp());
            stmt.setString(2, computador.getNome());
            stmt.setString(3, computador.getFk_login());

            stmt.execute();
            stmt.close();
            con = new ConnectionFactory().getConnection();
            System.out.println("Insere Computador funcionou");

        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altera(Computador computador) {
        String sql = "update computador set nome=?"
                + "where ip=?";
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, computador.getIp());
            stmt.setString(2, computador.getIp());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Computador computador) {
        try {
            con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete"
                    + "from computador where ip=?");
            stmt.setString(1, computador.getIp());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Computador pesquisa(Computador computador) {

        PreparedStatement stmt;
        String ip = null;
        String nome = null;
        String fk_login = null;
        Computador computer = new Computador();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("select * from computador");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ip = rs.getString("ip");
                nome = rs.getString("nome");
                fk_login = rs.getString("fk_login");

                if (computador.getIp().equals(ip)) {
                    computer.setIp(ip);
                    computer.setNome(nome);
                    computer.setFk_login(fk_login);
                    break;
                }
            }

            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return computer;
    }

    public List<Computador> Lista(String login) {
        List<Computador> list = new ArrayList();

        PreparedStatement stmt;
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("select * from computador");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                // criando o objeto Contato
                Computador computador = new Computador();
                computador.setNome(rs.getString("nome"));
                computador.setIp(rs.getString("ip"));
                computador.setFk_login(rs.getString("fk_login"));
                // adicionando o objeto à lista
                if (computador.getFk_login().equals(login)) {
                    list.add(computador);
                }
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOComputador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
