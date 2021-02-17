package com.openclassrooms.realestatemanager;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = RealEstate.class,
        parentColumns = "id",
        childColumns = "realEstateId"))
public class Photo {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String url;
    private long realEstateId;

    public Photo(String name, String url, long realEstateId) {
        this.name = name;
        this.url = url;
        this.realEstateId = realEstateId;
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public long getRealEstateId() {
        return realEstateId;
    }

    public void setId(long id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRealEstateId(long realEstateId) {
        this.realEstateId = realEstateId;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        return super.equals(o);
    }
}
