/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class ViewAdminHistory extends JFrame{
    // instansiasi panel, font, label, textfield, button, tabel
    public JPanel pHistory = new JPanel();
    
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 25);
    
    JLabel lJudul = new JLabel("History Masuk dan Keluar Barang");
    
    public JTextField tfSearch = new JTextField();
    
    public JButton bSearch = new JButton("Search");
    public JButton bRefresh = new JButton("Refresh");
    
    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object coloumnName[] = {"No", "Nama Petugas","Nama Barang","Tanggal","Jumlah Keluar","Jumlah Masuk"};

    public ViewAdminHistory() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pHistory.setLayout(null);
        pHistory.setSize(900,650);
        
        //Membuat tabel/instansiasi
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        //menambahkan object ke panel
        lJudul.setFont(font1);
        pHistory.add(lJudul);
        pHistory.add(scrollPane);
        pHistory.add(tfSearch);
        pHistory.add(bSearch);
        pHistory.add(bRefresh);
        
        //mengeset letak dari setiap object
        lJudul.setBounds(260, 50, 500, 50);
        tfSearch.setBounds(260,130,400,25);
        bSearch.setBounds(660,130,80,25);
        bRefresh.setBounds(740,130,80,25);
        scrollPane.setBounds(260,160,570,400);
        
        
    }
    
    //untuk memperoleh nilai/string dari textfield
    public String getSearch() {
        return tfSearch.getText();
    }

    
}
