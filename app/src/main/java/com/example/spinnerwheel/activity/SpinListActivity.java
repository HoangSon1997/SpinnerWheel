package com.example.spinnerwheel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.spinnerwheel.R;
import com.example.spinnerwheel.adapter.SpinListAdapter;
import com.example.spinnerwheel.dao.WheelDAO;
import com.example.spinnerwheel.database.WheelDatabase;
import com.example.spinnerwheel.listener.ClickListener;
import com.example.spinnerwheel.model.Wheel;

import java.util.ArrayList;
import java.util.List;

public class SpinListActivity extends AppCompatActivity implements ClickListener {

    private Toolbar mToolbar;
    RecyclerView mRecycleView;
    List<Wheel> wheelList = new ArrayList<>();
    SpinListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_list);
        initToolbar();
        setData();
        setRecycleView();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar_spin_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Spin List");
    }

    private void setData() {
        WheelDatabase wheelDB = Room.databaseBuilder(getApplicationContext(),
                WheelDatabase.class, "Wheel").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        WheelDAO wheelDAO = wheelDB.wheelDAO();
        //test
//        wheelDAO.insertWheel(new Wheel(mId,"Test RoomDB"));
//        mId++;
        wheelList = wheelDAO.getAllWheel();
    }

    private void setRecycleView() {
        mRecycleView = findViewById(R.id.spin_list_recycleview);
        mAdapter = new SpinListAdapter(getApplicationContext(), wheelList, this);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int index) {
        Toast.makeText(this, "click" + index, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(int index) {
        Toast.makeText(this, "long click" + index, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.spin_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_menu:
                launchAdd();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void launchAdd() {
        Intent intent = new Intent(SpinListActivity.this, EditActivity.class);
        startActivity(intent);
    }
}