/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.MVCMenuAdmin;
import main.MVCMenuPetugas;
import main.Petugas;
import model.ModelLogin;
import view.ViewLogin;


public class ControllerLogin implements ActionListener{
    //membuat object
    ViewLogin viewLogin;
    ModelLogin modelLogin;

    public ControllerLogin(ViewLogin viewLogin, ModelLogin modelLogin) {
        this.viewLogin = viewLogin;
        this.modelLogin = modelLogin;

        //nemambahkan actionlistener
        viewLogin.bLogin.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == viewLogin.bLogin){
            login();
        }
    }
    
    public void login(){
        //mendapatkan nilai(string) dari textfield
        String kodePetugas = viewLogin.getKodePetugas();
        String password = viewLogin.getPassword();
        //textfield tidakboleh kosong
        if (kodePetugas.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else if(kodePetugas.equals("admin") && password.equals("admin123")){
            //masuk sebagai admin, lalu instansiasi MVCMenuAdmin
            JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
            viewLogin.setVisible(false);
            MVCMenuAdmin mvcMenuAdmin = new MVCMenuAdmin();
        }else{
            //memanggil metod getLogin
            if (modelLogin.getLogin(kodePetugas, password) == 1) {
                JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
                viewLogin.setVisible(false);
                //mencari namadan kode petugas
                String data[] = modelLogin.getPetugas(kodePetugas , password);
                Petugas petugas = new Petugas(data[0], data[1]);
                //instansiasi MVCMenuPetugas, masuk sebagai petugas
                MVCMenuPetugas mvcMenuPetugas = new MVCMenuPetugas(petugas);
            } else {
                JOptionPane.showMessageDialog(null, "Kode Petugas / Password Salah");
            }
            
        }
  
    }
}
