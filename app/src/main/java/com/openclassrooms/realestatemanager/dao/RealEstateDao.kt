package com.openclassrooms.realestatemanager.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.openclassrooms.realestatemanager.model.RealEstate

@Dao
interface RealEstateDao {

    @Query("SELECT * FROM realestate")
    fun getAll(): LiveData<List<RealEstate>>

    @Query("SELECT * FROM realestate WHERE id = :id")
    fun getRealEstate(id: Int): LiveData<RealEstate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(realEstate: RealEstate)

    @Update
    fun update(realEstate: RealEstate)
}