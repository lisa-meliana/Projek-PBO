/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.Petugas;


public class ViewMenuPetugas extends JFrame{
    //membuat object petugas
    Petugas petugas;
    // instansiasi panel, font, label, textfield, button, tabel
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    JLabel lJudul = new JLabel("Pendataan Barang Masuk dan Keluar");
    JLabel lTabel = new JLabel("Tabel Barang");
    JLabel lKodeBarang = new JLabel("Kode Barang");
    JLabel lMasuk = new JLabel("Barang Masuk");
    JLabel lKeluar= new JLabel("Barang keluar");
    JLabel lPetugas= new JLabel("");
    
    public JTextField tfKodeBarang = new JTextField();
    public JTextField tfMasuk = new JTextField();
    public JTextField tfKeluar = new JTextField();
    public JTextField tfSearch = new JTextField();
    
    public JButton bMasuk = new JButton("Catat");
    public JButton bKeluar = new JButton("Catat");
    public JButton bSearch = new JButton("Search");
    public JButton bRefresh = new JButton("Refresh");
    public JButton bExit = new JButton("Logout");
    
    //tabel
    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object coloumnName[] = {"Kode Barang", "Nama Barang","Stok"};

    public ViewMenuPetugas(Petugas petugas) {
        this.petugas = petugas;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Petugas");
        
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(850, 600);
        setLocationRelativeTo(null);
        
        lPetugas = new JLabel("Hai, " + petugas.getNamaPetugas());
        
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        lJudul.setFont(font1);
        //menmbahkan object ke ViewMenuPetugas
        add(lJudul);
        add(lTabel);
        add(lKodeBarang);
        add(lMasuk);
        add(lKeluar);
        add(tfKodeBarang);
        add(tfKeluar);
        add(tfMasuk);
        add(tfSearch);
        add(bRefresh);
        add(bSearch);
        add(bKeluar);
        add(bMasuk);
        add(scrollPane);
        add(bExit);
        add(lPetugas);
        //mengeset letak dari setiap object
        lJudul.setBounds(170,20,500,50);
        lTabel.setBounds(70,80,150,20);
        scrollPane.setBounds(70,100,350,400);
        tfSearch.setBounds(450,100,200,25);
        bSearch.setBounds(655,100,75,25);
        bRefresh.setBounds(735,100,80,25);
        lKodeBarang.setBounds(550,150,120,30);
        tfKodeBarang.setBounds(510,185,150,25);
        lMasuk.setBounds(480,230,150,30);
        lKeluar.setBounds(640,230,150,30);
        tfMasuk.setBounds(450,270,150,25);
        tfKeluar.setBounds(610,270,150,25);
        bMasuk.setBounds(485,330,80,30);
        bKeluar.setBounds(650,330,80,30);
        bExit.setBounds(560,470,120,30);
        lPetugas.setBounds(35,50,150,20);
    }
    //ntuk medapatkan nilai(String) dari setiap textfield
    public String getKodeBarang() {
        return tfKodeBarang.getText();
    }
    
    public String getKeluar() {
        return tfKeluar.getText();
    }
    
    public String getMasuk() {
        return tfMasuk.getText();
    }
    
    public String getSearch() {
        return tfSearch.getText();
    }
}
