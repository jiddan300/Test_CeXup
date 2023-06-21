Buat aplikasi Android menggunakan Room database sebagai local storage dengan spesifikasi berikut:

Entitas: Matakuliah, Mahasiswa, Dosen

1. Buatkan ERD dengan spesifikasi sebagai berikut:
	- Matakuliah : Mahasiswa -> 1 : Many
	- Dosen : Matakuliah -> 1 : 1

2. Pada Halaman List Utama, tampilkan daftar Matakuliah. Ketika pengguna mengklik salah satu matakuliah, tampilkan halaman detail matakuliah yang menampilkan detail dosen (NID dan NAMA) dan daftar mahasiswa (NIM dan NAMA) yang memiliki matakuliah tersebut.

3. Pada halaman detail matakuliah, tambahkan fitur pencarian untuk mencari mahasiswa berdasarkan NIM dan NAMA.

~~4. (Opsional) Pada halaman detail matakuliah, implementasikan pagination untuk menampilkan daftar mahasiswa secara bertahap.~~

5. Gunakan pola desain Model-View-ViewModel (MVVM) untuk mengorganisir kode Anda.

7. Gunakan Database ROOM sebagai local storage.

9. (HIGH PRIORITY) Buat project ini compatible dengan JDK 17 keatas.

~~8.Menggunakan Jetpack compose (nilai tambah)~~

9. Pengumpulan project melalui link github.
