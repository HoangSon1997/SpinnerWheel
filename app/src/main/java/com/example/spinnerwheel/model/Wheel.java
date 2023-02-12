package com.example.spinnerwheel.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Wheel {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    public Wheel(int id, String title) {
        this.title = title;
        this.id = id;
    }
}

