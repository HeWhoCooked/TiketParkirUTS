/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.util.ArrayList;
/**
 *
 * @author stevedownes
 */
public class Riwayat {
    private ArrayList<String> riwayatList = new ArrayList<>();

    public void tambah(String data) {
        riwayatList.add(data);
    }

    public void tampilkan() {
        System.out.println("=== RIWAYAT TRANSAKSI ===");
        for (String r : riwayatList) {
            System.out.println(r);
        }
    }
}
