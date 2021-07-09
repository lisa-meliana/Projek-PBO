/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewAdminPetugas extends JFrame{
    // instansiasi panel, font, label, textfield, button, tabel
    public JPanel pPetugas = new JPanel();
    
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 30);
    
    JLabel lJudul = new JLabel("Data Petugas");
    JLabel lKodePetugas = new JLabel("Kode Petugas");
    JLabel lNama = new JLabel("Nama Petugas");
    JLabel lPassword = new JLabel("Password");
    JLabel lAlamat = new JLabel("Alamat");
    
    public JTextField tfKodePetugas = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfPassword = new JTextField();
    public JTextField tfAlamat = new JTextField();
    
    public JButton bTambah = new JButton("Tambah");
    public JButton bUpdate = new JButton("Update");
    public JButton bDelete = new JButton("Delete");
    public JButton bClear = new JButton("Clear");
    
    //tabel
    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object coloumnName[] = {"Kode Petugas", "Nama","Password","Alamat"};
    
    
    public ViewAdminPetugas() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pPetugas.setLayout(null);
        pPetugas.setSize(900,650);
        
        //Membuat tabel/instansiasi tabel
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        //menambahkan object ke panel
        lJudul.setFont(font1);
        pPetugas.add(lJudul);
        pPetugas.add(scrollPane);
        pPetugas.add(lKodePetugas);
        pPetugas.add(lNama);
        pPetugas.add(lPassword);
        pPetugas.add(lAlamat);
        pPetugas.add(tfKodePetugas);
        pPetugas.add(tfNama);
        pPetugas.add(tfPassword);
        pPetugas.add(tfAlamat);
        pPetugas.add(bTambah);
        pPetugas.add(bUpdate);
        pPetugas.add(bDelete);
        pPetugas.add(bClear);
        
        //mengeset letak dari setiap object
        lJudul.setBounds(360, 50, 300, 50);
        scrollPane.setBounds(250, 150, 500,200);
        lKodePetugas.setBounds(250, 350, 120,30);
        lNama.setBounds(250, 390, 120,30);
        lPassword.setBounds(250, 430, 120,30);
        lAlamat.setBounds(250, 470, 120,30);
        tfKodePetugas.setBounds(400, 350, 150,30);
        tfNama.setBounds(400, 390, 150,30);
        tfPassword.setBounds(400, 430, 150,30);
        tfAlamat.setBounds(400, 470, 150,30);
        bTambah.setBounds(250,530, 100,30);
        bUpdate.setBounds(370,530, 100,30);
        bDelete.setBounds(490,530, 100,30);
        bClear.setBounds(610,530, 100,30);
    }
    
    
    //untuk memperoleh nilai/string dari setap textfield
    public String getKodePetugas() {
        return tfKodePetugas.getText();
    }
    
    public String getNama() {
        return tfNama.getText();
    }
    
    public String getPassword() {
        return tfPassword.getText();
    }
    
    public String getAlamat() {
        return tfAlamat.getText();
    }
    
    
}
