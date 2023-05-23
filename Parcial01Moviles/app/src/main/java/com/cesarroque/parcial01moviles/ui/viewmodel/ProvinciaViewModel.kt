package com.cesarroque.parcial01moviles.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cesarroque.parcial01moviles.data.model.ProvinciaModel
import com.cesarroque.parcial01moviles.repositories.ProvinciaRepository
import com.cesarroque.parcial01moviles.ui.ProvinciaReviewerApplication

class ProvinciaViewModel(private val repository: ProvinciaRepository): ViewModel() {
    var name = MutableLiveData("")
    var capital = MutableLiveData("")
    var status = MutableLiveData("")

    fun getProvincias() = repository.getprovincias()
    fun addProvincias(provincia: ProvinciaModel) = repository.addprovincias(provincia)

    fun createProvincia() {
        if (validateData()) {
            status.value = SOMETHING_WRONG
            return
        }

        val provincia = ProvinciaModel(
            name.value!!,
            capital.value!!
        )

        addProvincias(provincia)
        clearData()

        status.value = PROVINCIA_CREATED
    }

    fun setSelectedProvincia(provincia: ProvinciaModel) {
        name.value = provincia.name
        capital.value = provincia.capital
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return true
            capital.value.isNullOrEmpty() -> return true
        }
        return false
    }

    fun clearData() {
        name.value = ""
        capital.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProvinciaReviewerApplication
                ProvinciaViewModel(app.provinciaRepository)
            }
        }
        const val PROVINCIA_CREATED = "PROVINCIA_CREATED"
        const val SOMETHING_WRONG = "SOMETHING_WRONG"
        const val INACTIVE = ""

    }
}