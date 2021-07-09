/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Database {
    private static Connection connection;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/gudang";
    static final String DBusername = "root";
    static final String DBpassword = "";

    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName(JDBC_DRIVER);
                connection =  DriverManager.getConnection(DBurl,DBusername, DBpassword);
                System.out.println("Koneksi Berhasil");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getStackTrace());
                System.out.println("Koneksi Gagal " + ex.getMessage());
            }
        }
        return connection;
    }
}
