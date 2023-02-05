package com.example.spinnerwheel.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.spinnerwheel.Wheel;

import java.util.List;

@Dao
public interface WheelDAO {
    @Query("SELECT * FROM wheel")
    List<Wheel> getAllWheel();

    @Query("SELECT * FROM wheel WHERE id = (:id)")
    List<Wheel> getWheelById(int id);

    @Insert
    void insertWheel(Wheel wheel);

    @Delete
    void delete(Wheel wheel);
}
