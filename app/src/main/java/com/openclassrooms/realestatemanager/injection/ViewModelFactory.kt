package com.openclassrooms.realestatemanager.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.repository.PhotoRepository
import com.openclassrooms.realestatemanager.repository.RealEstateRepository
import com.openclassrooms.realestatemanager.ui.edit.RealEstateAddViewModel

class ViewModelFactory(
        private val realEstateRepository: RealEstateRepository,
        private val photoRepository: PhotoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RealEstateAddViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RealEstateAddViewModel(realEstateRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}