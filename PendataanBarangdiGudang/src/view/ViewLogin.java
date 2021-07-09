/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.*;



public class ViewLogin extends JFrame{
    // instansiasi font, label, textfield, button
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 40);
    Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 20);
    JLabel lJudul = new JLabel("Login");
    JLabel lKodePetugas = new JLabel("KodePetugas");
    JLabel lPassword = new JLabel("Password");
    
    public JTextField tfKodePetugas = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    
    public JButton bLogin = new JButton("Login");

    public ViewLogin() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        //mengeset font
        lJudul.setFont(font1);
        lKodePetugas.setFont(font2);
        lPassword.setFont(font2);
        
        //menambahkan objeck pada view login
        add(lJudul);
        add(lKodePetugas);
        add(lPassword);
        add(tfKodePetugas);
        add(tfPassword);
        add(bLogin);
        
        //mengeset letak dari setiap objeck
        lJudul.setBounds(180,10,150,60);
        lKodePetugas.setBounds(20,90,150,40);
        lPassword.setBounds(20,150,150,40);
        tfKodePetugas.setBounds(180,98,210,30);
        tfPassword.setBounds(180,158,210,30);
        bLogin.setBounds(180,250,130,30);
        
    }
    
    //untuk mendapatkan nilai dari textfield
    public String getKodePetugas() {
        return tfKodePetugas.getText();
    }
    
    public String getPassword() {
        return tfPassword.getText();
    }
    
    
}
