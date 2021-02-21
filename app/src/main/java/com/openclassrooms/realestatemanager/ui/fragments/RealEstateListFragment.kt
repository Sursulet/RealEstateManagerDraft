package com.openclassrooms.realestatemanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.openclassrooms.realestatemanager.databinding.FragmentRealEstateListBinding
import com.openclassrooms.realestatemanager.ui.RealEstateListAdapter

class RealEstateListFragment : Fragment(), RealEstateListAdapter.OnItemClickListener {

    private var _binding: FragmentRealEstateListBinding? = null
    private val binding get() = _binding!!
    private val adapter: RealEstateListAdapter = RealEstateListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRealEstateListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerview()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerview() {
        binding.fragmentRealEstateListRecyclerview.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        binding.fragmentRealEstateListRecyclerview.setHasFixedSize(true)
        binding.fragmentRealEstateListRecyclerview.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        requireActivity().supportFragmentManager.beginTransaction().apply {  }
    }
}