package com.kartikpatodi.sunshine.data.database;

import java.util.Date;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkinsert(WeatherEntry... weather);

    @Query("select * from weather where date = :date")
    WeatherEntry getWeatherByDate(Date date);
}
