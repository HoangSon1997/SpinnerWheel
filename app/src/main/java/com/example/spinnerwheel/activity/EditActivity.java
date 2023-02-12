package com.example.spinnerwheel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.spinnerwheel.R;
import com.example.spinnerwheel.fragment.EditFragment;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, EditFragment.class, null)
                    .commit();
        }
    }
}