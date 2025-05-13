package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SesiLatihan {
    private Pengguna pengguna;
    // private Gerakan gerakan;
    private CustomLatihan customLatihan;
    private String namaHari;
    private int pilihanHari;
    private boolean selesai;
    private int jumlahSesi = 0;
    // private List<CustomLatihan> daftarGerakanCustom;

    public SesiLatihan() {}
    public SesiLatihan(String namaHari) {
        this.namaHari = namaHari;
        this.selesai = false;
        // this.daftarGerakanCustom = new ArrayList<>();
    }

    public void menuLatihanHarian(Scanner input) {
        System.out.println("\n===========================");
        System.out.println("🗓️  MENU LATIHAN HARIAN");
        System.out.println("===========================\n");

        int totalHari = 6;
        for (int hari = 1; hari <= totalHari; hari++) {
            System.out.println("[" + hari + "] Hari " + hari + "");
        }
        System.out.println("\nPilih hari (0 untuk kembali ke menu utama)");
        System.out.print("> ");
        int pilihHari = input.nextInt();
        if (pilihHari == 0) return;

        this.setPilihanHari(pilihHari);
        this.mulaiLatihan(input);
    }

    public void mulaiLatihan(Scanner input) {
        System.out.println("===========================");
        System.out.println("🗓️  LATIHAN HARIAN - DAY " + pilihanHari);
        System.out.println("===========================\n");

        List<Gerakan> daftarGerakan = Gerakan.getGerakanSesuaiTujuan(pengguna.getTujuanLatihan());

        tampilkanDaftarGerakan(daftarGerakan);

        System.out.print("\nTekan ENTER untuk memulai latihan...");
        input.nextLine(); input.nextLine();

        mulaiGerakan(daftarGerakan, input);

        System.out.println("\n✅ Latihan untuk " + namaHari + " selesai! Good job!\n");
        tambahSesi();
        selesai = true;
    }

    public void mulaiTantanganFokusTubuh(Scanner input,String pilihan) {
        System.out.println("\n===========================");
        System.out.println("🗓️  LATIHAN: Fokus " + pilihan);
        System.out.println("===========================");

        List<Gerakan> gerakanTantangan = new ArrayList<>();
        if (pilihan.equalsIgnoreCase("Upper Body")) {
            gerakanTantangan = Gerakan.getGerakanFokusAtas();
        } else if (pilihan.equalsIgnoreCase("Lower Body")) {
            gerakanTantangan = Gerakan.getGerakanFokusBawah();
        } else if (pilihan.equalsIgnoreCase("Cardio")) {
            gerakanTantangan = Gerakan.getGerakanStamina();
        } else {
            System.out.println("Plihan tidak tersedia.");
        }

        tampilkanDaftarGerakan(gerakanTantangan);

        System.out.print("\nTekan ENTER untuk mulai latihan");
        input.nextLine();

        mulaiGerakan(gerakanTantangan, input);
    
        System.out.println("\n✅ Latihan " + pilihan + " selesai! Good job!");
        tambahSesi();
        System.out.print("\nTekan [ENTER] untuk keluar...");
        input.nextLine();
    }

    public void mulaiLatihanCustom(Scanner input, int pilihanHari) {
        System.out.println("\n===========================");
        System.out.println("🗓️  LATIHAN CUSTOM HARI-" + pilihanHari);
        System.out.println("===========================\n");

        List<Gerakan> daftarGerakanCustom = customLatihan.getJadwalHari(pilihanHari);

        if (daftarGerakanCustom.isEmpty()) {
            System.out.println("Jadwal belum ada. Lakukan input gerakan terlebih dahulu.");
            return;
        }

        tampilkanDaftarGerakan(daftarGerakanCustom);

        System.out.print("\nTekan ENTER untuk mulai latihan");
        input.nextLine(); // tunggu ENTER
        mulaiGerakan(daftarGerakanCustom, input);
    }


    public void tampilkanDaftarGerakan(List<Gerakan> gerakanList) {
        Collections.shuffle(gerakanList);
        System.out.println("Daftar Gerakan:");
        for (Gerakan g : gerakanList) {
            System.out.println("- " + g.getNamaGerakan());
        }
    }

    public void mulaiGerakan(List<Gerakan> gerakanList, Scanner input) {
        int nomor = 1;
        for (Gerakan g : gerakanList) {
            System.out.println("\nGerakan #" + nomor + ":");
            g.tampilkanDetail();
            System.out.print("Tekan ENTER jika sudah selesai...");
            input.nextLine();
            nomor++;
        }
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public void setCustomLatihan(CustomLatihan customLatihan) {
        this.customLatihan = customLatihan;
    }

    public void tambahSesi() {
        jumlahSesi++;
    }

    public int getJumlahSesi() {
        return jumlahSesi;
    }

    public String getNamaHari() {
        return namaHari;
    }

    public int getPilihanHari() {
        return pilihanHari;
    }

    public void setPilihanHari(int pilihanHari) {
        this.pilihanHari = pilihanHari;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void tandaiSelesai() {
        this.selesai = true;
    }

    // public void tambahGerakan(Gerakan g) {
    //     daftarGerakanCustom.add(g);
    // }

    // public List<Gerakan> getDaftarGerakan() {
    //     return daftarGerakanCustom;
    // }
}