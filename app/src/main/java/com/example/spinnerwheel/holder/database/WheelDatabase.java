package com.example.spinnerwheel.holder.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.spinnerwheel.Wheel;
import com.example.spinnerwheel.dao.WheelDAO;

@Database(entities = {Wheel.class}, version = 1)
public abstract class WheelDatabase extends RoomDatabase {
    public abstract WheelDAO wheelDAO();
}
