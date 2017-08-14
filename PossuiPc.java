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
public class PossuiPc {
    private String fk_login;
    private String fk_ip;

    public String getFk_login() {
        return fk_login;
    }

    public void setFk_login(String fk_login) {
        this.fk_login = fk_login;
    }

    public String getFk_ip() {
        return fk_ip;
    }

    public void setFk_ip(String fk_ip) {
        this.fk_ip = fk_ip;
    }
}
