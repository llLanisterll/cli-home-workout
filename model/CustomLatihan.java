package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomLatihan {
    // private List<Gerakan> daftarGerakanCustom;
    private Map<Integer, List<Gerakan>> jadwalPerHari;
    private int pilihanHari;
    private SesiLatihan sesiLatihan;

    public CustomLatihan() {
        // this.daftarGerakanCustom = new ArrayList<>();
        this.jadwalPerHari = new HashMap<>();
    }

    public void inputGerakan(Scanner input) {
        System.out.print("\nPilih hari untuk membuat jadwal latihan:\n> Hari ke-");
        int hari = input.nextInt();
        input.nextLine(); // bersihkan newline

        System.out.print("\nBerapa gerakan ingin ditambahkan dalam sehari? > ");
        int jumlahGerakan = input.nextInt();
        input.nextLine(); // bersihkan newline

        List<Gerakan> daftarGerakan = new ArrayList<>();

        for (int i = 0; i < jumlahGerakan; i++) {
            System.out.print("\nGerakan ke-" + (i + 1) + ": ");
            String namaGerakan = input.nextLine();

            System.out.print("Jumlah repetisi atau durasi (ex: 12x atau 12s): ");
            String repetisi = input.nextLine();

            if (repetisi.endsWith("s")) {
                int durasi = Integer.parseInt(repetisi.replace("s", ""));
                daftarGerakan.add(new GerakanDurasi(namaGerakan, durasi));
            } else {
                int rep = Integer.parseInt(repetisi.replace("x", ""));
                daftarGerakan.add(new GerakanRepetisi(namaGerakan, rep));
            }
        }

        // Simpan daftar gerakan ke hari yang dipilih
        // jadwalPerHari.put(hari, daftarGerakan);
        if (!jadwalPerHari.containsKey(hari)) {
            jadwalPerHari.put(hari, new ArrayList<>());
        }
        jadwalPerHari.get(hari).addAll(daftarGerakan);

        System.out.println("\nJadwal latihan untuk hari ke-" + hari + " berhasil disimpan!");
        System.out.println("Tekan [ENTER] untuk kembali");
        input.nextLine();
    }

    public void tampilkanMenuJadwal(Scanner input) {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("\nJadwal belum ada. Lakukan input gerakan terlebih dahulu.");
            return;
        }

        System.out.println("\nDaftar Jadwal Latihan yang Kamu Buat: ");
        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("- Hari ke-" + hari);
        }

        System.out.println("\nPilih hari (0 untuk kembali ke menu utama)");
        System.out.print("> ");
        int pilihHari = input.nextInt();

        if (pilihHari == 0) return;
        this.setPilihanHari(pilihHari);
        sesiLatihan.mulaiLatihanCustom(input, pilihanHari);
    }

    
    public void tampilkanLatihan() {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("Belum ada jadwal latihan yang dibuat.");
            return;
        }

        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("\nHari ke-" + hari + ":");
            List<Gerakan> daftar = jadwalPerHari.get(hari);
            for (int i = 0; i < daftar.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftar.get(i).tampilkanDetail();
            }
        }
    }

    public void hapusJadwal(Scanner input) {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("Belum ada jadwal yang tersimpan.");
            return;
        }

        System.out.println("\n--- Daftar Hari dengan Jadwal ---");
        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("- Hari ke-" + hari);
        }

        System.out.print("Pilih hari yang ingin dihapus seluruh jadwalnya (0 untuk batal): ");
        int hari = input.nextInt();
        input.nextLine();

        if (hari == 0) {
            System.out.println("Penghapusan dibatalkan.");
            return;
        }

        if (jadwalPerHari.containsKey(hari)) {
            jadwalPerHari.remove(hari);
            System.out.println("✅ Jadwal untuk hari ke-" + hari + " berhasil dihapus.");
        } else {
            System.out.println("Hari tersebut tidak ditemukan dalam daftar.");
        }
    }


    public List<Gerakan> getJadwalHari(int hari) {
        return jadwalPerHari.getOrDefault(hari, new ArrayList<>());
    }

    public Map<Integer, List<Gerakan>> getJadwalPerHari() {
        return jadwalPerHari;
    }

    public boolean isEmpty() {
        return jadwalPerHari.isEmpty();
    }

    public void setPilihanHari(int pilihanHari) {
        this.pilihanHari = pilihanHari;
    }

    // public void tambahGerakanDurasi(String nama, int durasi) {
    //     daftarGerakanCustom.add(new GerakanDurasi(nama, durasi));
    // }

    // public void tambahGerakanRepetisi(String nama, int repetisi) {
    //     daftarGerakanCustom.add(new GerakanRepetisi(nama, repetisi));
    // }


    // public List<Gerakan> getDaftarGerakan() {
    //     return daftarGerakanCustom;
    // }

    public void setSesiLatihan(SesiLatihan sesiLatihan) {
        this.sesiLatihan = sesiLatihan;
    }
}
