package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RealEstateDao {

    @Query("SELECT * FROM realestate ORDER BY id ASC")
    LiveData<List<RealEstate>> getAllRealEstate();

    @Query("SELECT * FROM realEstate WHERE id = :id")
    LiveData<RealEstate> getRealEstate(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createRealEstate(RealEstate realEstate);

    @Update
    void updateRealEstate(RealEstate realEstate);
}
