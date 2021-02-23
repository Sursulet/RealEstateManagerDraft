package com.openclassrooms.realestatemanager.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.realestatemanager.model.RealEstate
import com.openclassrooms.realestatemanager.repository.RealEstateRepository

class RealEstateAddViewModel(
        private val realEstateRepository: RealEstateRepository
) : ViewModel() {
    // TODO: Implement the ViewModel

    init {
        realEstateRepository.getRealEstates()
    }
    //public fun getAll(): LiveData<List<RealEstate>> { return realEstateRepository.getRealEstates()}
    public fun add(realEstate: RealEstate) { realEstateRepository.createRealEstate(realEstate) }
}