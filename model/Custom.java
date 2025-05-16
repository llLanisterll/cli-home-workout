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
        try {
            System.out.print("\nPilih hari untuk membuat jadwal latihan:\n> Hari ke-");
            int hari = input.nextInt();
            input.nextLine(); 
            
            if (hari <= 0) {
                System.out.println("Error: Hari harus lebih dari 0.");
                System.out.println("Tekan [ENTER] untuk kembali");
                input.nextLine();
                return;
            }

            System.out.print("\nBerapa gerakan ingin ditambahkan dalam sehari? > ");
            int jumlahGerakan = input.nextInt();
            input.nextLine(); 
            
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
                    i--; // Ulangi iterasi ini
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
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukan tidak valid. Harap masukkan angka.");
            input.nextLine(); // Clear the scanner buffer
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
        }
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

        try {
            System.out.println("\nPilih hari (0 untuk kembali ke menu utama)");
            System.out.print("> ");
            int pilihHari = input.nextInt();

            if (pilihHari == 0) return;
            
            if (!jadwalPerHari.containsKey(pilihHari)) {
                System.out.println("Error: Hari yang dipilih tidak memiliki jadwal latihan.");
                input.nextLine(); // Clear buffer
                System.out.println("Tekan [ENTER] untuk kembali");
                input.nextLine();
                return;
            }
            
            this.setPilihanHari(pilihHari);
            sesiLatihan.latihanCustom(input, pilihanHari);
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukan tidak valid. Harap masukkan angka.");
            input.nextLine(); // Clear buffer
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
        }
    }

    
    public void tampilkan() {
        if (jadwalPerHari.isEmpty()) {
            System.out.println("Belum ada jadwal latihan yang dibuat.");
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

        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukan tidak valid. Harap masukkan angka.");
            input.nextLine(); // Clear buffer
            System.out.println("Tekan [ENTER] untuk kembali");
            input.nextLine();
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