package com.example.cexup.helper

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.cexup.database.*

class DataRepos(application: Application) {
    private val dataDao: DataDao

    init {
        val db = DataDatabase.getDatabase(application)
        dataDao = db.dataDao()
    }

    fun getMatkul(): LiveData<List<MataKuliah>> = dataDao.getMatkul()
    fun getDosen(idMatkul:Int): LiveData<Dosen> = dataDao.getDosen(idMatkul)
    fun getMahasiswa(idMatkul:Int): LiveData<List<Mahasiswa>> = dataDao.getMahasiswa(idMatkul)

    fun getMahasiswaByNim(idMatkul:Int, nim:String): LiveData<List<Mahasiswa>> = dataDao.getMahasiswaByNim(idMatkul, nim)
    fun getMahasiswaByName(idMatkul:Int, nama:String): LiveData<List<Mahasiswa>> = dataDao.getMahasiswaByName(idMatkul, nama)
    fun getMahasiswaByNimAndName(idMatkul:Int, nim:String, nama:String): LiveData<List<Mahasiswa>> = dataDao.getMahasiswaByNimAndName(idMatkul,nim , nama)

    suspend fun insertAllData() {
        dataDao.insertMatkul(InitialDataSource.setMatkul())
        dataDao.insertDosen(InitialDataSource.setDosen())
        dataDao.insertMahasiswa(InitialDataSource.setMahasiswa())
    }
}