package com.openclassrooms.realestatemanager.repository

import androidx.lifecycle.LiveData
import com.openclassrooms.realestatemanager.dao.PhotoDao
import com.openclassrooms.realestatemanager.model.Photo

class PhotoRepository {

    lateinit var photoDao: PhotoDao

    fun getPhotos(realEstateId:Int):LiveData<List<Photo>> { return this.photoDao.getPhotos(realEstateId) }
    suspend fun insertPhoto(photo: Photo) { photoDao.insertPhoto(photo) }
    suspend fun deletePhoto(photoId:Int) { photoDao.deletePhoto(photoId) }
    suspend fun updatePhoto(photo:Photo) { photoDao.updatePhoto(photo) }
}