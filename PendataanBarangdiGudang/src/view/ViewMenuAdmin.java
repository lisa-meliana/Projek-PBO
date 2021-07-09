/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import main.MVCAdminBarang;
import main.MVCAdminHistory;
import main.MVCAdminPetugas;


public class ViewMenuAdmin extends JFrame{
    // instansiasi panel, font, label, button, MVCadminpetugas,adminbarang,adminhistory
    public JPanel pMenuAdmin = new JPanel();
    
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    JLabel lMenu = new JLabel("Menu Admin");
    
    public JButton bPetugas = new JButton("Petugas");
    public JButton bBarang = new JButton("Barang");
    public JButton bHistory = new JButton("History");
    public JButton bKeluar = new JButton("Keluar");
    
    public MVCAdminPetugas mvcAdminPetugas = new MVCAdminPetugas();
    public MVCAdminBarang mvcAdminBarang = new MVCAdminBarang();
    public MVCAdminHistory mvcAdminHistory = new MVCAdminHistory();
    public ViewMenuAdmin() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Admin");
        
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        //mengeset font
        lMenu.setFont(font1);
        
        //menambahkan panel
        add(pMenuAdmin);
        add(mvcAdminPetugas.viewAdminPetugas.pPetugas);
        add(mvcAdminBarang.viewAdminBarang.pBarang);
        add(mvcAdminHistory.viewAdminHistory.pHistory);
        
        //menambahkan objeck ke panelMenuAdmin
        pMenuAdmin.add(bPetugas);
        pMenuAdmin.add(bBarang);
        pMenuAdmin.add(bHistory);
        pMenuAdmin.add(bKeluar);
        pMenuAdmin.add(lMenu);
        
        pMenuAdmin.setBounds(0,0,150,800);
        pMenuAdmin.setLayout(null);
        
        
        //mengeset letak dari objeck
        lMenu.setBounds(30, 20, 120, 20);
        bPetugas.setBounds(30,100,120,30);
        bBarang.setBounds(30,150,120,30);
        bHistory.setBounds(30,200,120,30);
        bKeluar.setBounds(30,250,120,30);
        
        tutup();
        //membuat panel pPetugas terlihat
        mvcAdminPetugas.viewAdminPetugas.pPetugas.setVisible(true);
    }
    
    public void tutup() {
        mvcAdminPetugas.viewAdminPetugas.pPetugas.setVisible(false);
        mvcAdminBarang.viewAdminBarang.pBarang.setVisible(false);
        mvcAdminHistory.viewAdminHistory.pHistory.setVisible(false);
    }
    
}
