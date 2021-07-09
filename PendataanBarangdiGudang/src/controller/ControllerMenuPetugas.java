/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import main.MVCLogin;
import model.ModelMenuPetugas;
import view.ViewMenuPetugas;


public class ControllerMenuPetugas implements ActionListener{
    //membuat object
    ViewMenuPetugas viewMenuPetugas;
    ModelMenuPetugas modelMenuPetugas;

    public ControllerMenuPetugas(ViewMenuPetugas viewMenuPetugas, ModelMenuPetugas modelMenuPetugas) {
        this.viewMenuPetugas = viewMenuPetugas;
        this.modelMenuPetugas = modelMenuPetugas;
        refreshTable();
        //nemambahkan actionlistener
        viewMenuPetugas.bMasuk.addActionListener(this);
        viewMenuPetugas.bKeluar.addActionListener(this);
        viewMenuPetugas.bSearch.addActionListener(this);
        viewMenuPetugas.bRefresh.addActionListener(this);
        viewMenuPetugas.bExit.addActionListener(this);
        
        viewMenuPetugas.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewMenuPetugas.table.getSelectedRow();

                viewMenuPetugas.tfKodeBarang.setText(viewMenuPetugas.table.getValueAt(row,0).toString());
                
                
                
            }
        });
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //saat tombol diklik akan menjalankan metod
        if (e.getSource() == viewMenuPetugas.bRefresh){
            refreshTable();
        }else if (e.getSource() == viewMenuPetugas.bSearch){
            searchBarang();
        }else if (e.getSource() == viewMenuPetugas.bKeluar){
            barangKeluar();
        }else if (e.getSource() == viewMenuPetugas.bMasuk){
            barangMasuk();
        }else if (e.getSource() == viewMenuPetugas.bExit){
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0){
                viewMenuPetugas.setVisible(false);
                new MVCLogin();
            }
        }
        
        
        
    }
    
    
    
    public void refreshTable(){
        //merefresh isi pada tabel
        String data[][] = modelMenuPetugas.getAll();
        viewMenuPetugas.table.setModel(new JTable(data, viewMenuPetugas.coloumnName).getModel());
    
    }
    
    public void searchBarang(){
        //mencari data sesuai dengan nama barang
        String nama = viewMenuPetugas.getSearch();
        String data[][] = modelMenuPetugas.searchBarang(nama);

        viewMenuPetugas.table.setModel(new JTable(data, viewMenuPetugas.coloumnName).getModel());

    }
    
    public void barangKeluar(){
        //mendapatkan nilai(string) dari textfield
        String kodeBarang = viewMenuPetugas.getKodeBarang();
        String keluar = viewMenuPetugas.getKeluar();
        int iKeluar = -1;

        try {
            iKeluar = Integer.parseInt(keluar);
            //kodebarng dan barangkeluar tidak boleh kosong
            if (kodeBarang.equals("") || keluar.equals("")){
                JOptionPane.showMessageDialog(null, "Kode Barang dan Barang Keluar Tidak Boleh Kosong");
            } else if (iKeluar < 0) {
                //barang keluar tidak boleh negatif
                JOptionPane.showMessageDialog(null, "Barang Keluar Tidak Boleh Negatif");
            } else {
                //memanggil metod updateStokkeluar
                if (modelMenuPetugas.updateStokKeluar(kodeBarang, iKeluar) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil dicatat");
                    refreshTable();
                    clear();
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Barang Keluar Harus Diisi Dengan Angka!");
        }
    
    }
    
    public void clear(){
        //mengosongkan nilai pada textfield
        viewMenuPetugas.tfKodeBarang.setText("");
        viewMenuPetugas.tfKeluar.setText("");
        viewMenuPetugas.tfMasuk.setText("");
    }
    
    
    public void barangMasuk(){
        //mendapatkan nilai(string) dari textfield
        String kodeBarang = viewMenuPetugas.getKodeBarang();
        String masuk = viewMenuPetugas.getMasuk();
        int iMasuk = -1;

        try {
            iMasuk = Integer.parseInt(masuk);
            //kodebarang dan barang masuk tidak boleh kosong
            if (kodeBarang.equals("") || masuk.equals("")){
                JOptionPane.showMessageDialog(null, "Kode Barang dan Barang Masuk Tidak Boleh Kosong");
            } else if (iMasuk < 0) {
                //barang masuk tidak boleh negatif
                JOptionPane.showMessageDialog(null, "Barang Masuk Tidak Boleh Negatif");
            } else {
                //memnaggil metod updateStokmasuk
                if (modelMenuPetugas.updateStokMasuk(kodeBarang, iMasuk) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil dicatat");
                    refreshTable();
                    clear();
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Barang Masuk Harus Diisi Dengan Angka!");
        }
    
    }
}
