/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.ModelAdminHistory;
import view.ViewAdminHistory;


public class ControllerAdminHistory implements ActionListener{
    //membuat object
    ViewAdminHistory viewAdminHistory;
    ModelAdminHistory modelAdminHistory;

    public ControllerAdminHistory(ViewAdminHistory viewAdminHistory, ModelAdminHistory modelAdminHistory) {
        this.viewAdminHistory = viewAdminHistory;
        this.modelAdminHistory = modelAdminHistory;
        
        refreshTable();
        //manambahkan actionlistener
        viewAdminHistory.bSearch.addActionListener(this);
        viewAdminHistory.bRefresh.addActionListener(this);
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        //menjalankan metod jika button diklik
        if (e.getSource() == viewAdminHistory.bSearch){
            search();
        }else if (e.getSource() == viewAdminHistory.bRefresh){
            refreshTable();
        }
    }
      
    
    
    public void refreshTable(){
        //merefresh idi dalam tabel
        String data[][] = modelAdminHistory.getHistory();
        viewAdminHistory.table.setModel(new JTable(data, viewAdminHistory.coloumnName).getModel());
    
    }
    
    public void search(){
        //mencari data berdasarkan nama barang
        String nama = viewAdminHistory.getSearch();
        String data[][] = modelAdminHistory.searchHistory(nama);

        viewAdminHistory.table.setModel(new JTable(data, viewAdminHistory.coloumnName).getModel());

    }
    
    
}
