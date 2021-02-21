package com.openclassrooms.realestatemanager.injection

import android.content.Context
import com.openclassrooms.realestatemanager.db.RealEstateDatabase
import com.openclassrooms.realestatemanager.repository.RealEstateRepository

object Injection {

    private fun provideRealEstateRepository(context: Context): RealEstateRepository {
        val db: RealEstateDatabase = RealEstateDatabase.getInstance(context)
        return RealEstateRepository(db.realEstateDao())
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val realEstateRepository: RealEstateRepository = provideRealEstateRepository(context)
        return ViewModelFactory(realEstateRepository)
    }
}