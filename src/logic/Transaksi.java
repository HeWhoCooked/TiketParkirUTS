/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import model.Tiket;
import java.time.Duration;
import java.time.LocalDateTime;
/**
 *
 * @author stevedownes
 */
public class Transaksi {
    public long hitungBiaya(Tiket tiket) {
        LocalDateTime keluar = LocalDateTime.now();

        long durasiMenit = Duration.between(
                tiket.getWaktuMasuk(),
                keluar
        ).toMinutes();

        long jam = (long) Math.ceil(durasiMenit / 60.0);

        int tarif = tiket.getKendaraan().getTarifPerJam();

        return jam * tarif;
    }
}
