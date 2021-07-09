/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerAdminHistory;
import model.ModelAdminHistory;
import view.ViewAdminHistory;


public class MVCAdminHistory {
    //Instansiasi untuk setiap View,Model dan Controller adminhistory
    public ViewAdminHistory viewAdminHistory = new ViewAdminHistory();
    public ModelAdminHistory modelAdminHistory = new ModelAdminHistory();
    public ControllerAdminHistory controllerAdminHistory = new ControllerAdminHistory(viewAdminHistory, modelAdminHistory);
}
