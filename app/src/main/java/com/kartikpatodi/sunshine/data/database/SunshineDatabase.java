package com.kartikpatodi.sunshine.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class SunshineDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "weather";

    public abstract WeatherDao weatherDao();

    //For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile SunshineDatabase INSATNCE;

    public static SunshineDatabase getInstance(Context context){
        if(INSATNCE==null){
            synchronized (LOCK){
                if (INSATNCE == null) {
                    INSATNCE = Room.databaseBuilder(context.getApplicationContext(),
                            SunshineDatabase.class, SunshineDatabase.DATABASE_NAME).build();
                }
            }
        }
        return INSATNCE;
    }

}
