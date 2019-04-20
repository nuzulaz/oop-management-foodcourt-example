/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author nuzul
 */
public class Database {
    private String dbuser = "root";
    private String dbpassword ="";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    public Database() {
        try{
            //Load Driver
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("sukses");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "JDBC Driber error",JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            //Konek ke Database
            con = DriverManager.getConnection("jdbc:mysql://localhost/Tubes",dbuser,dbpassword);
            stmt = con.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage(), "Connection error",JOptionPane.WARNING_MESSAGE);    
        }
    }
    
    public ResultSet getData(String SQLString){
        try{
            rs = stmt.executeQuery(SQLString);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error : "+e.getMessage(), "Commmunication error",JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }

    public void query(String SQLString){
        try{
            stmt.executeUpdate(SQLString);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error L "+e.getMessage(), "Communication error",JOptionPane.WARNING_MESSAGE);
        }
    }

    
    
}
