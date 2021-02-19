package com.openclassrooms.realestatemanager;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;

public class MasterUiModel {

    private final String id;
    private String photo;
    private String type;
    private String city;
    private String price;

    public MasterUiModel(String id, String photo, String type, String city, String price) {
        this.id = id;
        this.photo = photo;
        this.type = type;
        this.city = city;
        this.price = price;
    }

    // --- GETTERS ---


    public String getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getPrice() {
        return price;
    }

    // --- SETTERS ---

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public boolean equals(@Nullable Object o) {
        return super.equals(o);
    }
}
