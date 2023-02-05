package com.example.spinnerwheel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WheelItem {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="text")
    String text;
    @ColumnInfo(name="icon")
    int icon;
    @ColumnInfo(name="secondaryText")
    String secondaryText;
    @ColumnInfo(name="detail")
    String detail;
    @ColumnInfo(name = "color")
    int color;
    @ColumnInfo(name="wheelId")
    int wheelId;

    WheelItem() {

    }
}
