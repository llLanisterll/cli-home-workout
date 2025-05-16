package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Custom {
    private Map<Integer, List<Gerakan>> jadwalPerHari;
    private int pilihanHari;
    private Sesi sesiLatihan;

    public Custom() {
        this.jadwalPerHari = new HashMap<>();
    }

    public void input(Scanner input) {
        int hari;
        try {
            System.out.print("\nPilih hari untuk membuat jadwal latihan:\n> Hari ke-");
            hari = input.nextInt();
            input.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukkan harus berupa angka.");
            input.nextLine(); 
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        if (hari <= 0) {
            System.out.println("Error: Hari harus lebih dari 0.");
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        int jumlahGerakan;
        try {
            System.out.print("\nBerapa gerakan ingin ditambahkan dalam sehari? > ");
            jumlahGerakan = input.nextInt();
            input.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukkan harus berupa angka.");
            input.nextLine(); 
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        if (jumlahGerakan <= 0) {
            System.out.println("Error: Jumlah gerakan harus lebih dari 0.");
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        List<Gerakan> daftarGerakan = new ArrayList<>();

        for (int i = 0; i < jumlahGerakan; i++) {
            System.out.print("\nGerakan ke-" + (i + 1) + ": ");
            String namaGerakan = input.nextLine();

            if (namaGerakan.trim().isEmpty()) {
                System.out.println("Error: Nama gerakan tidak boleh kosong. Ulangi input.");
                i--; 
                continue;
            }

            System.out.print("Jumlah repetisi atau durasi (ex: 12x atau 12s): ");
            String repetisi = input.nextLine();

            try {
                if (repetisi.endsWith("s")) {
                    int durasi = Integer.parseInt(repetisi.replace("s", ""));
                    if (durasi <= 0) {
                        System.out.println("Error: Durasi harus lebih dari 0. Ulangi input gerakan ini.");
                        i--;
                        continue;
                    }
                    daftarGerakan.add(new GerakanDur(namaGerakan, durasi));
                } else if (repetisi.endsWith("x")) {
                    int rep = Integer.parseInt(repetisi.replace("x", ""));
                    if (rep <= 0) {
                        System.out.println("Error: Repetisi harus lebih dari 0. Ulangi input gerakan ini.");
                        i--;
                        continue;
                    }
                    daftarGerakan.add(new GerakanRep(namaGerakan, rep));
                } else {
                    System.out.println("Error: Format repetisi tidak valid. Gunakan format seperti '12x' atau '12s'. Ulangi input.");
                    i--;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Format angka tidak valid. Ulangi input gerakan ini.");
                i--;
                continue;
            }
        }

        if (!jadwalPerHari.containsKey(hari)) {
            jadwalPerHari.put(hari, new ArrayList<>());
        }
        jadwalPerHari.get(hari).addAll(daftarGerakan);

        System.out.println("\nJadwal latihan untuk hari ke-" + hari + " berhasil disimpan!");
        System.out.println("Tekan [ENTER] untuk kembali");
        input.nextLine();
    }

    public void jadwal(Scanner input) {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("\nJadwal belum ada. Lakukan input gerakan terlebih dahulu.");
            return;
        }

        System.out.println("\nDaftar Jadwal Latihan yang Kamu Buat: ");
        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("- Hari ke-" + hari);
        }

        int pilihHari;
        try {
            System.out.println("\nPilih hari (0 untuk kembali ke menu utama)");
            System.out.print("> ");
            pilihHari = input.nextInt();
            input.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukan harus berupa angka.");
            input.nextLine();
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        if (pilihHari == 0) return;

        if (!jadwalPerHari.containsKey(pilihHari)) {
            System.out.println("Error: Hari yang dipilih tidak memiliki jadwal latihan.");
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            input.nextLine();
            return;
        }

        this.setPilihanHari(pilihHari);
        sesiLatihan.latihanCustom(input, pilihanHari);
    }

    public void tampilkan() {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("\nBelum ada jadwal latihan yang dibuat.");
            return;
        }

        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("\nHari ke-" + hari + ":");
            List<Gerakan> daftar = jadwalPerHari.get(hari);
            for (int i = 0; i < daftar.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftar.get(i).detail();
            }
        }
    }

    public void hapus(Scanner input) {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("Belum ada jadwal yang tersimpan.");
            return;
        }

        System.out.println("\n--- Daftar Hari dengan Jadwal ---");
        for (Integer hari : jadwalPerHari.keySet()) {
            System.out.println("- Hari ke-" + hari);
        }

        int hariHapus;
        try {
            System.out.print("Pilih hari yang ingin dihapus seluruh jadwalnya (0 untuk batal): ");
            hariHapus = input.nextInt();
            input.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukan tidak valid. Harap masukkan angka.");
            input.nextLine();
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
            return;
        }

        if (hariHapus == 0) {
            System.out.println("Penghapusan dibatalkan.");
            return;
        }

        if (jadwalPerHari.containsKey(hariHapus)) {
            jadwalPerHari.remove(hariHapus);
            System.out.println("Jadwal untuk hari ke-" + hariHapus + " berhasil dihapus.");
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

    public void setSesiLatihan(Sesi sesiLatihan) {
        this.sesiLatihan = sesiLatihan;
    }
}