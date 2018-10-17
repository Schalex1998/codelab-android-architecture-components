package com.example.android.sunshine.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {WeatherEntry.class}, version = 1)
public abstract class SunshineDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();

    private static final String DATABASE_NAME = "weather";
    private static final Object LOCK = new Object();
    private static volatile SunshineDatabase sInstance;

    public static SunshineDatabase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), SunshineDatabase.class, DATABASE_NAME).build();
            }
        }
        return sInstance;
    }
}