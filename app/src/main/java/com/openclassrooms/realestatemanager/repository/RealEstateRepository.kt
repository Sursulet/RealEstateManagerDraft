package com.openclassrooms.realestatemanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.openclassrooms.realestatemanager.dao.RealEstateDao
import com.openclassrooms.realestatemanager.model.RealEstate

class RealEstateRepository(private val realEstateDao: RealEstateDao) {

    private val realEstates = mutableListOf<RealEstate>()

    private val observableRealEstates = MutableLiveData<List<RealEstate>>(realEstates)

    fun getAllRealEstates(): LiveData<List<RealEstate>> = realEstateDao.getRealEstates()

    fun getRealEstate(id: Int) = realEstateDao.getRealEstate(id)

    suspend fun insertRealEstate(realEstate: RealEstate) { realEstateDao.insertRealEstate(realEstate) }

    suspend fun updateRealEstate(realEstate: RealEstate) { realEstateDao.updateRealEstate(realEstate) }

}