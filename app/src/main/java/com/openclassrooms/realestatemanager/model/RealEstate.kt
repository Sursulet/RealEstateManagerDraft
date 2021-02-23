package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstate (

        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        var type:String?,
        val description:String?
)