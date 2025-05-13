package model;

// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class Progres implements Evaluasi {
    private Pengguna pengguna;
    private SesiLatihan sesiLatihan;

    public void setSesiLatihan(SesiLatihan sesiLatihan) {
        this.sesiLatihan = sesiLatihan;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public void tampilkanRiwayat() {
        System.out.println("\n📜 RIWAYAT GERAKAN:");

        if (sesiLatihan.getJumlahSesi() == 0) {
            System.out.println("Belum ada sesi latihan yang diselesaikan.");
            return;
        }

        int jumlahSelesai = sesiLatihan.getJumlahSesi();
        int totalHari = 6;

        double konsistensi = ((double) jumlahSelesai / totalHari) * 100;
        System.out.println("- Kamu telah menyelesaikan " + jumlahSelesai + " sesi latihan dari " + totalHari + " hari");
        System.out.printf("- Konsistensi: %.0f%%\n", konsistensi);
        }

    public void TampilkanProgres(Scanner input) {
        System.out.println("\n=====================");
        System.out.println("📈  PROGRES LATIHAN");
        System.out.println("=====================");

        System.out.print("\nMasukkan berat badan terbaru (kg): ");
        double bbBaru = input.nextDouble();
        input.nextLine();

        evaluasiPerubahanBB(bbBaru);
        tampilkanRiwayat();

        System.out.print("\nTekan [Enter] untuk kembali");
        input.nextLine();
    }

    @Override
    public void evaluasiPerubahanBB(double bbBaru) {
        double bbTerakhir = pengguna.getBeratBadan();
        System.out.println("Berat badan sebelumnya: " + bbTerakhir + " kg");
        double perubahanBB = bbBaru - bbTerakhir;
        // if (pengguna.getTujuanLatihan().equalsIgnoreCase("Membentuk otot")) {
        //     if (perubahanBB < 0) {
        //         System.out.println("Status: Berat badan kamu turun " + (perubahanBB * -1) + " kg");
        //         System.out.println("Jangan lupa untuk surplus kalori dan protein.");
        //     } else if (perubahanBB > 0) {
        //         System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
        //     } else {
        //         System.out.println("Status: Berat badan kamu tidak berubah");
        //         System.out.println("Perbanyak latihan angkat beban serta surplus kalori dan protein harianmu.");
        //     }
        // } else if (pengguna.getTujuanLatihan().equalsIgnoreCase("Menurunkan berat badan")) {
        //     if (perubahanBB < 0) {
        //         System.out.println("Status: Berat badan kamu turun " + (perubahanBB * -1) + " kg");
        //     } else if (perubahanBB > 0) {
        //         System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
        //         System.out.println("Perbanyak cardio dan defisit kalori harianmu.");
        //     } else {
        //         System.out.println("Status: Berat badan kamu tidak berubah");
        //         System.out.println("Perbanyak cardio dan defisit kalori harianmu.");
        //     }
        // } else if (pengguna.getTujuanLatihan().equalsIgnoreCase("Menjaga stamina")) {
        //     if (perubahanBB < 0) {
        //         System.out.println("Status: Berat badan kamu turun " + (perubahanBB * -1) + " kg");
        //     } else if (perubahanBB > 0) {
        //         System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
        //     } else {
        //         System.out.println("Status: Berat badan kamu tidak berubah");
        //     }
        // }
        // pengguna.setBeratBadan(bbBaru);
        
        String tujuan = pengguna.getTujuanLatihan() != null ? pengguna.getTujuanLatihan().toLowerCase() : "";

        switch (tujuan) {
            case "membentuk otot":
                tampilkanEvaluasiBulking(perubahanBB);
                break;
            case "menurunkan berat badan":
                tampilkanEvaluasiCutting(perubahanBB);
                break;
            case "menjaga stamina":
                tampilkanEvaluasiStamina(perubahanBB);
                break;
            default:
                System.out.println("Tujuan latihan tidak dikenali.");
        }

        pengguna.setBeratBadan(bbBaru);
        
    }

    private void tampilkanEvaluasiBulking(double perubahanBB) {
        if (perubahanBB < 0) {
            System.out.println("Status: Berat badan kamu turun " + Math.abs(perubahanBB) + " kg");
            System.out.println("Jangan lupa untuk surplus kalori dan konsumsi cukup protein.");
        } else if (perubahanBB > 0) {
            System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
        } else {
            System.out.println("Status: Berat badan kamu tidak berubah");
            System.out.println("Perbanyak latihan beban serta surplus kalori dan protein harian.");
        }
    }

    private void tampilkanEvaluasiCutting(double perubahanBB) {
        if (perubahanBB < 0) {
            System.out.println("Status: Berat badan kamu turun " + Math.abs(perubahanBB) + " kg");
        } else if (perubahanBB > 0) {
            System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
            System.out.println("Perbanyak cardio dan defisit kalori harianmu.");
        } else {
            System.out.println("Status: Berat badan kamu tidak berubah");
            System.out.println("Perbanyak cardio dan defisit kalori harianmu.");
        }
    }

    private void tampilkanEvaluasiStamina(double perubahanBB) {
        if (perubahanBB < 0) {
            System.out.println("Status: Berat badan kamu turun " + Math.abs(perubahanBB) + " kg");
        } else if (perubahanBB > 0) {
            System.out.println("Status: Berat badan kamu naik " + perubahanBB + " kg");
        } else {
            System.out.println("Status: Berat badan kamu tidak berubah");
        }
    }
}
