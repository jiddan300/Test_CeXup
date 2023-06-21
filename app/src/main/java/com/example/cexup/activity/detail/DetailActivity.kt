package com.example.cexup.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cexup.database.Mahasiswa
import com.example.cexup.databinding.ActivityDetailBinding
import com.example.cexup.helper.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewmodel: DetailViewModel
    private lateinit var adapter : ListMahasiswaAdapter

    private var idMatkul : Int = 0
    private var nimMHS :String = ""
    private var namaMHS :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val factory = ViewModelFactory.getInstance(application)
        viewmodel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        idMatkul = intent.getIntExtra("idMatkul", 0)

        binding.tvNamaMatkul.text = intent.getStringExtra("namaMatkul")
        viewmodel.getDosenMatkul(idMatkul).observe(this){
            binding.tvNamaDosen.text = it.nama
        }

        binding.rvDetail.layoutManager = LinearLayoutManager(this)
        binding.rvDetail.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager(this).orientation))

        viewmodel.getMHSMatkul(idMatkul).observe(this){
            setMHS(it)
        }

        binding.fabSearch.setOnClickListener {
            binding.linearSearch.isVisible = binding.linearSearch.isVisible != true
        }

        binding.nimMhs.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                nimMHS = s.toString()
                searchMHS(idMatkul, nimMHS, namaMHS)
            }

            override fun afterTextChanged(s: Editable?) {
                //nothing
            }

        })

        binding.namaMhs.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                namaMHS = s.toString()
                searchMHS(idMatkul, nimMHS, namaMHS)
            }

            override fun afterTextChanged(s: Editable?) {
                //nothing
            }

        })

    }

    private fun searchMHS(idMatkul: Int, nimMHS: String, namaMHS: String) {
        if (!nimMHS.isNullOrEmpty() && !namaMHS.isNullOrEmpty()){
            // both not empty
            viewmodel.getMHSbyNimAndName(idMatkul, nimMHS, namaMHS).observe(this){
                setMHS(it)
            }

        }
        else if (nimMHS.isNullOrEmpty()){                    //nim empty, search by name
            viewmodel.getMHSbyName(idMatkul, namaMHS).observe(this){
                setMHS(it)
            }
        }
        else if (namaMHS.isNullOrEmpty()){                  //nama empty, search by nim
            viewmodel.getMHSbyNim(idMatkul, nimMHS).observe(this){
                setMHS(it)
            }
        }
        else{
            //both empty, default
            viewmodel.getMHSMatkul(idMatkul).observe(this){
                setMHS(it)
            }
        }
    }

    private fun setMHS(it: List<Mahasiswa>) {
        adapter = ListMahasiswaAdapter(it)
        binding.rvDetail.adapter = adapter
    }
}