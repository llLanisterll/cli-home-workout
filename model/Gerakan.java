package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Gerakan {
    protected String namaGerakan;
    protected String bagianTubuh;

    public Gerakan(String namaGerakan, String bagianTubuh) {
        this.namaGerakan = namaGerakan;
        this.bagianTubuh = bagianTubuh;
    }

    public Gerakan(String namaGerakan) {
        this.namaGerakan = namaGerakan;
    }

    public abstract void tampilkanDetail();

    public String getNamaGerakan() {
        return namaGerakan;
    }

    public String getBagianTubuh() {
        return bagianTubuh;
    }

    public static List<Gerakan> getGerakanSesuaiTujuan(String tujuan) {
        // List<Gerakan> gerakan = new ArrayList<>();
        switch (tujuan.toLowerCase()) {
            case "menurunkan berat badan":
                return getGerakanMenurunkanBB();
            case "membentuk otot":
                return getGerakanMenambahOtot();
            case "menjaga stamina":
                return getGerakanStamina();
            default:
                System.out.println("Input tidak valid.");
                return new ArrayList<>();
        }
        // return gerakan;
    }

    public static List<Gerakan> getGerakanMenurunkanBB() {
        List<Gerakan> list = new ArrayList<>();
        list.add(new GerakanDurasi("Jumping Jacks", "Cardio", 30));
        list.add(new GerakanRepetisi("Mountain Climber", "Cardio", 20));
        list.add(new GerakanDurasi("High Knees", "Cardio", 30));
        list.add(new GerakanRepetisi("Burpee", "Full Body", 10));
        list.add(new GerakanDurasi("Plank", "Core", 30));
        list.add(new GerakanRepetisi("Squat", "Bawah", 15));
        list.add(new GerakanRepetisi("Push-Up", "Atas", 12));
        list.add(new GerakanDurasi("Lompat Tali (Simulasi)", "Cardio", 40));
        list.add(new GerakanRepetisi("Lunges", "Bawah", 10));
        list.add(new GerakanDurasi("Wall Sit", "Bawah", 30));
        return list;
    }

    public static List<Gerakan> getGerakanMenambahOtot() {
        List<Gerakan> list = new ArrayList<>();
        list.add(new GerakanRepetisi("Push-Up", "Atas", 15));
        list.add(new GerakanRepetisi("Pull-Up (simulasi)", "Atas", 10));
        list.add(new GerakanRepetisi("Squat", "Bawah", 20));
        list.add(new GerakanRepetisi("Glute Bridge", "Bawah", 15));
        list.add(new GerakanDurasi("Plank", "Core", 45));
        list.add(new GerakanRepetisi("Lunge", "Bawah", 12));
        list.add(new GerakanRepetisi("Crunch", "Perut", 20));
        list.add(new GerakanRepetisi("Chair Dips", "Atas", 10));
        list.add(new GerakanDurasi("Side Plank", "Core", 30));
        list.add(new GerakanRepetisi("Wall Push-Up", "Atas", 15));
        return list;
    }

    public static List<Gerakan> getGerakanStamina() {
        List<Gerakan> list = new ArrayList<>();
        list.add(new GerakanDurasi("Jogging di Tempat", "Cardio", 60));
        list.add(new GerakanDurasi("Jumping Jacks", "Cardio", 40));
        list.add(new GerakanDurasi("High Knees", "Cardio", 30));
        list.add(new GerakanDurasi("Burpee", "Cardio", 25));
        list.add(new GerakanDurasi("Lompat Tali (Simulasi)", "Cardio", 60));
        list.add(new GerakanDurasi("Skater Jumps", "Cardio", 30));
        list.add(new GerakanDurasi("Plank Jacks", "Core", 30));
        list.add(new GerakanDurasi("Butt Kicks", "Cardio", 40));
        list.add(new GerakanDurasi("Fast Feet", "Cardio", 20));
        list.add(new GerakanDurasi("Shadow Boxing", "Cardio", 30));
        return list;
    }

    public static List<Gerakan> getGerakanFokusAtas() {
        List<Gerakan> list = new ArrayList<>();
        list.add(new GerakanRepetisi("Push-Up", "Atas", 15));
        list.add(new GerakanRepetisi("Shoulder Tap", "Atas", 20));
        list.add(new GerakanRepetisi("Chair Dips", "Atas", 15));
        list.add(new GerakanDurasi("Arm Circles", "Atas", 30));
        list.add(new GerakanRepetisi("Wall Push-Up", "Atas", 20));
        list.add(new GerakanDurasi("Plank to Push-Up", "Atas", 30));
        list.add(new GerakanRepetisi("Incline Push-Up", "Atas", 12));
        list.add(new GerakanDurasi("Hand Raise Hold", "Atas", 30));
        list.add(new GerakanDurasi("Arm Pulse", "Atas", 30));
        list.add(new GerakanDurasi("Triceps Extension", "Atas", 30));
        return list;
    }

    public static List<Gerakan> getGerakanFokusBawah() {
        List<Gerakan> list = new ArrayList<>();
        list.add(new GerakanRepetisi("Squat", "Bawah", 20));
        list.add(new GerakanRepetisi("Lunge", "Bawah", 15));
        list.add(new GerakanRepetisi("Glute Bridge", "Bawah", 20));
        list.add(new GerakanDurasi("Wall Sit", "Bawah", 40));
        list.add(new GerakanRepetisi("Calf Raise", "Bawah", 25));
        list.add(new GerakanDurasi("Step Up (Simulasi)", "Bawah", 30));
        list.add(new GerakanDurasi("Side Lunge", "Bawah", 30));
        list.add(new GerakanDurasi("Knee Up", "Bawah", 30));
        list.add(new GerakanRepetisi("Donkey Kick", "Bawah", 15));
        list.add(new GerakanDurasi("Flutter Kick", "Bawah", 30));
        return list;
    }
}