package view;

import java.util.Scanner;
import model.Custom;
import model.Sesi;

public class Tampilan {
    
    public void menuUtama() {
        System.out.println( "\n╔══════════════════════════╗");
        System.out.println("║       MENU UTAMA         ║");
        System.out.println("╠══════════════════════════╣");
        System.out.println("║ 1. Mulai Latihan Harian  ║");
        System.out.println("║ 2. Tantangan Fokus Tubuh ║");
        System.out.println("║ 3. Lihat Progres Latihan ║");
        System.out.println("║ 4. Custom Latihan        ║");
        System.out.println("║ 0. Keluar                ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("\n> ");
    }

    public void menuTantangan(Scanner input, Sesi sesi) {
        System.out.println( "\n╔══════════════════════════╗");
        System.out.println("║   TANTANGAN FOKUS TUBUH  ║");
        System.out.println("╠══════════════════════════╣");
        System.out.println("║ 1. Upper Body            ║");
        System.out.println("║ 2. Lower Body            ║");
        System.out.println("║ 3. Cardio                ║");
        System.out.println("║ 0. Kembali               ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("\n> ");
        
        int pilih = input.nextInt();
        switch (pilih) {
            case 1 -> sesi.tantangan(input, "Upper Body");
            case 2 -> sesi.tantangan(input, "Lower Body");
            case 3 -> sesi.tantangan(input, "Cardio");
            case 0 -> {}
            default -> System.out.println( "\nPilihan tidak valid!");
        }
    }

    public void menuCustom(Scanner input, Custom latihanCustom) {
        boolean running = true;
        while (running) {
            System.out.println( "\n╔══════════════════════════╗");
            System.out.println("║      CUSTOM LATIHAN      ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1. Tambah Jadwal         ║");
            System.out.println("║ 2. Lihat Jadwal          ║");
            System.out.println("║ 3. Hapus Jadwal          ║");
            System.out.println("║ 0. Kembali               ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("\n> ");
            
            int pilih = input.nextInt();
            switch (pilih) {
                case 1 -> latihanCustom.input(input);
                case 2 -> latihanCustom.jadwal(input);
                case 3 -> latihanCustom.hapus(input);
                case 0 -> running = false;
                default -> System.out.println( "\nPilihan tidak valid!");
            }
        }
    }
}