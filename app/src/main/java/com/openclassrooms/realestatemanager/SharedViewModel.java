package com.openclassrooms.realestatemanager;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {

    private static final String TAG = SharedViewModel.class.getSimpleName();

    private final RealEstateRepository realEstateRepository;
    private final PhotoRepository photoRepository;

    @Nullable
    private LiveData<RealEstate> realEstateLiveData;

    private LiveData<List<RealEstate>> dataRealEstateList = new MutableLiveData<>();
    private MutableLiveData<List<RealEstate>> mutableRealEstateList = new MutableLiveData<>();
    private MutableLiveData<RealEstate> mutableRealEstate = new MutableLiveData<>();

    public SharedViewModel(
            RealEstateRepository realEstateRepository,
            PhotoRepository photoRepository
    ) {
        this.realEstateRepository = realEstateRepository;
        this.photoRepository = photoRepository;
    }

    public LiveData<RealEstate> getRealEstate(long realEstateId) { return realEstateLiveData; }
    public LiveData<List<Photo>> getPhotos(long realEstateId) { return photoRepository.getPhotos(realEstateId); }
    public void createPhoto(Photo photo) { photoRepository.createPhoto(photo); }
    public void updatePhoto(Photo photo) { photoRepository.updatePhoto(photo); }

    public LiveData<List<RealEstate>> getRealEstateList() {
        return dataRealEstateList;
    }

    public LiveData<List<MasterUiModel>> getMasterUiModelList() {
        return Transformations.map(dataRealEstateList, realEstateList -> {
            List<MasterUiModel> masterUiModelList = new ArrayList<>();
            for (RealEstate realEstate : realEstateList) {
                String id = String.valueOf(realEstate.getId());
                //String url = realEstate.getPhotos().get(0).getUrl();
                masterUiModelList.add(
                        new MasterUiModel(
                                id,
                                "url",
                                realEstate.getType(),
                                "",
                                realEstate.getPrice()));
            }

            return masterUiModelList;
        });
    }

    public LiveData<RealEstate> initDetailFragment() { return mutableRealEstate; }
    public void setRealEstate(int position) {
        RealEstate realEstate = dataRealEstateList.getValue().get(position);
        mutableRealEstate.postValue(realEstate);
    }

    public void addRealEstate(RealEstate realEstate) {
        realEstateRepository.insert(realEstate);
    }

}
