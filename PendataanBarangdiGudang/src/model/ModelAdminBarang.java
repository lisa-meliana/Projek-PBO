/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelAdminBarang implements ModelKelolaTabel{
    //membuat object/vaariabel statement
    public Statement statement; 
    
    @Override
    public int check(String kodeBarang) {
        //untuk mengecek apakah barang sudah ada atau belum
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM barang " +
                    "WHERE KodeBarang = '" + kodeBarang + "'";
            statement = (Statement) Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                count = resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    @Override
    public int delete(String kodeBarang) {
        //menghapus barang dari tabel barang
       int count = 0;
        try {
            if (check(kodeBarang) == 1){
                String query = "DELETE FROM barang WHERE KodeBarang = '" + kodeBarang + "'";
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

    
    @Override
    public int getCount() {
        //untuk mengetahui berapa banyak data yang ada di tabel barang
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM barang";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                count = resultSet.getInt("Count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    
    
    @Override
    public String[][] getAll() {
        //untuk membaca semua data yang ada di tabel barang
       String[][] data = new String[getCount()][3];
        try{
            String query = "SELECT * FROM barang ORDER BY NamaBarang ASC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = resultSet.getString("KodeBarang");
                data[i][1] = resultSet.getString("NamaBarang");
                data[i][2] = resultSet.getString("Stok");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }

    
    public int insertBarang(String kodeBarang, String namaBarang, String stok){
        //input barang ke tabel barang
        int count = 0;
        try {
            if (check(kodeBarang) == 0){
                String query = "INSERT INTO barang VALUES" +
                        "('" + kodeBarang + "','" + namaBarang + "','" + stok + "')";
                statement = (Statement) Database.getConnection().createStatement();
                statement.executeUpdate(query);
                count = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public int updateBarang(String kodeBarang, String namaBarang, String stok){
        //mengupdate nilai dari suatu field di tabel barang
        int count = 0;
        try {
            if (check(kodeBarang) == 1){
                String query = "UPDATE barang SET " +
                        "NamaBarang = '" + namaBarang + "', " +
                        "Stok = '" + stok + "' " +
                        "WHERE KodeBarang = '" + kodeBarang + "'";
                statement = Database.getConnection().createStatement();
                statement.executeUpdate(query);
                count = 1;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public String[][] searchBarang(String nama){
        //mencari data di tabel barang berdasarkna nama barang
        try{
            int jmlData = 0;
            
            String query = "Select * from barang WHERE NamaBarang LIKE '%" + nama + "%'"; 
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            
            String[][] data = new String[jmlData][3]; 
            
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Barang tidak ditemukan");
            }
            else {
                jmlData = 0;
                 
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    data[jmlData][0] = resultSet.getString("KodeBarang"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("NamaBarang");                
                    data[jmlData][2] = resultSet.getString("Stok");
                    
                    jmlData++;
                }
                
            }
            return data;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    

        
    
}
