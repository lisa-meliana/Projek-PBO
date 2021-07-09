/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import main.Petugas;


public class ModelMenuPetugas extends ModelAdminBarang{
    //diwarisi sifatdanperilaku dari class ModelAdminBarang
    Petugas petugas;
    
    public ModelMenuPetugas(Petugas petugas) {
        this.petugas = petugas;
    }
    
    public int getStok(String kodeBarang) {
        //untuk mengetahui berapa jumlah stok yang ada berdasarkan kodebarang
        int stok=0;
        try{
            String query = "SELECT * FROM barang WHERE Kodebarang = '" + kodeBarang + "'";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                
                stok = resultSet.getInt("Stok");
                
            }
                
           
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return stok;
    }
    
    
    public int updateStokKeluar(String kodeBarang, int iKeluar){
        //mengupdate field stok saat barang keluar
        int count = 0;
        int iStok;
        
        int iMasuk = 0;
        try {
            if (check(kodeBarang) == 1){
                iStok = getStok(kodeBarang);
                
                
                iStok = iStok-iKeluar;
                if(iStok>=0){
                    insertHistory(kodeBarang, iKeluar, iMasuk);
                    String query = "UPDATE barang SET " +
                        "Stok = '" + iStok + "' " +
                        "WHERE KodeBarang = '" + kodeBarang + "'";
                    statement = Database.getConnection().createStatement();
                    statement.executeUpdate(query);
                    count = 1;
                }else{
                    JOptionPane.showMessageDialog(null,"Stok tidak cukup!");
                }

                
            }else{
                JOptionPane.showMessageDialog(null,"Barang Tidak Ada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    
    public void insertHistory(String kodeBarang, int keluar, int masuk){
        //menginput data ke tabel history
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String query = "INSERT INTO history VALUES " +
                    "(DEFAULT, '" + petugas.getKodePetugas() + "', '" +
                    kodeBarang + "', '" + date + "','" + keluar + "','" + masuk + "')";
            statement = (Statement) Database.getConnection().createStatement();
            statement.executeUpdate(query);
               
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    
    }
    
    
    public int updateStokMasuk(String kodeBarang, int iMasuk){
        //mengupdate field stok saat barang masuk
        int count = 0;
        int iStok;
        
        int iKeluar = 0;
        try {
            if (check(kodeBarang) == 1){
                iStok = getStok(kodeBarang);
                
                iStok = iStok+iMasuk;
             
                insertHistory(kodeBarang, iKeluar, iMasuk);
                String query = "UPDATE barang SET " +
                    "Stok = '" + iStok + "' " +
                    "WHERE KodeBarang = '" + kodeBarang + "'";
                statement = Database.getConnection().createStatement();
                statement.executeUpdate(query);
                count = 1;
            
            }else{
                JOptionPane.showMessageDialog(null,"Barang Tidak Ada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
    
}
