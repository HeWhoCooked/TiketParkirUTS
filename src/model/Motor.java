/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stevedownes
 */
public class Motor extends Kendaraan{
    public Motor(String platNomor) {
        super(platNomor);
    }

    @Override
    public String getJenis() {
        return "Motor";
    }

    @Override
    public int getTarifPerJam() {
        return 2000;
    }
}
