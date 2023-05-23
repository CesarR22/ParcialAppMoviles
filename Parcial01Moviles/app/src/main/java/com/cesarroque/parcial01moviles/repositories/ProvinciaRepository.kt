package com.cesarroque.parcial01moviles.repositories

import com.cesarroque.parcial01moviles.data.model.ProvinciaModel


class ProvinciaRepository(private val provincias: MutableList<ProvinciaModel>) {
    fun getprovincias() = provincias
    fun addprovincias(provincia: ProvinciaModel) = provincias.add(0, provincia)

}