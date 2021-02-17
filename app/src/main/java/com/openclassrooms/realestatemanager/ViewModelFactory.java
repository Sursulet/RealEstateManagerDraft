package com.openclassrooms.realestatemanager;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory sFactory;

    private final RealEstateRepository realEstateRepository;
    private final PhotoRepository photoRepository;

    public ViewModelFactory(
            RealEstateRepository realEstateRepository,
            PhotoRepository photoRepository
    ) {
        this.realEstateRepository = realEstateRepository;
        this.photoRepository = photoRepository;
    }

    /*
    public static ViewModelFactory getInstance() {
        if (sFactory == null) {
            synchronized (ViewModelFactory.class) {
                if (sFactory == null) {
                    sFactory = new ViewModelFactory(
                            new RealEstateRepository()
                    );
                }
            }
        }

        return sFactory;
    }

     */

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SharedViewModel.class)){
            return (T) new SharedViewModel(realEstateRepository, photoRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
