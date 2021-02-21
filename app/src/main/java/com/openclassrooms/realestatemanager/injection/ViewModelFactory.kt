package com.openclassrooms.realestatemanager.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.repository.RealEstateRepository
import com.openclassrooms.realestatemanager.ui.RealEstateAddViewModel
import com.openclassrooms.realestatemanager.viewmodel.RealEstateListViewModel

class ViewModelFactory(
        private val realEstateRepository: RealEstateRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RealEstateAddViewModel::class.java)) {
            return RealEstateAddViewModel(realEstateRepository) as T
        }

        throw IllegalArgumentException("Unknow ViewModel class")
    }
}