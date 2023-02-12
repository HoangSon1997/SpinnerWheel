package com.example.spinnerwheel.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.spinnerwheel.dao.WheelDAO;
import com.example.spinnerwheel.model.Wheel;

@Database(entities = {Wheel.class}, version = 1)
public abstract class WheelDatabase extends RoomDatabase {
    public abstract WheelDAO wheelDAO();
}
