package com.example.spinnerwheel.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WheelItem {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="text")
    public String text;
    @ColumnInfo(name="icon")
    public int icon;
    @ColumnInfo(name="secondaryText")
    public String secondaryText;
    @ColumnInfo(name="detail")
    public String detail;
    @ColumnInfo(name = "color")
    public int color;
    @ColumnInfo(name="wheelId")
    public int wheelId;

    public WheelItem() {

    }
}
