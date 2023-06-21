package com.example.cexup.activity.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cexup.database.MataKuliah
import com.example.cexup.helper.DataRepos
import kotlinx.coroutines.launch

class MainViewModel(private val application: Application) :ViewModel() {
    private val dataRepos:DataRepos = DataRepos(application)
    init {
        insertAllData()
    }

    fun getMatkul(): LiveData<List<MataKuliah>> = dataRepos.getMatkul()


    private fun insertAllData() = viewModelScope.launch{
        dataRepos.insertAllData()
    }
}