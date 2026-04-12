/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.util.*;
import model.*;
/**
 *
 * @author stevedownes
 */
public class ParkirService {
    private Map<String, Tiket> tiketAktif = new HashMap<>();
    private int kapasitas;

    private Transaksi transaksi = new Transaksi();
    private Riwayat riwayat = new Riwayat();

    public ParkirService(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    private String generateTiket() {
        return "TKT-" + (tiketAktif.size() + 1);
    }

    //  Masuk
    public void parkir(Kendaraan k) {

        if (tiketAktif.size() >= kapasitas) {
            System.out.println("Parkir penuh! Tidak bisa parkir " + k.getJenis());
            return;
        }

        String nomor = generateTiket();
        Tiket tiket = new Tiket(nomor, k);

        tiketAktif.put(nomor, tiket);

        System.out.println("Masuk:");
        System.out.println(tiket);
    }

    //  Keluar
    public void keluar(String nomorTiket) {

        Tiket tiket = tiketAktif.get(nomorTiket);

        if (tiket == null) {
            System.out.println("Tiket tidak ditemukan!");
            return;
        }

        long biaya = transaksi.hitungBiaya(tiket);

        String data = tiket.getKendaraan().getPlatNomor()
                + " | " + tiket.getKendaraan().getJenis()
                + " | Rp " + biaya;

        riwayat.tambah(data);

        System.out.println("Keluar:");
        System.out.println(data);

        tiketAktif.remove(nomorTiket);
    }

    public void daftarParkir() {
        System.out.println("=== DAFTAR PARKIR ===");
        for (Tiket t : tiketAktif.values()) {
            System.out.println(t);
        }
    }

    public void tampilkanRiwayat() {
        riwayat.tampilkan();
    }
}
