package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PhotoRepository {

    private final PhotoDao photoDao;

    public PhotoRepository(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    public LiveData<List<Photo>> getPhotos(long realEstateId) { return this.photoDao.getAllPhotos(realEstateId); }

    public void createPhoto(Photo photo) { photoDao.insert(photo); }
    public void updatePhoto(Photo photo) { photoDao.update(photo); }
}
