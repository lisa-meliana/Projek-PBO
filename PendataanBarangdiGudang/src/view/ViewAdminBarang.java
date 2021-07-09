/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class ViewAdminBarang extends JFrame{
    // instansiasi panel, font, label, textfield, button, tabel
    public JPanel pBarang = new JPanel();
    
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 30);
    
    JLabel lJudul = new JLabel("Data Barang");
    JLabel lKodeBarang = new JLabel("Kode Barang");
    JLabel lNama = new JLabel("Nama Barang");
    JLabel lStok = new JLabel("Stok");
    
    
    public JTextField tfKodeBarang = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfStok = new JTextField();
    public JTextField tfSearch = new JTextField();
    
    public JButton bTambah = new JButton("Tambah");
    public JButton bUpdate = new JButton("Update");
    public JButton bDelete = new JButton("Delete");
    public JButton bClear = new JButton("Clear");
    public JButton bSearch = new JButton("Search");
    public JButton bRefresh = new JButton("Refresh");
    
    // tabel
    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object coloumnName[] = {"Kode Barang", "Nama Barang","Stok"};
    
    
    public ViewAdminBarang() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pBarang.setLayout(null);
        pBarang.setSize(900,650);
        
        //Membuat tabel/instansiasi tabel/scrollpane
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        // menambahkan object ke panel
        lJudul.setFont(font1);
        pBarang.add(lJudul);
        pBarang.add(scrollPane);
        pBarang.add(lKodeBarang);
        pBarang.add(lNama);
        pBarang.add(lStok);
       
        pBarang.add(tfKodeBarang);
        pBarang.add(tfNama);
        pBarang.add(tfStok);
        pBarang.add(tfSearch);
        pBarang.add(bTambah);
        pBarang.add(bUpdate);
        pBarang.add(bDelete);
        pBarang.add(bClear);
        pBarang.add(bSearch);
        pBarang.add(bRefresh);
        
        
        //mengeset letak dari setiap object
        lJudul.setBounds(360, 50, 300, 50);
        scrollPane.setBounds(250, 150, 500,200);
        
        lKodeBarang.setBounds(250, 400, 120,30);
        lNama.setBounds(250, 440, 120,30);
        lStok.setBounds(250, 480, 120,30);
        
        tfSearch.setBounds(260, 350, 300,25);
        tfKodeBarang.setBounds(400, 400, 150,30);
        tfNama.setBounds(400, 440, 150,30);
        tfStok.setBounds(400, 480, 150,30);
        
        bTambah.setBounds(250,530, 100,30);
        bUpdate.setBounds(370,530, 100,30);
        bDelete.setBounds(490,530, 100,30);
        bClear.setBounds(610,530, 100,30);
        bSearch.setBounds(580, 350, 80,25);
        bRefresh.setBounds(670, 350, 80,25);
    }
    
    //untuk memperoleh nilai/string dari setap textfield
    public String getKodeBarang() {
        return tfKodeBarang.getText();
    }
    
    public String getNama() {
        return tfNama.getText();
    }
    
    public String getStok() {
        return tfStok.getText();
    }
    
    public String getSearch() {
        return tfSearch.getText();
    }
}
