package controller;

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
        pengguna.input(input);

        boolean running = true;
        while (running) {
            view.menuUtama();
            System.out.print("> ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> sesiLatihan.latihanHarian(input);
                case 2 -> view.menuTantangan(input, sesiLatihan);
                case 3 -> progres.progress(input);
                case 4 -> view.menuCustom(input, customLatihan);
                case 0 -> {
                    System.out.println("\n==== Terimakasih telah menggunakan Aplikasi Home Workout! ====\n");
                    running = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
