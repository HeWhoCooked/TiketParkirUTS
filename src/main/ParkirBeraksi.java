/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.*;
import logic.*;
import java.util.Scanner;
/**
 *
 * @author stevedownes
 */
public class ParkirBeraksi {
    public static void main(String[] args) {
        ParkirService service = new ParkirService();
        Transaksi transaksi = new Transaksi();
        Scanner input = new Scanner(System.in);
        boolean berjalan = true;

        System.out.println("=== SISTEM MANAJEMEN PARKIR ===");

        while (berjalan) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Input Kendaraan Masuk");
            System.out.println("2. Proses Kendaraan Keluar");
            System.out.println("3. Keluar Aplikasi");
            System.out.print("Pilih menu (1-3): ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.println("\n--- PENDAFTARAN KENDARAAN MASUK ---");
                System.out.println("Pilih Jenis Kendaraan:");
                System.out.println("1. Mobil (Tarif: Rp 5000/jam)");
                System.out.println("2. Motor (Tarif: Rp 2000/jam)");
                System.out.print("Masukkan pilihan (1/2): ");
                int pilihanJenis = input.nextInt();
                input.nextLine(); 

                System.out.print("Masukkan Plat Nomor Kendaraan: ");
                String platNomor = input.nextLine();

                Kendaraan kendaraanBaru;
                if (pilihanJenis == 1) {
                    kendaraanBaru = new Mobil(platNomor);
                } else if (pilihanJenis == 2) {
                    kendaraanBaru = new Motor(platNomor);
                } else {
                    System.out.println("Pilihan tidak valid! Transaksi dibatalkan.");
                    continue;
                }

                Tiket tiket = service.kendaraanMasuk(kendaraanBaru);
                System.out.println("\nBerhasil Terdaftar!");
                System.out.println(tiket.toString());

                } else if (menu == 2) {
                // Proses Keluar tetap menggunakan pencarian tiket
                System.out.println("\n--- PROSES KENDARAAN KELUAR ---");
                System.out.print("Masukkan Nomor Tiket: ");
                String nomorTiket = input.nextLine();

                Tiket tiketDitemukan = service.cariTiket(nomorTiket);

                if (tiketDitemukan != null) {
                    long durasi = transaksi.hitungDurasi(tiketDitemukan);
                    int total = transaksi.hitungTotalBayar(tiketDitemukan, durasi);
                    
                    transaksi.cetakStruk(tiketDitemukan, durasi, total);
                    service.hapusTiket(tiketDitemukan);
                    System.out.println("Pembayaran Berhasil. Silakan Keluar.");
                } else {
                    System.out.println("Maaf, Nomor Tiket tidak ditemukan di sistem.");
                }

            } else if (menu == 3) {
                berjalan = false;
                System.out.println("Aplikasi ditutup. Selamat tinggal!");
            } else {
                System.out.println("Menu tidak tersedia.");
            }
        }
        input.close();
    }
}
