package com.openclassrooms.realestatemanager;

import android.content.Context;

public class Injection {

    public static PhotoRepository providePhotoRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        return new PhotoRepository(appDatabase.photoDao());
    }

    public static RealEstateRepository provideRealEstateRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        return new RealEstateRepository(appDatabase.realEstateDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        RealEstateRepository dataSourceRealEstate = provideRealEstateRepository(context);
        PhotoRepository dataSourcePhoto = providePhotoRepository(context);
        return new ViewModelFactory(dataSourceRealEstate,dataSourcePhoto);
    }
}
