package com.openclassrooms.realestatemanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.openclassrooms.realestatemanager.model.RealEstate

@Dao
interface RealEstateDao {

    @Query("SELECT * FROM real_estate")
    fun getRealEstates(): LiveData<List<RealEstate>>

    @Query("SELECT * FROM real_estate WHERE id = :id")
    fun getRealEstate(id: Int): LiveData<RealEstate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRealEstate(realEstate: RealEstate)

    @Update
    suspend fun updateRealEstate(realEstate: RealEstate)
}