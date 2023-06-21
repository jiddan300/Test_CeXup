package com.example.cexup.helper

import com.example.cexup.database.Dosen
import com.example.cexup.database.Mahasiswa
import com.example.cexup.database.MataKuliah

object InitialDataSource {

    fun setMatkul(): List<MataKuliah> {
        return listOf(
            MataKuliah(1, "Matkul Dummy 1"),
            MataKuliah(2, "Matkul Dummy 2"),
            MataKuliah(3, "Matkul Dummy 3"),
        )
    }

    fun setMahasiswa(): List<Mahasiswa> {
        return listOf(
            Mahasiswa(1, "Mahasiswa Dummy 1", 1),
            Mahasiswa(2, "Mahasiswa Dummy 2", 2),
            Mahasiswa(3, "Mahasiswa Dummy 3", 3),
            Mahasiswa(4, "Mahasiswa Dummy 4", 1),
            Mahasiswa(5, "Mahasiswa Dummy 5", 2),
            Mahasiswa(6, "Mahasiswa Dummy 6", 3),
            Mahasiswa(7, "Mahasiswa Dummy 7", 1),
            Mahasiswa(8, "Mahasiswa Dummy 8", 2),
            Mahasiswa(9, "Mahasiswa Dummy 9", 3),
            Mahasiswa(10, "Mahasiswa Dummy 10", 1),
            Mahasiswa(11, "Mahasiswa Dummy 11", 2),
            Mahasiswa(12, "Mahasiswa Dummy 12", 3),
            Mahasiswa(13, "Mahasiswa Dummy 13", 1),
            Mahasiswa(14, "Mahasiswa Dummy 14", 2),
            Mahasiswa(15, "Mahasiswa Dummy 15", 3),
        )
    }

    fun setDosen(): List<Dosen> {
        return listOf(
            Dosen(1, "Dosen Dummy 1",3),
            Dosen(2, "Dosen Dummy 2",2),
            Dosen(3, "Dosen Dummy 3",1),
        )
    }
}