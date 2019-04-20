/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author nuzul
 */
public class Admin extends user {

    String id,Password;
    
    public Admin(String usename, String password) {
        this.id = usename;
        this.Password = password;
    }

    public String getId() {
        return id;
    }

    
    public Admin() {
    }
    
   
    @Override
    public boolean cekPassword(String x, String y) {
        if(this.id.equals(x) && this.Password.equals(y)){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Admin> loadAdmin(){
         Database db = new Database();
        try {
            ArrayList<Admin> listAdmin = new ArrayList<>();
            ResultSet rs = db.getData("select *from admin"); //ambil dari tabel database
            while (rs.next()) {
                Admin p = new Admin(rs.getString("username"),rs.getString("password"));
                listAdmin.add(p);
            }
            return listAdmin;
        
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan");
          
        }
    }
    

}
