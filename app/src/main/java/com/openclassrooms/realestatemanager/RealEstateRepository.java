package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RealEstateRepository {

    private final RealEstateDao realEstateDao;

    public RealEstateRepository(RealEstateDao realEstateDao) {
        this.realEstateDao = realEstateDao;
    }

    public LiveData<List<RealEstate>> getAllRealEstate() { return this.realEstateDao.getAllRealEstate(); }
    public LiveData<RealEstate> getRealEstate(long realEstateId) { return this.realEstateDao.getRealEstate(realEstateId); }

    void insert(RealEstate realEstate) { realEstateDao.createRealEstate(realEstate); }
    void update(RealEstate realEstate) { realEstateDao.updateRealEstate(realEstate); }
}
