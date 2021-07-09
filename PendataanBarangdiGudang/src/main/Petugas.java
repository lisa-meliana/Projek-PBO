/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


public class Petugas {
    //membuat object/variabel
    private String kodePetugas;
    private String namaPetugas;
    //constructor
    public Petugas(String kodePetugas, String namaPetugas) {
        this.kodePetugas = kodePetugas;
        this.namaPetugas = namaPetugas;
    }
    //getter
    public String getKodePetugas() {
        return kodePetugas;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    
}
