package com.cesarroque.parcial01moviles.ui.listprovincia.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesarroque.parcial01moviles.data.model.ProvinciaModel
import com.cesarroque.parcial01moviles.databinding.ProvinciasItemBinding


class ProvinciaRecyclerViewAdapter(
    private val clickListener: (ProvinciaModel) -> Unit
) : RecyclerView.Adapter<ProvinciaRecyclerViewHolder>() {

    private val provincias = ArrayList<ProvinciaModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinciaRecyclerViewHolder {
        val binding = ProvinciasItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProvinciaRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return provincias.size
    }

    override fun onBindViewHolder(holder: ProvinciaRecyclerViewHolder, position: Int) {
        val provincia = provincias[position]
        holder.bind(provincia, clickListener)
    }

    fun setData(provinciaList: List<ProvinciaModel>) {
        provincias.clear()
        provincias.addAll(provinciaList)
    }

}