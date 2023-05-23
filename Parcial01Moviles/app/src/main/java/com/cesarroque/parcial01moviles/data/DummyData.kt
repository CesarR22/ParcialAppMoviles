package com.cesarroque.parcial01moviles.data

import com.cesarroque.parcial01moviles.data.model.ProvinciaModel

val name = "Mexico"
val capital = "DF"

val name2 = "El Salvador"
val capital2 = "San Salvador"

val provincias = mutableListOf(
    ProvinciaModel(name, capital),
    ProvinciaModel(name2, capital2)
)