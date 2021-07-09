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


public class ModelAdminPetugas implements ModelKelolaTabel{
    //membuat object statement
    private Statement statement;
    
    
    
    @Override
    public int check(String kodePetugas) {
        //mengecek apakah kodepetugas sudah terdaftar atau belum
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM petugas " +
                    "WHERE KodePetugas = '" + kodePetugas + "'";
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

  
    
    
    
    public int insertPetugas(String kodePetugas, String nama, String password, String alamat){
        //input data petugas baru ke tabel petugas
        int count = 0;
        try {
            if (check(kodePetugas) == 0){
                String query = "INSERT INTO petugas VALUES" +
                        "('" + kodePetugas + "','" + nama + "','" + password + "','" + alamat + "')";
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
    
    @Override
    public int getCount(){
        //mencari berapa banyak data/baris yang ada ditabel petugas
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as Count FROM petugas";
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
    public String[][] getAll(){
        //membaca/mengambil semua data yang ada pada tabel petugas
        String[][] data = new String[getCount()][4];
        try{
            String query = "SELECT * FROM petugas ORDER BY NamaLengkap ASC";
            statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                data[i][0] = resultSet.getString("KodePetugas");
                data[i][1] = resultSet.getString("NamaLengkap");
                data[i][2] = resultSet.getString("Password");
                data[i][3] = resultSet.getString("Alamat");
   
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public int updatePetugas(String kodePetugas, String nama, String password, String alamat){
        //mengupdate nilai pada suatu field di tabel petugas
        int count = 0;
        try {
            if (check(kodePetugas) == 1){
                String query = "UPDATE petugas SET " +
                        "NamaLengkap = '" + nama + "', " +
                        "Password = '" + password + "', Alamat = '" + alamat + "' " +
                        "WHERE KodePetugas = '" + kodePetugas + "'";
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
    
    @Override
    public int delete(String kodePetugas){
        //menghapus data pada tabel petugas
        int count = 0;
        try {
            if (check(kodePetugas) == 1){
                String query = "DELETE FROM petugas WHERE KodePetugas = '" + kodePetugas + "'";
                statement = Database.getConnection().createStatement();
                statement.executeUpdate(query);
                count = 1;
            }else{
                JOptionPane.showMessageDialog(null,"Petugas Tidak Ada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    
    
   
}
