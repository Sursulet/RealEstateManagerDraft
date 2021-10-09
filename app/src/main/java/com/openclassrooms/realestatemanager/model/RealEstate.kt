package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "real_estate")
data class RealEstate (
        @PrimaryKey(autoGenerate = true) val id: Int? = null,
        var type:String,
        var description:String,
        var price:Float,
        var galleryDescription:String
)