package com.openclassrooms.realestatemanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class RealEstate {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String type;
    private String price;
    private String surface;
    private String rooms;
    private String bathrooms;
    private String bedrooms;
    private String description;
    //private List<Photo> photos;
    private String address;
    private String vicinity;
    private boolean status;
    private long creationTimestamp;
    private long saleTimestamp;
    private String agent;

    public RealEstate(
            String type, String price, String surface,
            String rooms, String bathrooms, String bedrooms,
            String description,
            //List<Photo> photos,
            String address, String vicinity,
            boolean status, long creationTimestamp, long saleTimestamp,
            String agent
    ) {
        this.type = type;
        this.price = price;
        this.surface = surface;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.description = description;
        //this.photos = photos;
        this.address = address;
        this.vicinity = vicinity;
        this.status = status;
        this.creationTimestamp = creationTimestamp;
        this.saleTimestamp = saleTimestamp;
        this.agent = agent;
    }

    // --- GETTERS ---

    public long getId() { return id; }

    public String getType() { return type; }

    public String getPrice() { return price; }

    public String getSurface() { return surface; }

    public String getRooms() { return rooms; }

    public String getBathrooms() { return bathrooms; }

    public String getBedrooms() { return bedrooms; }

    public String getDescription() { return description; }

    //public List<Photo> getPhotos() { return photos; }

    public String getAddress() { return address; }

    public String getVicinity() { return vicinity; }

    public boolean isStatus() { return status; }

    public long getCreationTimestamp() { return creationTimestamp; }

    public long getSaleTimestamp() { return saleTimestamp; }

    public String getAgent() { return agent; }

    // --- SETTERS ---


    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //public void setPhotos(List<Photo> photos) { this.photos = photos; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public void setSaleTimestamp(long saleTimestamp) {
        this.saleTimestamp = saleTimestamp;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

}
