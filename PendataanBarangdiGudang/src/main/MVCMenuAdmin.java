/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerMenuAdmin;
import view.ViewMenuAdmin;


public class MVCMenuAdmin {
    //Instansiasi untuk View dan Controller menuadmin
    public ViewMenuAdmin viewMenuAdmin = new ViewMenuAdmin();
    ControllerMenuAdmin controllerMenuAdmin = new ControllerMenuAdmin(viewMenuAdmin);
    
}
