package com.example.finalproject.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Database.data
import com.example.finalproject.R

class adapter(private val itemFac: List<data>) : RecyclerView.Adapter<AdapterViewHolder>() {
    private lateinit var listener : OnItemClickListener

    fun setOnClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return AdapterViewHolder(layoutview)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        if (position < itemFac.size) {
            val item = itemFac[position]
            holder.imageview.setImageResource(item.gambarBuku)
            holder.namabuku.text = item.namaBuku
//            holder.sinopsisbuku.text = item.sinopsisBuku
            holder.itemView.setOnClickListener{
                listener.onClickedItem(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemFac.size
    }

    interface OnItemClickListener {
        fun onClickedItem(barang: data)
    }
}