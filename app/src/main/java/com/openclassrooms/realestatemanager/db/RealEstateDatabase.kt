package com.openclassrooms.realestatemanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.openclassrooms.realestatemanager.dao.RealEstateDao
import com.openclassrooms.realestatemanager.model.RealEstate

@Database(entities = [RealEstate::class], version = 1, exportSchema = false)
abstract class RealEstateDatabase: RoomDatabase() {

    abstract fun realEstateDao(): RealEstateDao

    companion object {


        @Volatile private var INSTANCE: RealEstateDatabase? = null

        fun getInstance(context: Context): RealEstateDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = buildDatabase(context)
                INSTANCE = instance
                instance
            }
        }

        private fun buildDatabase(context: Context): RealEstateDatabase {
            return Room.databaseBuilder(context, RealEstateDatabase::class.java, "realEstateDatabase")
                    .build()
        }
    }
}