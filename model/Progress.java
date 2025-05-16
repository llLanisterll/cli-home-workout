package model;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Progress implements Evaluasi {
    private Pengguna user;
    private Sesi sesi;
    
    public void setSesi(Sesi sesi) {
        this.sesi = sesi;
    }

    public void setUser(Pengguna user) {
        this.user = user;
    }

    public void riwayat() {
        System.out.println( "\n╔══════════════════════════╗");
        System.out.println("║      RIWAYAT LATIHAN     ║");
        System.out.println("╚══════════════════════════╝" );

        if (sesi == null) {
            System.out.println( "Data sesi tidak tersedia" );
            return;
        }

        if (sesi.getJumlahSesi() == 0) {
            System.out.println("Belum ada sesi latihan");
            return;
        }

        int jumlahSelesai = sesi.getJumlahSesi();
        int totalHari = 6;
        double konsistensi = ((double) jumlahSelesai / totalHari) * 100;
        
        System.out.printf("Selesai: %d/%d sesi%n", jumlahSelesai, totalHari);
        System.out.printf("Konsistensi: %.0f%%%n", konsistensi);
    }

    public void progress(Scanner input) {
        System.out.println( "\n╔══════════════════════════╗");
        System.out.println("║     PROGRES LATIHAN      ║");
        System.out.println("╚══════════════════════════╝" );
        
        if (user == null) {
            System.out.println( "Data user tidak tersedia" );
            return;
        }

        try {
            System.out.print("\nMasukkan berat badan terbaru (kg): " );
            double bbBaru = input.nextDouble();
            input.nextLine();

            if (bbBaru <= 0 || bbBaru > 300) {
                System.out.println( "Berat badan tidak valid" );
                return;
            }

            evalBB(bbBaru);
            riwayat();

            System.out.print("\nTekan [ENTER] untuk kembali..." );
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println( "Input harus angka" );
            input.nextLine();
        }
    }

    @Override
    public void evalBB(double bbBaru) {
        if (user == null) {
            System.out.println( "Data user tidak tersedia" );
            return;
        }
        
        double bbTerakhir = user.getBeratBadan();
        double perubahanBB = bbBaru - bbTerakhir;
        String tujuan = user.getTujuanLatihan();
        
        System.out.println( "\nHASIL EVALUASI:" );
        System.out.printf("Berat sebelumnya: %.1f kg%n", bbTerakhir);
        System.out.printf("Berat sekarang: %.1f kg%n", bbBaru);
        System.out.printf("Perubahan: %.1f kg%n", perubahanBB);
        
        if (tujuan == null) {
            System.out.println( "Tujuan latihan belum diatur" );
            return;
        }
        
        switch (tujuan.toLowerCase()) {
            case "membentuk otot" -> evalBulking(perubahanBB);
            case "menurunkan berat badan" -> evalCutting(perubahanBB);
            case "menjaga stamina" -> evalStamina(perubahanBB);
            default -> System.out.println( "Tujuan tidak dikenali" );
        }

        user.setBeratBadan(bbBaru);
    }

    private void evalBulking(double perubahanBB) {
        System.out.println(  "\nEVALUASI BULKING:" );
        if (perubahanBB < 0) {
            System.out.printf("Berat turun %.1f kg%n", Math.abs(perubahanBB));
            System.out.println("Perbanyak protein dan surplus kalori");
        } else if (perubahanBB > 0) {
            System.out.printf("Berat naik %.1f kg%n", perubahanBB);
            System.out.println("Progress baik! Lanjutkan!");
        } else {
            System.out.println("Berat stabil");
            System.out.println("Tingkatkan intensitas latihan");
        }
    }

    private void evalCutting(double perubahanBB) {
        System.out.println( "\nEVALUASI CUTTING:" );
        if (perubahanBB < 0) {
            System.out.printf("Berat turun %.1f kg%n", Math.abs(perubahanBB));
            System.out.println("Progress baik! Lanjutkan!");
        } else if (perubahanBB > 0) {
            System.out.printf("Berat naik %.1f kg%n", perubahanBB);
            System.out.println("Perbanyak cardio dan defisit kalori");
        } else {
            System.out.println("Berat stabil");
            System.out.println("Perbaiki defisit kalori");
        }
    }

    private void evalStamina(double perubahanBB) {
        System.out.println( "\nEVALUASI STAMINA:" );
        if (perubahanBB != 0) {
            System.out.printf("Berat %s %.1f kg%n", 
                perubahanBB < 0 ? "turun" : "naik", 
                Math.abs(perubahanBB));
        } else {
            System.out.println("Berat stabil");
        }
        System.out.println("Fokus pada peningkatan stamina");
    }
}