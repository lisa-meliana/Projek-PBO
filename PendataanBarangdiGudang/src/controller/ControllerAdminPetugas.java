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
import model.ModelAdminPetugas;
import view.ViewAdminPetugas;


public class ControllerAdminPetugas implements ActionListener, ControllerKelolaTabel{
    //membuat object
    ViewAdminPetugas viewAdminPetugas;
    ModelAdminPetugas modelAdminPetugas;

    public ControllerAdminPetugas(ViewAdminPetugas viewAdminPetugas, ModelAdminPetugas modelAdminPetugas) {
        this.viewAdminPetugas = viewAdminPetugas;
        this.modelAdminPetugas = modelAdminPetugas;
        refreshTable();
        //menambahkan actionlistener
        viewAdminPetugas.bClear.addActionListener(this);
        viewAdminPetugas.bTambah.addActionListener(this);
        viewAdminPetugas.bUpdate.addActionListener(this);
        viewAdminPetugas.bDelete.addActionListener(this);
        
        viewAdminPetugas.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewAdminPetugas.table.getSelectedRow();

                viewAdminPetugas.tfKodePetugas.setText(viewAdminPetugas.table.getValueAt(row,0).toString());
                viewAdminPetugas.tfNama.setText(viewAdminPetugas.table.getValueAt(row,1).toString());
                viewAdminPetugas.tfPassword.setText(viewAdminPetugas.table.getValueAt(row,2).toString());
                viewAdminPetugas.tfAlamat.setText(viewAdminPetugas.table.getValueAt(row,3).toString());
                
            }
        });
      
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //menjalankan metod jika button diklik
        if (e.getSource() == viewAdminPetugas.bTambah){
            tambah();
        }else if(e.getSource() == viewAdminPetugas.bUpdate){
            update();
        }else if(e.getSource() == viewAdminPetugas.bDelete){
            delete();
        }else if(e.getSource() == viewAdminPetugas.bClear){
            clear();
        }
    }
    
    
    
    @Override
    public void tambah(){
        //mendapatkan nilai(string) dari textfield
        String kodePetugas = viewAdminPetugas.getKodePetugas();
        String nama = viewAdminPetugas.getNama();
        String password = viewAdminPetugas.getPassword();
        String alamat = viewAdminPetugas.getAlamat();
        
        //textfield tidak boleh kosong
        if (kodePetugas.equals("") || nama.equals("") || password.equals("") || alamat.equals("")){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else{
            //memanggil insert petugas, untuk menginput data petugas baru
            if (modelAdminPetugas.insertPetugas(kodePetugas, nama, password, alamat) == 1){
                JOptionPane.showMessageDialog(null,"Berhasil Ditambahkan");
                refreshTable();
                clear();
            } else {
                JOptionPane.showMessageDialog(null,"Data Sudah Tercatat!");
            }
        }
    
    }
    
    @Override
    public void update(){
        //mendapatkan nilai(string) dari textfield
        String kodePetugas = viewAdminPetugas.getKodePetugas();
        String nama = viewAdminPetugas.getNama();
        String password = viewAdminPetugas.getPassword();
        String alamat = viewAdminPetugas.getAlamat();
        
        if (kodePetugas.equals("") || nama.equals("") || password.equals("") || alamat.equals("")){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else{
            //memanggil metod updatePetugas, untuk mengupdate nilai pada field
            if (modelAdminPetugas.updatePetugas(kodePetugas, nama, password, alamat) == 1){
                JOptionPane.showMessageDialog(null,"Berhasil Diupdate");
                refreshTable();
                clear();
            } else {
                JOptionPane.showMessageDialog(null,"Data Petugas Tidak ada!");
            }
        }
        

    }
    
    
    @Override
    public void delete(){
        //mendapatkan nilai(string) dari textfield
        String kodePetugas = viewAdminPetugas.getKodePetugas();

            if (kodePetugas.equals("")){
                JOptionPane.showMessageDialog(null, "Kode Petugas Tidak Boleh Kosong");
            } else {
                //memanggil metod delete utnuk menghapus data dari petugas
                if (modelAdminPetugas.delete(kodePetugas) == 1)
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                else
                    JOptionPane.showMessageDialog(null, "Delete Gagal");
            }
            refreshTable();
            clear();
    
    }
    
    @Override
    public void refreshTable(){
        //merefresh isi pada tabel
        String data[][] = modelAdminPetugas.getAll();
        viewAdminPetugas.table.setModel(new JTable(data, viewAdminPetugas.coloumnName).getModel());
    
    }
    @Override
    public void clear(){
        //mengsongkan nilai pada textfield
        viewAdminPetugas.tfKodePetugas.setText("");
        viewAdminPetugas.tfNama.setText("");
        viewAdminPetugas.tfPassword.setText("");
        viewAdminPetugas.tfAlamat.setText("");
    }
}
