# Home Workout - Aplikasi Latihan Fitness Terminal

## 📋 Deskripsi

Home Workout adalah aplikasi berbasis terminal yang dirancang untuk membantu pengguna mencapai tujuan kebugaran mereka di rumah tanpa perlu peralatan gym khusus. Aplikasi ini menyediakan program latihan yang dipersonalisasi berdasarkan data fisik pengguna, seperti BMI (Body Mass Index) dan BMR (Basal Metabolic Rate), sehingga latihan yang direkomendasikan lebih tepat sasaran dan efektif.

## ✨ Fitur Utama

- **Analisis Data Fisik**: Menghitung BMI dan BMR pengguna untuk memberikan saran latihan yang tepat
- **Program Latihan Harian**: Menyediakan latihan terstruktur untuk tiap hari
- **Tantangan Fokus Tubuh**: Latihan khusus untuk bagian tubuh tertentu (upper body, lower body, cardio)
- **Custom Latihan**: Memungkinkan pengguna membuat program latihan sendiri
- **Pencatatan Progres**: Memantau perubahan berat badan dan konsistensi latihan
- **Evaluasi Otomatis**: Memberikan saran berdasarkan perubahan berat badan sesuai tujuan latihan

## 🚀 Memulai

### Prasyarat
- Java Runtime Environment (JRE) 17 atau lebih tinggi
- Terminal atau Command Prompt

### Instalasi
1. Clone repository ini:
   ```
   git clone https://github.com/llLanisterll/cli-home-workout.git
   ```
2. Kompilasi program:
   ```
   javac -d bin src/**/*.java
   ```
3. Jalankan aplikasi:
   ```
   java -cp bin Main
   ```

### Struktur Folder
```
CLI-HOME-WORKOUT/
│___
│   ├── controller/              
│   ├── image/           
│   ├── model/              
│   └── view/           
│      
├── Main.java            
│
└── README.md             
```

## 📖 Penggunaan

### Input Data Pengguna
Saat pertama kali menjalankan aplikasi, pengguna akan diminta untuk memasukkan:
- Nama
- Jenis Kelamin (L/P)
- Usia
- Berat Badan (kg)
- Tinggi Badan (cm)
- Tujuan Latihan (Menurunkan berat badan, Membentuk otot, Menjaga stamina)

### Menu Utama
Setelah input data, pengguna dapat mengakses fitur-fitur berikut:
1. **Mulai Latihan Harian** - Program latihan sesuai tujuan yang dipilih
2. **Tantangan Fokus Tubuh** - Latihan khusus untuk bagian tubuh tertentu
3. **Lihat Progres Latihan** - Pantau perkembangan dan evaluasi hasil
4. **Custom Latihan** - Buat dan kelola jadwal latihan sendiri
0. **Keluar** - Keluar dari aplikasi

### Custom Latihan
Menu ini memungkinkan pengguna untuk:
1. **Tambah Jadwal** - Membuat jadwal latihan baru dengan gerakan tertentu
2. **Lihat Jadwal** - Melihat jadwal yang telah dibuat
3. **Hapus Jadwal** - Menghapus jadwal latihan tertentu

### Format Input Gerakan Custom
- Nama gerakan: [nama gerakan]
- Format repetisi:
  - Repetisi: [jumlah]x (contoh: 12x)
  - Durasi: [waktu]s (contoh: 30s)

### Tantangan Fokus Tubuh
Terdapat 3 jenis tantangan:
1. **Upper Body** - Fokus pada latihan bagian atas tubuh
2. **Lower Body** - Fokus pada latihan bagian bawah tubuh
3. **Cardio** - Fokus pada latihan kardiovaskular

### Progress Latihan
Fitur ini memungkinkan pengguna untuk:
- Memasukkan berat badan terbaru
- Melihat perubahan berat badan
- Mendapatkan evaluasi berdasarkan tujuan latihan
- Melihat statistik konsistensi latihan

## 🔧 Struktur Aplikasi

Aplikasi ini menggunakan arsitektur Model-View berbasis objek dengan struktur sebagai berikut:

### Diagram Kelas
![Class Diagram Home Workout App](images/DiagramClass.png)

*Diagram kelas menunjukkan hubungan antar komponen aplikasi*

### Package `model`
- `Pengguna` - Mengelola data pengguna dan kalkulasi BMI/BMR
- `Gerakan` - Kelas abstrak untuk jenis gerakan
  - `GerakanRep` - Gerakan dengan jumlah repetisi
  - `GerakanDur` - Gerakan dengan durasi waktu
- `Sesi` - Mengelola sesi latihan
- `Custom` - Mengelola jadwal latihan custom
- `Progress` - Memantau dan mengevaluasi progress latihan
- `Evaluasi` - Interface untuk evaluasi progress

### Package `view`
- `Tampilan` - Menampilkan menu dan interface pengguna

## 🔍 Contoh Penggunaan

### Input Data Pengguna
```
╔══════════════════════════════════╗
║   SELAMAT DATANG DI APLIKASI     ║
║         HOME WORKOUT             ║
╚══════════════════════════════════╝

Silakan masukkan data diri Anda:
──────────────────────────────────
Nama Lengkap: John Doe
Jenis Kelamin (L/P): L
Usia: 25
Berat Badan (kg): 70
Tinggi Badan (cm): 175

HASIL ANALISIS:
BMI: 22.9 (Normal)
BMR: 1696 kcal/hari
Fokus: Membentuk otot atau menjaga stamina

╔══════════════════════════╗
║   PILIH TUJUAN LATIHAN   ║
╠══════════════════════════╣
║ 1. Menurunkan berat badan║
║ 2. Membentuk otot        ║
║ 3. Menjaga stamina       ║
╚══════════════════════════╝
> 2

Tujuan dipilih: Membentuk otot
```

### Custom Latihan
```
╔══════════════════════════╗
║      CUSTOM LATIHAN      ║
╠══════════════════════════╣
║ 1. Tambah Jadwal         ║
║ 2. Lihat Jadwal          ║
║ 3. Hapus Jadwal          ║
║ 0. Kembali               ║
╚══════════════════════════╝

> 1

Pilih hari untuk membuat jadwal latihan:
> Hari ke-1

Berapa gerakan ingin ditambahkan dalam sehari? > 3

Gerakan ke-1: Push Up
Jumlah repetisi atau durasi (ex: 12x atau 12s): 15x

Gerakan ke-2: Plank
Jumlah repetisi atau durasi (ex: 12x atau 12s): 30s

Gerakan ke-3: Sit Up
Jumlah repetisi atau durasi (ex: 12x atau 12s): 20x

Jadwal latihan untuk hari ke-1 berhasil disimpan!
```

## 🔄 Evaluasi Progress

Aplikasi akan mengevaluasi progress berdasarkan tujuan latihan yang dipilih:

### Untuk "Menurunkan berat badan":
- Evaluasi positif jika berat turun
- Rekomendasi untuk perbanyak cardio dan defisit kalori jika berat naik

### Untuk "Membentuk otot":
- Evaluasi positif jika berat naik
- Rekomendasi untuk perbanyak protein dan surplus kalori jika berat turun

### Untuk "Menjaga stamina":
- Fokus pada peningkatan stamina terlepas dari perubahan berat badan

## ⚠️ Penanganan Error

Aplikasi dilengkapi dengan penanganan error untuk input yang tidak valid:
- Input angka yang di luar rentang yang diharapkan
- Input karakter ketika aplikasi mengharapkan angka
- Input kosong pada field yang wajib diisi

## 👨‍💻 Pengembang

Aplikasi Home Workout dikembangkan sebagai proyek mahasiswa di Fakultas Matematika dan Ilmu Pengetahuan Alam Universitas Hasanuddin jurusan Sistem Informasi.
