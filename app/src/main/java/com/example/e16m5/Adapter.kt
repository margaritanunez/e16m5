package com.example.e16m5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.e16m5.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    var paises= mutableListOf<Pais>()
    var callBack : PaisCallBack ? = null

    fun setPaisCallBack(c: PaisCallBack){
        this.callBack = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = paises[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return  paises.size
    }

    fun setData (paisesLatam: List<Pais>){
        this.paises = paisesLatam.toMutableList()

    }

    inner class ViewHolder (val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pais) {
            binding.paistxt.text=item.nombre
            binding.banderaimgv.load(item.imgUrl)
            binding.cv.setOnClickListener(View.OnClickListener {
                val texto = "Pais: ${item.nombre} posee una población de: ${item.poblacion}"
                callBack?.showCountry(texto)
            })
        }

    }

    interface PaisCallBack{
        fun showCountry(s: String)

    }
}