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
public class Kurir {
    private String nama;
    private int age;
    private String gender;
    private String address;

    public String getNama(){
        return nama;
    }

    public Kurir(String nama, int age, String gender, String address) {
        this.nama = nama;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Kurir(String nama) {
        this.nama = nama;
    }
    
    
    public void setNama(String Nama){
        this.nama = nama;
    }
    
    public int getAge(){
        return age;
    }

    public Kurir() {
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getAdress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean cekDuplicateKurir(String nama) {
        boolean cek = false;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from foodcourt_tabel");
            while(rs.next()){
                if(rs.getString("nama_kurir").equals(nama)){
                    cek = true;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
    
    public ArrayList<Kurir> LoadKurirtoList() {
       Database db = new Database();
       try{
           ArrayList<Kurir> listKurir = new ArrayList<>();
           ResultSet rs = db.getData("select *from tablekurir");
           while (rs.next()) {
               Kurir k = new Kurir(rs.getString("nama"),Integer.parseInt(rs.getString("age")),rs.getString("gender"),rs.getString("address"));
               listKurir.add(k);
           }
           
           return listKurir;
           
           } catch (Exception e) {
               throw new IllegalArgumentException("Terjadi Kesalahan");
       }
    }
    
    public void saveKurir(){
        Database db = new Database();
        String k = "insert into tablekurir(nama,age,gender,address) values('"+this.nama+"','"+this.age+"','"+this.gender+"','"+this.address+"')";
        db.query(k);
    }
}
