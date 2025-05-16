package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
import view.Tampilan;

public class Controller {
    private final Pengguna pengguna;
    private final Progress progres;
    private final Sesi sesiLatihan;
    private final Custom customLatihan;
    private final Tampilan view;
    private final Scanner input;
    
    public Controller(Scanner input) {
        this.input = input;
        this.pengguna = new Pengguna();
        this.sesiLatihan = new Sesi();
        this.customLatihan = new Custom();
        this.progres = new Progress();
        this.view = new Tampilan();
        
        this.sesiLatihan.setUser(pengguna);
        sesiLatihan.setLatihanCustom(customLatihan);
        this.customLatihan.setSesiLatihan(sesiLatihan);
        this.progres.setUser(pengguna);
        this.progres.setSesi(sesiLatihan);
    }
    
    public void mulai() {
        try {
            pengguna.input(input);
            
            boolean running = true;
            while (running) {
                try {
                    view.menuUtama();
                    System.out.print("> ");
                    int pilihan = input.nextInt();
                    
                    switch (pilihan) {
                        case 1 -> jalankanLatihanHarian();
                        case 2 -> jalankanMenuTantangan();
                        case 3 -> jalankanProgress();
                        case 4 -> jalankanMenuCustom();
                        case 0 -> {
                            System.out.println("\n==== Terimakasih telah menggunakan Aplikasi Home Workout! ====\n");
                            running = false;
                        }
                        default -> System.out.println("Pilihan tidak valid. Silakan pilih angka 0-4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Masukan harus berupa angka.");
                    input.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    input.nextLine(); 
                }
            }
        } catch (Exception e) {
            System.out.println("Error saat menjalankan aplikasi: " + e.getMessage());
        }
    }
    
    private void jalankanLatihanHarian() {
        try {
            sesiLatihan.latihanHarian(input);
        } catch (Exception e) {
            System.out.println("Error pada menu Latihan Harian: " + e.getMessage());
        }
    }
    
    private void jalankanMenuTantangan() {
        try {
            view.menuTantangan(input, sesiLatihan);
        } catch (Exception e) {
            System.out.println("Error pada menu Tantangan: " + e.getMessage());
        }
    }
    
    private void jalankanProgress() {
        try {
            progres.progress(input);
        } catch (Exception e) {
            System.out.println("Error pada menu Progress: " + e.getMessage());
        }
    }
    
    private void jalankanMenuCustom() {
        try {
            view.menuCustom(input, customLatihan);
        } catch (Exception e) {
            System.out.println("Error pada menu Custom: " + e.getMessage());
        }
    }
}