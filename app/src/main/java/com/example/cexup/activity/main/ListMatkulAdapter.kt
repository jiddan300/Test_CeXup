package com.example.cexup.activity.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cexup.activity.detail.DetailActivity
import com.example.cexup.database.MataKuliah
import com.example.cexup.databinding.ItemDataBinding

class ListMatkulAdapter (private val listMatkul:List<MataKuliah>) :RecyclerView.Adapter<ListMatkulAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nama.text = listMatkul[position].nama

        holder.itemView.setOnClickListener {
            val moveIntent  = Intent(holder.itemView.context, DetailActivity::class.java)
            moveIntent.putExtra("namaMatkul", listMatkul[position].nama)
            moveIntent.putExtra("idMatkul", listMatkul[position].idMatkul)
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    class MyViewHolder(binding: ItemDataBinding):RecyclerView.ViewHolder(binding.root) {
        val nama = binding.tvItemName
    }

    override fun getItemCount() = listMatkul.size
}