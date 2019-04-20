/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nuzul
 */
public class Makanan {
    private String nama;
    private int price;
    private String variant;
    private String idResto;

    public Makanan(String nama, int harga, String variant) {
        this.nama = nama;
        this.price = price;
        this.variant = variant;
    }

    public Makanan() {
    }

    public String getIdResto() {
        return idResto;
    }

    public void setIdResto(String idResto) {
        this.idResto = idResto;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int harga) {
        this.price = harga;
    }
    
    public String getVariant(){
        return variant;
    }
    
    public void setVariant(String variant){
        this.variant = variant;
    }
    
    public boolean cekDuplicateMakanan(String nama) {
        boolean cek = false;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from tablefood");
            while(rs.next()){
                if(rs.getString("nama").equals(nama)){
                    cek = true;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
    
    public ArrayList<Makanan> LoadMakanantoList(){
       Database db = new Database();
       try{
           ArrayList<Makanan> listMakanan = new ArrayList<>();
           ResultSet rs = db.getData("select *from tablefood");
           while (rs.next()) {
               Makanan m = new Makanan(rs.getString("nama"),Integer.parseInt(rs.getString("price")),rs.getString("variant"));
               listMakanan.add(m);
           }
           
           return listMakanan;
           
           } catch (Exception e) {
               throw new IllegalArgumentException("Terjadi Kesalahan");
       }
    }
    
    public void saveMakanan(){
        Database db = new Database();
        String m = "insert into tablefood(nama,variant,price,noToko) values('"+this.nama+"','"+this.variant+"','"+this.price+"','"+this.idResto+"')";
        db.query(m);
    }
}
