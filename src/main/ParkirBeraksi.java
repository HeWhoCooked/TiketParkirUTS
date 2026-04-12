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
        // Inisialisasi kapasitas parkir, misalnya 10 slot
        ParkirService service = new ParkirService(10);
        Scanner input = new Scanner(System.in);
        boolean berjalan = true;

        System.out.println("=== SISTEM MANAJEMEN PARKIR ===");

        while (berjalan) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Input Kendaraan Masuk");
            System.out.println("2. Proses Kendaraan Keluar");
            System.out.println("3. Tampilkan Daftar Parkir Aktif");
            System.out.println("4. Tampilkan Riwayat Transaksi");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih menu (1-5): ");
            
            int menu = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (menu) {
                case 1:
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

                    // Menjalankan logic parkir masuk
                    service.parkir(kendaraanBaru);
                    break;

                case 2:
                    System.out.println("\n--- PROSES KENDARAAN KELUAR ---");
                    System.out.print("Masukkan Nomor Tiket: ");
                    String nomorTiket = input.nextLine();

                    // Menjalankan logic parkir keluar yang sudah mencakup hitung biaya & simpan riwayat
                    service.keluar(nomorTiket);
                    break;

                case 3:
                    service.daftarParkir();
                    break;

                case 4:
                    service.tampilkanRiwayat();
                    break;

                case 5:
                    berjalan = false;
                    System.out.println("Aplikasi ditutup. Selamat tinggal!");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
                    break;
            }
        }
        input.close();
    }
}