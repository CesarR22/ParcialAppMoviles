package com.cesarroque.parcial01moviles.ui.informationprovincia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.cesarroque.parcial01moviles.databinding.FragmentInfoProvinciasBinding
import com.cesarroque.parcial01moviles.ui.viewmodel.ProvinciaViewModel

class InfoProvincia : Fragment() {

    private val provinciaViewModel: ProvinciaViewModel by activityViewModels {
        ProvinciaViewModel.Factory
    }

    private lateinit var binding: FragmentInfoProvinciasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoProvinciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = provinciaViewModel
    }

}