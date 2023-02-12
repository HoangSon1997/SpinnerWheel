package com.example.spinnerwheel.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.spinnerwheel.model.WheelItem;

import java.util.List;

@Dao
public interface WheelItemDAO {

    @Query("SELECT * FROM wheelitem WHERE wheelId = (:wheelId)")
    List<WheelItem> getItemsFromWheel(int wheelId);

    @Insert
    void insertWheelItem(WheelItem item);

    @Delete
    void deleteWheelItem(WheelItem item);
}
