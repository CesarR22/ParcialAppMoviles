package com.cesarroque.parcial01moviles.ui.listprovincia.recyclerView

import androidx.recyclerview.widget.RecyclerView

import com.cesarroque.parcial01moviles.data.model.ProvinciaModel
import com.cesarroque.parcial01moviles.databinding.ProvinciasItemBinding


class ProvinciaRecyclerViewHolder(private val binding: ProvinciasItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(provincia: ProvinciaModel, clickListener: (ProvinciaModel) -> Unit) {
        binding.nameTextView.text = provincia.name
        binding.ubicationTextView.text = provincia.capital

        binding.museumItemCardView.setOnClickListener {
            clickListener(provincia)
        }
    }
}