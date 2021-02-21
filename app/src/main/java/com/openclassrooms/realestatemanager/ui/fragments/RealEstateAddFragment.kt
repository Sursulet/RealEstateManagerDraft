package com.openclassrooms.realestatemanager.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.openclassrooms.realestatemanager.databinding.RealEstateAddFragmentBinding
import com.openclassrooms.realestatemanager.injection.Injection
import com.openclassrooms.realestatemanager.injection.ViewModelFactory
import com.openclassrooms.realestatemanager.model.RealEstate
import com.openclassrooms.realestatemanager.ui.RealEstateAddViewModel

class RealEstateAddFragment : Fragment() {

    private var _binding: RealEstateAddFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = RealEstateAddFragment()
    }

    private lateinit var viewModel: RealEstateAddViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = RealEstateAddFragmentBinding.inflate(inflater, container, false)
        val viewModelFactory: ViewModelFactory = Injection.provideViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory).get(RealEstateAddViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type: String = binding.fragmentAddType.editText?.text.toString().trim()
        val description: String = binding.fragmentAddDescription.toString().trim()

        binding.fragmentRealEstateAddBtn.setOnClickListener {
            confirmInput()
            //Toast.makeText(requireContext(), type ,Toast.LENGTH_LONG).show()
        }
    }

    private fun confirmInput() {
        if (!validateType()) return
        val input: String = "Type: " + binding.fragmentAddType.editText?.text.toString()

        Toast.makeText(requireContext(), input, Toast.LENGTH_LONG).show()
        val realEstate = RealEstate(0,input,"description")
        viewModel.add(realEstate)
    }

    private fun validateType(): Boolean {
        val typeInput: String = binding.fragmentAddType.editText?.text.toString().trim()

        return if (typeInput.isEmpty()) {
            binding.fragmentAddType.error = "Field can't be empty"
            false
        } else {
            binding.fragmentAddType.error = null
            //binding.fragmentAddType.isErrorEnabled = false
            true
        }
    }

}