package com.openclassrooms.realestatemanager;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {RealEstate.class, Photo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract RealEstateDao realEstateDao();
    public abstract PhotoDao photoDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "RealEstateDatabase.db")
                            //.addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback prepopulateDatabase() {
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 1);
                contentValues.put("type", "Flat");
                contentValues.put("price", "23456789");
                contentValues.put("surface", "35");
                contentValues.put("rooms", "5");
                contentValues.put("bathrooms", "1");
                contentValues.put("bedrooms", "2");
                contentValues.put("description", "GO GO GO");
                contentValues.put("photos", "GO GO GO");
                contentValues.put("urlPicture", "https://oc-user.imgix.net/users/avatars/15175844164713_frame_523.jpg?auto=compress,format&q=80&h=100&dpr=2");
                contentValues.put("address", "8 rue des Peupliers, New York");
                contentValues.put("vicinity", "School");
                contentValues.put("status", true);
                contentValues.put("creationTimestamp", 2);
                contentValues.put("saleTimestamp", 2);
                contentValues.put("agent", "Peach");

                db.insert("RealEstate", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }
}
