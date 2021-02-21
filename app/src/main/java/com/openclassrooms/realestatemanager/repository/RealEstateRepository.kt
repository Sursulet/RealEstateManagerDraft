package com.openclassrooms.realestatemanager.repository

import androidx.lifecycle.LiveData
import com.openclassrooms.realestatemanager.dao.RealEstateDao
import com.openclassrooms.realestatemanager.model.RealEstate

class RealEstateRepository(private val realEstateDao: RealEstateDao) {

    fun getRealEstates(): LiveData<List<RealEstate>> = realEstateDao.getAll()
    fun getRealEstate(id: Int) = realEstateDao.getRealEstate(id)

    fun createRealEstate(realEstate: RealEstate) { realEstateDao.insert(realEstate) }
}