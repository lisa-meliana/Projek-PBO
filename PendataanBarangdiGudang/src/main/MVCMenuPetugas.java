/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerMenuPetugas;
import model.ModelMenuPetugas;
import view.ViewMenuPetugas;


public class MVCMenuPetugas {
    //Instansiasi untuk setiap View,Model dan Controller MenuPetugas
    Petugas petugas;
    public ViewMenuPetugas viewMenuPetugas;
    public ModelMenuPetugas modelMenuPetugas;
    public MVCMenuPetugas(Petugas petugas) {
        this.petugas = petugas;
        viewMenuPetugas = new ViewMenuPetugas(petugas);
        modelMenuPetugas = new ModelMenuPetugas(petugas);
        ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(viewMenuPetugas, modelMenuPetugas);
    }
    
    
     
}
