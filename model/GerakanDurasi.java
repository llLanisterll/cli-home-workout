package model;

public class GerakanDurasi extends Gerakan {
    protected int durasi;

    public GerakanDurasi(String namaGerakan, String bagianTubuh, int durasi) {
        super(namaGerakan, bagianTubuh);
        this.durasi = durasi;
    }

    public GerakanDurasi(String namaGerakan, int durasi) {
        super(namaGerakan);
        this.durasi = durasi;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println(namaGerakan + " (" + durasi + " detik)");
    }

    public int getDurasi() {
        return durasi;
    }
}