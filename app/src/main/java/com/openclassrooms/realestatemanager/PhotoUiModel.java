package com.openclassrooms.realestatemanager;

import androidx.annotation.Nullable;

public class PhotoUiModel {

    String id;
    String photo;
    String title;

    public PhotoUiModel(String id, String photo, String title) {
        this.id = id;
        this.photo = photo;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
