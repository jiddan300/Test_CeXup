package com.example.cexup.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cexup.database.MataKuliah
import com.example.cexup.databinding.ActivityMainBinding
import com.example.cexup.helper.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "List Matkul"

        val factory = ViewModelFactory.getInstance(application)
        viewmodel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager(this).orientation))

        viewmodel.getMatkul().observe(this){
            setMatKul(it)
        }
    }

    private fun setMatKul(it: List<MataKuliah>) {
        val adapter = ListMatkulAdapter(it)
        binding.rvMain.adapter = adapter
    }

}