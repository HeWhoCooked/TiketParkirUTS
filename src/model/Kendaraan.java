/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stevedownes
 */
public abstract class Kendaraan {
    private String platNomor;

    public Kendaraan(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public abstract String getJenis();
    public abstract int getTarifPerJam();
}
