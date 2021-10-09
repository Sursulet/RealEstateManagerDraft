package com.openclassrooms.realestatemanager.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.openclassrooms.realestatemanager.databinding.FragmentRealEstateListBinding
import com.openclassrooms.realestatemanager.model.RealEstate

class RealEstateListFragment : Fragment(), RealEstateItemAdapter.OnItemClickListener {

    private val viewModel: RealEstateViewModel by viewModels()
    private val adapter: RealEstateItemAdapter = RealEstateItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider.of(this).get()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRealEstateListBinding.inflate(inflater, container, false)
        viewModel.getRealEstates().observe(viewLifecycleOwner, { realEstates -> adapter.submitList(realEstates)})
        initRecyclerview(binding)
        return binding.root
    }

    private fun initRecyclerview(binding: FragmentRealEstateListBinding) {
        binding.fragmentRealEstateListRecyclerview.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        binding.fragmentRealEstateListRecyclerview.setHasFixedSize(true)
        binding.fragmentRealEstateListRecyclerview.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        requireActivity().supportFragmentManager.beginTransaction().apply {  }
    }
}