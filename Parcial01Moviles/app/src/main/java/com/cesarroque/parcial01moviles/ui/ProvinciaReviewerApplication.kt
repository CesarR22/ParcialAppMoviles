package com.cesarroque.parcial01moviles.ui

import android.app.Application
import com.cesarroque.parcial01moviles.data.provincias
import com.cesarroque.parcial01moviles.repositories.ProvinciaRepository


class ProvinciaReviewerApplication: Application() {
    val provinciaRepository: ProvinciaRepository by lazy {
        ProvinciaRepository(provincias)
    }
}
