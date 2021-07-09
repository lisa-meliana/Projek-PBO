/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import controller.ControllerAdminBarang;
import model.ModelAdminBarang;
import view.ViewAdminBarang;




public class MVCAdminBarang {
    //Instansiasi untuk setiap View,Model dan Controller Adminbarang
    public ViewAdminBarang viewAdminBarang = new ViewAdminBarang();
    public ModelAdminBarang modelAdminBarang = new ModelAdminBarang();
    public ControllerAdminBarang controllerAdminBarang = new ControllerAdminBarang(viewAdminBarang, modelAdminBarang); 
}
