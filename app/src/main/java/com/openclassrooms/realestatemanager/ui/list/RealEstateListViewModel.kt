package com.openclassrooms.realestatemanager.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.realestatemanager.model.RealEstate
import com.openclassrooms.realestatemanager.repository.RealEstateRepository

class RealEstateListViewModel (
        realEstateRepository: RealEstateRepository
) : ViewModel() {
    val realEstates: LiveData<List<RealEstate>> = realEstateRepository.getAllRealEstates()
}