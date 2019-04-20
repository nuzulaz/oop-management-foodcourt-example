/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nuzul
 */
public class Parkir {
    private String nopol;
    private String type;
    
    public Parkir(String nopol,String type){
        this.nopol = nopol;
        this.type = type;
    }

    public Parkir() {
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public boolean cekDuplicateParkir(String nopol) {
        boolean cek = false;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from tabelparkir");
            while(rs.next()){
                if(rs.getString("no_polisi").equals(nopol)){
                    cek = true;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }

    public ArrayList<Parkir> LoadParkirtoList() {
       Database db = new Database();
       try{
           ArrayList<Parkir> listParkir = new ArrayList<>();
           ResultSet rs = db.getData("select *from tableparkir");
           while (rs.next()) {
               Parkir p = new Parkir(rs.getString("nopol"),rs.getString("type"));
               listParkir.add(p);
           }
           
           return listParkir;
           
           } catch (Exception e) {
               throw new IllegalArgumentException("Terjadi Kesalahan");
       }
    }
    
    public void saveParkir(){
        Database db = new Database();
        String p = "insert into tableparkir(Nopol,type) values('"+this.nopol+"','"+this.type+"')";
        db.query(p);
    }
}
    

