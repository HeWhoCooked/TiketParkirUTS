/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stevedownes
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tiket {
    private String nomorTiket;
    private Kendaraan kendaraan;
    private LocalDateTime waktuMasuk;

    // Constructor
    public Tiket(String nomorTiket, Kendaraan kendaraan) {
        this.nomorTiket = nomorTiket;
        this.kendaraan = kendaraan;
        this.waktuMasuk = LocalDateTime.now();
    }

    // Getter dan Setter
    public String getNomorTiket() {
        return nomorTiket;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    public String getWaktuMasukFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return waktuMasuk.format(formatter);
    }

    @Override
    public String toString() {
        return "=== TIKET PARKIR ===\n" +
               "Nomor Tiket  : " + nomorTiket + "\n" +
               "Plat Nomor   : " + kendaraan.getPlatNomor() + "\n" +
               "Jenis        : " + kendaraan.getJenis() + "\n" +
               "Waktu Masuk  : " + getWaktuMasukFormatted() + "\n" +
               "--------------------";
    }
}
