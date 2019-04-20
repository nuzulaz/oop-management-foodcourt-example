/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sasa
 */
public class Booking {
    private String namaRestaurant;
    private String idBooking;
    private String id_cust;
    private int noMeja;
    private int jmlPesan;
    private String tglBooking;
   // private String no_restaurant;
    ArrayList<pelanggan> listPel = new ArrayList<pelanggan>();

    public Booking(String namaRestaurant, String idBooking, String id_cust, int noMeja, int jmlPesan, String tglBooking) {
        this.namaRestaurant = namaRestaurant;
        this.idBooking = idBooking;
        this.id_cust = id_cust;
        this.noMeja = noMeja;
        this.jmlPesan = jmlPesan;
        this.tglBooking = tglBooking;
    }

    
     public Booking() {
    }

    public String getId_cust() {
        return id_cust;
    }

    public void setId_cust(String id_cust) {
        this.id_cust = id_cust;
    }
     
//    public Booking(String x,int jmlPesan, String tglBooking) {
//        this.jmlPesan = jmlPesan;
//        this.tglBooking = tglBooking;
//        this.idBooking = x;
//    }
    
    public void addPelanggan(String nama, String username, String password, String id){
        listPel.add(new pelanggan(id,nama,username,password));
    }
    
    public String getNamaRestaurant() {
        return namaRestaurant;
    }
    
     public void setNamaRestaurant(String namaRestaurant) {
        this.namaRestaurant = namaRestaurant;
    }



    public int getNoMeja() {
        return noMeja;
    }

    public int getJmlPesan() {
        return jmlPesan;
    }

    public String getTglBooking() {
        return tglBooking;
    }
    
    public void setNoMeja(int noMeja) {
        this.noMeja = noMeja;
    }

//    public String getNamaRestaurant() {
//        return namaRestaurant;
//    }
//
//    public void setNamaRestaurant(String namaRestaurant) {
//        this.namaRestaurant = namaRestaurant;
//    }

    public void setJmlPesan(int jmlPesan) {
        this.jmlPesan = jmlPesan;
    }

    public void setTglBooking(String tglBooking) {
        this.tglBooking = tglBooking;
    }
    
       public Booking(String id_cust, String idBooking, int noMeja, int jmlPesan, String tglBooking) {
        this.id_cust = id_cust;
        this.idBooking = idBooking;
        this.noMeja = noMeja;
        this.jmlPesan = jmlPesan;
        this.tglBooking = tglBooking;
    }

//    public void setId_cust(String id_cust) {
//        this.id_cust = id_cust;
//    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }
    
    public ArrayList<Booking> LoadBooktoList(){
        Database db = new Database();
        try{
            ArrayList<Booking> listBooking = new ArrayList<>();
             ResultSet rs = db.getData("select *from booking");
            while (rs.next()) {
                Booking b = new Booking(rs.getString("namaRestaurant"),rs.getString("idBooking"),rs.getString("id_cust"),Integer.parseInt(rs.getString("noMeja")),Integer.parseInt(rs.getString("jmlPesan")),rs.getString("tglBooking"));
                listBooking.add(b);        
                System.out.println("1");
            }
        
            return listBooking;
        
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan");
          
        }
    }
    
    
public void saveBooking(){
        Database db = new Database();
        String b = "insert into booking(namaRestaurant,id_cust,idBooking,noMeja,jmlPesan,tglBooking) values('"+this.namaRestaurant+"','"+this.id_cust+"','"+this.idBooking+"','"+this.noMeja+"','"+this.jmlPesan+"','"+this.tglBooking+"')";                                 
        db.query(b);
}
 public boolean cekDuplicateBooking(String tglBooking) {
        boolean cek = true;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from booking");
            while(rs.next()){
                if(rs.getString("tglBooking").equals(tglBooking)){
                    cek = false;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
  public boolean cekDuplicateMeja(String noMeja){
        boolean cek = true;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from booking" );
            while(rs.next()){
                if(rs.getString("noMeja").equals(Integer.parseInt(noMeja))){
                    cek = false;
                    System.out.println(rs.getString("noMeja"));
            
                }
            }
            
            rs.close();
        }catch (Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
    

        
}
