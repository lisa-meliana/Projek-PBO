/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.MVCLogin;
import view.ViewMenuAdmin;


public class ControllerMenuAdmin implements ActionListener{
    //membuat object
    ViewMenuAdmin viewMenuAdmin;

    public ControllerMenuAdmin(ViewMenuAdmin viewMenuAdmin) {
        this.viewMenuAdmin = viewMenuAdmin;
        //menambahkan actionlistener
        viewMenuAdmin.bPetugas.addActionListener(this);
        viewMenuAdmin.bBarang.addActionListener(this);
        viewMenuAdmin.bHistory.addActionListener(this);
        viewMenuAdmin.bKeluar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //jika button diklik, maka setiap panel akan tidak diperlihatkan, 
        //yang diperlihatkan hanya yang sesuai dengan button yang diklik
        if (e.getSource() == viewMenuAdmin.bPetugas){
            viewMenuAdmin.tutup();
            viewMenuAdmin.mvcAdminPetugas.viewAdminPetugas.pPetugas.setVisible(true);
        }else if(e.getSource() == viewMenuAdmin.bBarang){
            viewMenuAdmin.tutup();
            viewMenuAdmin.mvcAdminBarang.viewAdminBarang.pBarang.setVisible(true);
        }else if(e.getSource() == viewMenuAdmin.bHistory){
            viewMenuAdmin.tutup();
            viewMenuAdmin.mvcAdminHistory.viewAdminHistory.pHistory.setVisible(true);
        }else if (e.getSource() == viewMenuAdmin.bKeluar){
            //aat keluar viewmenuadmin ditutup dan membuat MVCLogin
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Keluar?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0){
                viewMenuAdmin.setVisible(false);
                new MVCLogin();
            }
        }
    }
    
    
}
