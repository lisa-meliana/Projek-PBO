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
import model.ModelAdminBarang;
import view.ViewAdminBarang;


public class ControllerAdminBarang implements ActionListener, ControllerKelolaTabel{
    //membuat object
    ViewAdminBarang viewAdminBarang;
    ModelAdminBarang modelAdminBarang;

    public ControllerAdminBarang(ViewAdminBarang viewAdminBarang, ModelAdminBarang modelAdminBarang) {
        this.viewAdminBarang = viewAdminBarang;
        this.modelAdminBarang = modelAdminBarang;
        refreshTable();
        //menambahkan actionlistener
        viewAdminBarang.bClear.addActionListener(this);
        viewAdminBarang.bTambah.addActionListener(this);
        viewAdminBarang.bUpdate.addActionListener(this);
        viewAdminBarang.bDelete.addActionListener(this);
        viewAdminBarang.bSearch.addActionListener(this);
        viewAdminBarang.bRefresh.addActionListener(this);
        
        viewAdminBarang.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewAdminBarang.table.getSelectedRow();

                viewAdminBarang.tfKodeBarang.setText(viewAdminBarang.table.getValueAt(row,0).toString());
                viewAdminBarang.tfNama.setText(viewAdminBarang.table.getValueAt(row,1).toString());
                viewAdminBarang.tfStok.setText(viewAdminBarang.table.getValueAt(row,2).toString());
                
                
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //jika button diklik akan menjalankan metod
        if (e.getSource() == viewAdminBarang.bTambah){
            tambah();
        }else if(e.getSource() == viewAdminBarang.bUpdate){
            update();
        }else if(e.getSource() == viewAdminBarang.bDelete){
            delete();
        }else if(e.getSource() == viewAdminBarang.bClear){
            clear();
        }else if(e.getSource() == viewAdminBarang.bSearch){
            searchBarang();
        }else if(e.getSource() == viewAdminBarang.bRefresh){
            refreshTable();
        }
    }
    
    @Override
    public void tambah(){
        //mendapatkan nilai(string) dari textfield
        String kodeBarang = viewAdminBarang.getKodeBarang();
        String nama = viewAdminBarang.getNama();
        String stok = viewAdminBarang.getStok();
        int iStock = -1;
        //untuk menambahkan data barang
        try {
            iStock = Integer.parseInt(stok);
            //cek apakah ada text field kosong
            if (kodeBarang.equals("") || nama.equals("") || stok.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else if (iStock < 0) {
                JOptionPane.showMessageDialog(null, "Stok Tidak Boleh Negatif");
            } else {
                //memanggil metod insertBarang
                if (modelAdminBarang.insertBarang(kodeBarang, nama, stok) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil Tambah Barang");
                    refreshTable();
                    clear();
                }else {
                    JOptionPane.showMessageDialog(null,"Barang Sudah Tercatat!");
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Stok Harus Diisi Dengan Angka!");
        }
        
       
    }
    @Override
    public void update(){
        //mendapatkan nilai(string) dari textfield
        String kodeBarang = viewAdminBarang.getKodeBarang();
        String nama = viewAdminBarang.getNama();
        String stok = viewAdminBarang.getStok();
        int iStock = -1;
        //untuk mengupdate data barang
        try {
            iStock = Integer.parseInt(stok);
            if (kodeBarang.equals("") || nama.equals("") || stok.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else if (iStock < 0) {
                JOptionPane.showMessageDialog(null, "Stok Tidak Boleh Negatif");
            } else {
                //memanggil metod updateBarang
                if (modelAdminBarang.updateBarang(kodeBarang, nama, stok) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil Update");
                    refreshTable();
                    clear();
                }else {
                    JOptionPane.showMessageDialog(null,"Barang Tidak ada!");
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Stok Harus Diisi Dengan Angka!");
        }
    
    }
    
    @Override
    public void delete(){
        //mendapatkan nilai(string) dari textfield
        String kodeBarang = viewAdminBarang.getKodeBarang();

            if (kodeBarang.equals("")){
                JOptionPane.showMessageDialog(null, "Kode Barang Tidak Boleh Kosong");
            } else {
                //memanggil metod delete
                if (modelAdminBarang.delete(kodeBarang) == 1)
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                else
                    JOptionPane.showMessageDialog(null, "Delete Gagal");
            }
            refreshTable();
            clear();
    
    }
    
    
    
    @Override
    public void refreshTable(){
        //untuk merefresh data di tabel
            //memanggil metodgetAll
        String data[][] = modelAdminBarang.getAll();
        viewAdminBarang.table.setModel(new JTable(data, viewAdminBarang.coloumnName).getModel());
    
    }
    
    public void clear(){
        //mengsongkan textfield
        viewAdminBarang.tfKodeBarang.setText("");
        viewAdminBarang.tfNama.setText("");
        viewAdminBarang.tfStok.setText("");
    }
  
    public void searchBarang(){
        //mencari barang berdasarkan nama barang
        String nama = viewAdminBarang.getSearch();
        String data[][] = modelAdminBarang.searchBarang(nama);

        viewAdminBarang.table.setModel(new JTable(data, viewAdminBarang.coloumnName).getModel());

    }
    
}
