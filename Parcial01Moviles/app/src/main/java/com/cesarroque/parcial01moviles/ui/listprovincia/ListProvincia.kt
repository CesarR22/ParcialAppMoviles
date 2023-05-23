package com.cesarroque.parcial01moviles.ui.listprovincia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesarroque.parcial01moviles.R
import com.cesarroque.parcial01moviles.data.model.ProvinciaModel
import com.cesarroque.parcial01moviles.databinding.FragmentListProvinciasBinding
import com.cesarroque.parcial01moviles.ui.listprovincia.recyclerView.ProvinciaRecyclerViewAdapter
import com.cesarroque.parcial01moviles.ui.viewmodel.ProvinciaViewModel

class ListProvincia : Fragment() {

    private val provinciaViewModel: ProvinciaViewModel by activityViewModels {
        ProvinciaViewModel.Factory
    }

    private lateinit var binding: FragmentListProvinciasBinding
    private lateinit var adapter: ProvinciaRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListProvinciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            provinciaViewModel.clearData()
            it.findNavController().navigate(R.id.action_listMuseum_to_addMuseum)
        }
    }

    private fun showSelectedItem(provincia: ProvinciaModel) {
        provinciaViewModel.setSelectedProvincia(provincia)
        findNavController().navigate(R.id.action_listMuseum_to_infoMuseum)
    }

    private fun displayMuseums() {
        adapter.setData(provinciaViewModel.getProvincias())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.reciclerViewMuseums.layoutManager = LinearLayoutManager(view.context)

        adapter = ProvinciaRecyclerViewAdapter { selectedMuseum ->
            showSelectedItem(selectedMuseum)
        }

        binding.reciclerViewMuseums.adapter = adapter
        displayMuseums()
    }
}