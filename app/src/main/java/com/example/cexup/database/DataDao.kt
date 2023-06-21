package com.example.cexup.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMatkul(university: List<MataKuliah>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDosen(university: List<Dosen>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMahasiswa(student: List<Mahasiswa>)

    @Transaction
    @Query("select * from MataKuliah")
    fun getMatkul() : LiveData<List<MataKuliah>>

    @Transaction
    @Query("select * from Dosen where idMatkulMengajar = :idMatkul")
    fun getDosen(idMatkul:Int) : LiveData<Dosen>

    @Transaction
    @Query("select * from Mahasiswa where idMatkulTerdaftar = :idMatkul")
    fun getMahasiswa(idMatkul:Int) : LiveData<List<Mahasiswa>>

    @Transaction
    @Query("select * from Mahasiswa where idMatkulTerdaftar = :idMatkul and nim like '%' || :nim || '%'")
    fun getMahasiswaByNim(idMatkul:Int, nim:String) : LiveData<List<Mahasiswa>>
    @Transaction
    @Query("select * from Mahasiswa where idMatkulTerdaftar = :idMatkul and nama like '%' || :nama || '%'")
    fun getMahasiswaByName(idMatkul:Int, nama:String) : LiveData<List<Mahasiswa>>
    @Transaction
    @Query("select * from Mahasiswa where idMatkulTerdaftar = :idMatkul and nim = :nim and nama like '%' || :nama || '%'")
    fun getMahasiswaByNimAndName(idMatkul:Int, nim:String, nama:String) : LiveData<List<Mahasiswa>>

}