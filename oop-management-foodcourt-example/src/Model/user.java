/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nuzul
 */
public abstract class user {
    String usename;
    String password;


    public String getUsename() {
        return usename;
    }

    public String getPassword() {
        return password;
    }
    public abstract boolean cekPassword(String x, String y);

    
}
