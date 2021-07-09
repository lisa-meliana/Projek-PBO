/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModelLogin {
    private Statement statement;
    
    public int getLogin(String kodePetugas, String password){
        //mecari tau apakah kodepetugas dan password ada dan cocok
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM petugas " +
                    "WHERE KodePetugas = '" + kodePetugas + "' AND Password = '" + password + "'";
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
    
    public String[] getPetugas(String kodePetugas, String password){
        //mengambil data kodepetugas dan namalengkap dari petugas
        String data[] = new String[2];
        try {
            String query = "SELECT * FROM petugas " +
                    "WHERE KodePetugas = '" + kodePetugas + "' AND Password = '" + password + "'";
            statement = (Statement) Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                data[0] = resultSet.getString("KodePetugas");
                data[1] = resultSet.getString("NamaLengkap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }
}
