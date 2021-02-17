package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PhotoDao {

    @Query("SELECT * FROM photo WHERE realEstateId = :realEstateId")
    LiveData<List<Photo>> getAllPhotos(long realEstateId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Photo photo);

    @Update
    int update(Photo photo);
}
