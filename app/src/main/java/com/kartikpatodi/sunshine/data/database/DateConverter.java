package com.kartikpatodi.sunshine.data.database;

import java.util.Date;

import androidx.room.TypeConverter;

/**
 * {@link TypeConverter} for long to {@link Date}
 * <p>
 * This stores the date as a long in the database, but returns it as a {@link Date}
 */
class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}