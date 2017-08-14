/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

/**
 *
 * @author Aparicio
 */
public class Computador {
    private String ip;
    private String nome;
    private String fk_login;

    public String getFk_login() {
        return fk_login;
    }

    public void setFk_login(String fk_login) {
        this.fk_login = fk_login;
    }
    
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
