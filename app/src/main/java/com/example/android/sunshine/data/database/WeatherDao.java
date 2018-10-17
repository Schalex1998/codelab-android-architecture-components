package com.example.android.sunshine.data.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;


@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weatherEntries);

    @Query("SELECT * from weather WHERE date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("SELECT COUNT(id) from weather WHERE date >= :date")
    int countAllFutureWeather(Date date);

    @Query("DELETE from weather WHERE date < :date")
    void deleteOldData(Date date);

    @Query("SELECT id, weatherIconId, date, min, max from weather WHERE date >= :date ORDER BY date ASC")
    LiveData<List<ListWeatherEntry>> getWeathersAfterDate(Date date);
}
