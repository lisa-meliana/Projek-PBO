/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerLogin;
import model.ModelLogin;
import view.ViewLogin;


public class MVCLogin {
    //Instansiasi untuk setiap View,Model dan Controller untuk Login
    ViewLogin viewLogin = new ViewLogin();
    ModelLogin modelLogin = new ModelLogin();
    ControllerLogin controllerLogin = new ControllerLogin(viewLogin, modelLogin);
}
