package com.example.cexup.activity.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cexup.database.Dosen
import com.example.cexup.database.Mahasiswa
import com.example.cexup.helper.DataRepos

class DetailViewModel(private val application: Application):ViewModel() {
    private val dataRepos: DataRepos = DataRepos(application)

    fun getDosenMatkul(idMatkul:Int) = dataRepos.getDosen(idMatkul)
    fun getMHSMatkul(idMatkul:Int) = dataRepos.getMahasiswa(idMatkul)

    fun getMHSbyNim(idMatkul: Int, nim:String) = dataRepos.getMahasiswaByNim(idMatkul, nim)
    fun getMHSbyName(idMatkul: Int, nama:String) = dataRepos.getMahasiswaByName(idMatkul, nama)

    fun getMHSbyNimAndName(idMatkul: Int, nim:String, nama:String) = dataRepos.getMahasiswaByNimAndName(idMatkul, nim, nama)

}