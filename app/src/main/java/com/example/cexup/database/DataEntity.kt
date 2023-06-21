package com.example.cexup.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class MataKuliah(
    @PrimaryKey
    val idMatkul: Int,
    val nama: String,
)

@Entity
data class Dosen(
    @PrimaryKey
    val nid: Int, // nomor induk dosen
    val nama: String,
    val idMatkulMengajar: Int
)

@Entity
data class Mahasiswa(
    @PrimaryKey
    val nim: Int, // nomor induk mahasiswa
    val nama: String,
    val idMatkulTerdaftar: Int
)

data class MatkuldanMahasiswa(
    @Embedded
    val MatKul :MataKuliah,

    @Relation(
        parentColumn = "idMatKul",
        entityColumn = "idMatkulTerdaftar"
    )
    val mahasiswa :List<Mahasiswa>
)

data class MatkuldanDosen(
    @Embedded
    val MatKul: MataKuliah,

    @Relation(
        parentColumn = "idMatKul",
        entityColumn = "idMatkulMengajar"
    )
    val dosen :Dosen
)