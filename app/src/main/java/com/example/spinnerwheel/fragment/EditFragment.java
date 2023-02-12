package com.example.spinnerwheel.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spinnerwheel.R;
import com.example.spinnerwheel.adapter.EditListAdapter;
import com.example.spinnerwheel.dialog.EditItemDialog;
import com.example.spinnerwheel.model.WheelItem;

import java.util.ArrayList;
import java.util.List;

public class EditFragment extends Fragment implements EditItemDialog.SaveListener {
    private static final int[] DRAWBLE_COLORS = {R.drawable.circle_color_default_item, R.drawable.circle_color_green_item, R.drawable.circle_color_black_item
            , R.drawable.circle_color_pink_item, R.drawable.circle_color_blue_item, R.drawable.circle_color_red_item, R.drawable.circle_color_yellow_item};
    private EditText mEditText;
    private RecyclerView mRecycleView;
    private static List<WheelItem> mItemList = new ArrayList<>();
    private EditListAdapter mAdapter;
    private Button mAddItemBtn;

    public EditFragment() {
        super(R.layout.fragment_edit);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEditView(view);
        initAddBtn(view);
        initRecycleView(view);
    }

    private void initRecycleView(View view) {
        mRecycleView = view.findViewById(R.id.item_wheel_recycleview);

        mAdapter = new EditListAdapter(getContext(), mItemList);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void initEditView(View view) {
        mEditText = view.findViewById(R.id.title_edit_text);
        mEditText.setText(getContext().getResources().getString(R.string.wheel));
    }

    private void initAddBtn(View view) {
        mAddItemBtn = view.findViewById(R.id.add_item_button);
        mAddItemBtn.setOnClickListener(l -> showDialog());
    }

    private void showDialog() {
        EditItemDialog dialog = new EditItemDialog();
        dialog.setTargetFragment(this, 0);
        dialog.show(getActivity().getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void save(String title, int postionColor) {
        WheelItem item = new WheelItem();
        item.text = title;
        item.color = DRAWBLE_COLORS[postionColor];
        mItemList.add(item);
        mAdapter.notifyDataSetChanged();
    }
}