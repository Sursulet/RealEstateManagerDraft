package com.openclassrooms.realestatemanager.injection

import android.content.Context
import com.openclassrooms.realestatemanager.db.RealEstateDatabase
import com.openclassrooms.realestatemanager.repository.PhotoRepository
import com.openclassrooms.realestatemanager.repository.RealEstateRepository

object Injection {

    private fun provideRealEstateRepository(context: Context): RealEstateRepository {
        val db: RealEstateDatabase = RealEstateDatabase.getInstance(context)
        return RealEstateRepository(db.realEstateDao())
    }

    private fun providePhotoRepository(context: Context): PhotoRepository {
        val db: RealEstateDatabase = RealEstateDatabase.getInstance(context)
        return PhotoRepository()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val realEstateRepository: RealEstateRepository = provideRealEstateRepository(context)
        val photoRepository: PhotoRepository = providePhotoRepository(context)
        return ViewModelFactory(realEstateRepository,photoRepository)
    }
}