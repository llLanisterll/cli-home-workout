package view;

import java.util.Scanner;
import model.CustomLatihan;
import model.SesiLatihan;

public class ConsoleView {
    public void tampilkanMenuUtama() {
        System.out.println("\nMenu Utama");
        System.out.println("1. Mulai Latihan Harian");
        System.out.println("2. Tantangan Fokus Tubuh");
        System.out.println("3. Lihat Progres Latihan");
        System.out.println("4. Custom Latihan");
        System.out.println("0. Keluar");
    }

    public void tampilkanMenuTantangan(Scanner input, SesiLatihan sesiLatihan) {
        System.out.println("\n== TANTANGAN FOKUS TUBUH ==");
        System.out.println("1. Upper Body\n2. Lower Body\n3. Cardio\n0. Kembali");
        System.out.print("> ");
        int pilih = input.nextInt();
        switch (pilih) {
            case 1 -> sesiLatihan.mulaiTantanganFokusTubuh(input, "Upper Body");
            case 2 -> sesiLatihan.mulaiTantanganFokusTubuh(input, "Lower Body");
            case 3 -> sesiLatihan.mulaiTantanganFokusTubuh(input, "Cardio");
            case 0 -> {}
            default -> System.out.println("Pilihan tidak valid.");
        }
    }

    public void tampilkanMenuCustomLatihan(Scanner input, CustomLatihan customLatihan) {
        boolean running = true;
        while (running) {
            System.out.println("\n== CUSTOM LATIHAN ==");
            System.out.println("1. Tambah Jadwal\n2. Lihat Jadwal\n3. Hapus Jadwal\n0. Kembali");
            System.out.print("> ");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1 -> customLatihan.inputGerakan(input);
                case 2 -> customLatihan.tampilkanMenuJadwal(input);
                case 3 -> customLatihan.hapusJadwal(input);
                case 0 -> running = false;
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        // System.out.println("\n== CUSTOM LATIHAN ==");
        // System.out.println("1. Tambah Jadwal\n2. Lihat Jadwal\n3. Hapus Jadwal\n0. Kembali");
        // System.out.print("> ");
        // int pilih = input.nextInt();
        // switch (pilih) {
        //     case 1 -> customLatihan.inputGerakan(input);
        //     case 2 -> customLatihan.tampilkanMenuJadwal(input);
        //     case 3 -> customLatihan.hapusJadwal(input);
        //     case 0 -> {}
        //     default -> System.out.println("Pilihan tidak valid.");
        // }
    }
}
