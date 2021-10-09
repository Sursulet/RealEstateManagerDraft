package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
        entity = RealEstate::class,
        parentColumns = ["id"],
        childColumns = ["realEstateId"])])
data class Photo (
        @PrimaryKey
        var id:Int,
        var title: String,
        var url:String,
        var realEstateId:Int
)