package controller;

import java.util.Scanner;
import model.*;
import view.ConsoleView;

public class HomeWorkoutController {
    private final Pengguna pengguna;
    private final Progres progres;
    private final SesiLatihan sesiLatihan;
    private final CustomLatihan customLatihan;
    private final ConsoleView view;
    private final Scanner input;

    public HomeWorkoutController(Scanner input) {
        this.input = input;
        this.pengguna = new Pengguna();
        this.sesiLatihan = new SesiLatihan();
        this.customLatihan = new CustomLatihan();
        this.progres = new Progres();
        this.view = new ConsoleView();

        this.sesiLatihan.setPengguna(pengguna);
        sesiLatihan.setCustomLatihan(customLatihan);
        this.customLatihan.setSesiLatihan(sesiLatihan);
        this.progres.setPengguna(pengguna);
        this.progres.setSesiLatihan(sesiLatihan);
    }

    public void mulai() {
        pengguna.inputData(input);

        boolean running = true;
        while (running) {
            view.tampilkanMenuUtama();
            System.out.print("> ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> sesiLatihan.menuLatihanHarian(input);
                case 2 -> view.tampilkanMenuTantangan(input, sesiLatihan);
                case 3 -> progres.TampilkanProgres(input);
                case 4 -> view.tampilkanMenuCustomLatihan(input, customLatihan);
                case 0 -> {
                    System.out.println("\n==== Terimakasih telah menggunakan Aplikasi Home Workout! ====\n");
                    running = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
