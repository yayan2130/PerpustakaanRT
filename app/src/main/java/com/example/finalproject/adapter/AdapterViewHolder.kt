package com.example.finalproject.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R

class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageview: ImageView = itemView.findViewById(R.id.image_buku)
    var namabuku : TextView = itemView.findViewById(R.id.nama_buku)
//    var sinopsisbuku : TextView = itemView.findViewById(R.id.sinopsis)
}