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


public class ModelAdminHistory {
    //membuat object statement
    private Statement statement; 
    
    public int getCount() {
        //untuk mecari berapa banyak data yang berada pada tabel history
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM history";
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
    
    
    public String[][] getHistory() {
        //untuk mendapatkan semua data yang ada berada pada tabel history(yang dijoinkan dengan tabel petugas dan barang)
       String[][] data = new String[getCount()][6];
        try{
            String query = "SELECT * FROM (history h JOIN barang b ON h.KodeBarang = b.KodeBarang) JOIN petugas p ON h.KodePetugas = p.KodePetugas " +
                    "ORDER BY h.No ASC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = "" + (i+1);
                data[i][1] = resultSet.getString("NamaLengkap");
                data[i][2] = resultSet.getString("NamaBarang");
                data[i][3] = resultSet.getString("Tanggal");
                data[i][4] = resultSet.getString("JumlahKeluar");
                data[i][5] = resultSet.getString("JumlahMasuk");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    
    public String[][] searchHistory(String nama){
        //mencari data berdasarkan namabarang ditabel history yrng join dengan tabel petugas dan barang
        try{
            int i = 0;
            
            String query = "SELECT * FROM (history h JOIN barang b ON h.KodeBarang = b.KodeBarang) JOIN petugas p ON h.KodePetugas = p.KodePetugas " +
                    "WHERE b.NamaBarang LIKE '%" + nama + "%' " +"ORDER BY h.No ASC"; 
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                i++;
            }
            
            String[][] data = new String[i][6]; 
            
            
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Barang tidak ditemukan");
            }
            else {
                i = 0;
                 
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    data[i][0] = "" + (i+1);
                    data[i][1] = resultSet.getString("NamaLengkap");
                    data[i][2] = resultSet.getString("NamaBarang");
                    data[i][3] = resultSet.getString("Tanggal");
                    data[i][4] = resultSet.getString("JumlahKeluar");
                    data[i][5] = resultSet.getString("JumlahMasuk");
                    
                    i++;
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
