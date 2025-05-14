package model;

public class GerakanRepetisi extends Gerakan {
    protected int repetisi;

    public GerakanRepetisi(String namaGerakan, String bagianTubuh, int repetisi) {
        super(namaGerakan, bagianTubuh);
        this.repetisi = repetisi;
    }

    public GerakanRepetisi(String namaGerakan, int repetisi) {
        super(namaGerakan);
        this.repetisi = repetisi;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println(namaGerakan + " (" + repetisi + " repetisi)");
    }

    public int getRepetisi() {
        return repetisi;
    }
}