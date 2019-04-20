/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.*;
import View.*;
/**
 *
 * @author MIFTAH
 */
public class HandlerTambahKendaraan  implements ActionListener{
    private TambahKendaraan A;
    ArrayList<Parkir> listParkir = new ArrayList<Parkir>();
    
    public HandlerTambahKendaraan()  {
        A = new TambahKendaraan();
        A.setVisible(true);
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(A.getBtnBack())){
            new MidFormHandler();
            A.dispose();
        }else if (source.equals(A.getBtnAdd())){
            Parkir p = new Parkir();
            p.setNopol(A.getTfNopol().getText());
            p.setType(A.getcbType());
            p.saveParkir();
        }else if (source.equals(A.getBtnView())){
             Database db = new Database();
                ResultSet rs = null;
                try{
                    int i = 0;
                    rs = db.getData("select *from tableparkir");
                    while(rs.next()){
                        A.getOutput().setValueAt(rs.getString("Nopol"), i, 0);
                        A.getOutput().setValueAt(rs.getString("type"), i, 1);
                        i++;
                    }
                    rs.close();
                }catch(Exception ae){
                    JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
                }
        }else if(source.equals(A.getBtnBack())){

                new BookingFormHandler();
                A.dispose();
        }        

  
}
}
    