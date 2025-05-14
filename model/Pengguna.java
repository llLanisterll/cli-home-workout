package model;

import java.util.Scanner;

public class Pengguna {
    private String nama;
    private String jenisKelamin;
    private int usia;
    private double beratBadan;
    private double tinggiBadan;
    private double bmi;
    private double bmr;
    private String tujuanLatihan;

    public void inputData(Scanner input) {
        System.out.println("===============================");
        System.out.println("🏠 SELAMAT DATANG DI HOME WORKOUT APP");
        System.out.println("===============================\n");

        System.out.println("Masukkan nama kamu: ");
        System.out.print(">");
        this.nama = input.nextLine();
        System.out.println("\n=== Halo " + this.nama + "! Sebelum memulai latihan, silahkan masukkan data diri kamu.===\n");
        System.out.println("Masukkan jenis kelamin (L/P): ");
        System.out.print(">");
        this.jenisKelamin = input.nextLine().toUpperCase();
        System.out.println("Berapa usai kamu: ");
        System.out.print(">");
        this.usia = input.nextInt();
        System.out.println("Berapa berat badan kamu sekarang? (Kg): ");
        System.out.print(">");
        this.beratBadan = input.nextDouble();
        System.out.println("Berapa tinggi badan kamu? (cm): ");
        System.out.print(">");
        this.tinggiBadan = input.nextDouble();

        System.out.println("\n-------------------------------------");
        hasilAnalisiTubuh();
        tampilkanSaran();

        System.out.println("\n-------------------------------------");
        System.out.println("🎯 PILIH TUJUAN LATIHAN KAMU:");
        System.out.println("1. Menurunkan berat badan");
        System.out.println("2. Membentuk otot");
        System.out.println("3. Menjaga stamina");
        System.out.print("   > ");
        int pilihan = input.nextInt();
        pilihTujuanLatihan(pilihan);
        input.nextLine();
        
        System.out.print("\nTekan ENTER untuk melanjutkan ke Menu Utama...");
        input.nextLine();
    }

    private double hitungBMR () {
        if (jenisKelamin.equalsIgnoreCase("L")) {
            bmr = 66 + (13.7 * beratBadan) + (5 * tinggiBadan) - (6.8 * usia);
        } else {
            bmr = 655 + (9.6 * beratBadan) + (1.8 * tinggiBadan) - (4.7 * usia);
        }
        return bmr;
    }

    private double hitungBMI() {
        double tinggiMeter = tinggiBadan / 100;
        bmi = beratBadan / (tinggiMeter * tinggiMeter);
        return bmi;
    }

    private String kategoriBMI() {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 24.9) return "Normal";
        if (bmi < 29.9) return "Overweight";
        return "Obese";
    }

    private void hasilAnalisiTubuh() {
        double bmi = hitungBMI();
        String kategoriBMI = kategoriBMI();
        double bmr = hitungBMR();
        System.out.println("📊 ANALISIS TUBUH KAMU: ");
        System.out.println("BMI: " + bmi + " (" + kategoriBMI + ")");
        System.out.println("BMR (jumlah kalori harian rata-rata): " + bmr + " kcal\n");
    }

    private void tampilkanSaran() {
        String kategori = kategoriBMI();
        if (kategori.equals("Underweight")) {
            System.out.println("📌 Berat badanmu kurang. \n>> Disarankan untuk fokus pada: Menambah berat badan dan massa otot 🍗");
        } else if (kategori.equals("Normal")) {
            System.out.println("📌 Kamu berada dalam kategori sehat. \n>> Disarankan untuk fokus pada: Membentuk otot atau menjaga stamina💪");
        } else {
            System.out.println("📌 Kamu kelebihan berat badan. \n>> Disarankan untuk fokus pada: Menurunkan berat badan 🏃‍♂️");
        }
    }

    private void pilihTujuanLatihan(int pilihan) {
        switch (pilihan) {
            case 1:
                tujuanLatihan = "Menurunkan berat badan";
                break;
            case 2:
                tujuanLatihan = "Membentuk otot";
                break;
            case 3:
                tujuanLatihan = "Menjaga stamina";
                break;
            default:
                System.out.println("❗ Input tidak valid! Silahkan pilih menu yang tersedia.");
        }

        System.out.println("✅ Tujuan latihan kamu: " + tujuanLatihan);
        setTujuanLatihan(tujuanLatihan);
    }

    public void setTujuanLatihan(String tujuan) {
        this.tujuanLatihan = tujuan;
    }

    public String getTujuanLatihan() {
        return this.tujuanLatihan;
    }

    public double getBeratBadan() {
        return this.beratBadan;
    }

    public void setBeratBadan(double bbBaru) {
        this.beratBadan = bbBaru;
    }
}