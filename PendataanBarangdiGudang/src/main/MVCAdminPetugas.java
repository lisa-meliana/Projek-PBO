/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerAdminPetugas;
import model.ModelAdminPetugas;
import view.ViewAdminPetugas;

public class MVCAdminPetugas {
    //Instansiasi untuk setiap View,Model dan Controller adminpetugas
    public ViewAdminPetugas viewAdminPetugas = new ViewAdminPetugas();
    public ModelAdminPetugas modelAdminPetugas = new ModelAdminPetugas();
    public ControllerAdminPetugas controllerAdminPetugas = new ControllerAdminPetugas(viewAdminPetugas, modelAdminPetugas);
}
