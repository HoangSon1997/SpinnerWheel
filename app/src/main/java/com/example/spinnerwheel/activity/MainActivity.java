package com.example.spinnerwheel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.spinnerwheel.R;
import com.library.LuckyWheelView;
import com.library.model.LuckyItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LuckyWheelView mWheelView;
    ArrayList<LuckyItem> mItemList;
    Button mSpinButton;
    Button mChangeSpinButton;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        setData();
        initView();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Spin Wheel");
    }

    private void initView() {
        mWheelView = findViewById(R.id.luckyWheel);
        mWheelView.setData(mItemList);
        mWheelView.setRound(getRandomRound());
        mWheelView.setLuckyRoundItemSelectedListener((index) -> Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show());

        mSpinButton = findViewById(R.id.spin_button);
        mSpinButton.setOnClickListener(v -> play());

        mChangeSpinButton =findViewById(R.id.change_list_button);
        mChangeSpinButton.setOnClickListener(v -> launchSpinList());
    }

    private void launchSpinList() {
        Intent intent = new Intent(MainActivity.this, SpinListActivity.class);
        startActivity(intent);
    }

    private void setData() {
        mItemList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            LuckyItem item = new LuckyItem();
            item.topText = String.valueOf(i);
            item.secondaryText = "sec" + i;
            item.icon = R.drawable.suneo;
            mItemList.add(item);
        }
    }

    private int getRandomRound() {
        return new Random().nextInt(10);
    }

    private void play() {
        mWheelView.startLuckyWheelWithTargetIndex(getRandomIndex());
    }

    private int getRandomIndex() {
        int[] arr = new int[] {1,2,3,4};
        int random = new Random().nextInt(arr.length);
        return arr[random];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.edit_menu:
                launchEdit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void launchEdit() {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        startActivity(intent);
    }
}