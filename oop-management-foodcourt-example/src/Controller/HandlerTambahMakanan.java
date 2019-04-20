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
public class HandlerTambahMakanan extends MouseAdapter implements ActionListener{
    private TambahMakanan A;
    private ArrayList<Toko> listToko = new ArrayList<Toko>();
    
    public HandlerTambahMakanan(){
        Toko t = new Toko();
        listToko = t.loadToko();
        A = new TambahMakanan();
        A.setCbRestaurantName(listToko);
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
            Makanan m = new Makanan();
            Toko t = new Toko();
            int idx = t.cekRestaurant(A.getCbRestaurant());
            m.setNama(A.getTfName().getText());
            m.setVariant(A.getTfVariant().getText());
            m.setPrice(Integer.parseInt(A.getTfPrice().getText()));
            m.setIdResto(listToko.get(idx).getNoToko());
            t.addMakanan(m);
            m.saveMakanan();
        }
    }
    public static void main(String[] args) {
        new HandlerTambahMakanan();
    }
}