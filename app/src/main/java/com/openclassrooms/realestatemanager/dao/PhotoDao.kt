package com.openclassrooms.realestatemanager.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.openclassrooms.realestatemanager.model.Photo
import com.openclassrooms.realestatemanager.model.RealEstate

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo WHERE realEstateId = :realEstateId")
    fun getPhotos(realEstateId:Int):LiveData<List<Photo>>

    @Insert
    suspend fun insertPhoto(photo: Photo):Int

    @Update
    suspend fun updatePhoto(photo: Photo):Int

    @Query("DELETE FROM photo WHERE id = :photoId")
    suspend fun deletePhoto(photoId:Int)
}