package com.example.cexup.activity.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cexup.database.Mahasiswa
import com.example.cexup.databinding.ItemDataBinding

class ListMahasiswaAdapter  (private val listMHS:List<Mahasiswa>) :
    RecyclerView.Adapter<ListMahasiswaAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nama.text = listMHS[position].nama
    }

    class MyViewHolder(binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        val nama = binding.tvItemName
    }

    override fun getItemCount() = listMHS.size
}