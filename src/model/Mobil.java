/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stevedownes
 */
public class Mobil extends Kendaraan {
    public Mobil(String platNomor) {
        super(platNomor);
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }

    @Override
    public int getTarifPerJam() {
        return 5000;
    }
}
