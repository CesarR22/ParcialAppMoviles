package com.cesarroque.parcial01moviles.ui.addProvincia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cesarroque.parcial01moviles.databinding.FragmentAddProvinciaBinding
import com.cesarroque.parcial01moviles.ui.viewmodel.ProvinciaViewModel

class AddProvincia : Fragment() {

    private val provinciaViewModel: ProvinciaViewModel by activityViewModels {
        ProvinciaViewModel.Factory
    }

    private lateinit var binding: FragmentAddProvinciaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProvinciaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = provinciaViewModel
    }

    private fun observeStatus() {
        provinciaViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(ProvinciaViewModel.SOMETHING_WRONG) -> {
                    Log.d("CRASH", status)
                    provinciaViewModel.clearStatus()
                }
                status.equals(ProvinciaViewModel.PROVINCIA_CREATED) -> {
                    Log.d("CREATED", status)
                    Log.d("CREATED2", provinciaViewModel.getProvincias().toString())

                    provinciaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}