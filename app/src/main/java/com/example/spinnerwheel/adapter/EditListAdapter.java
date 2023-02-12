package com.example.spinnerwheel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spinnerwheel.R;
import com.example.spinnerwheel.holder.ItemViewHolder;
import com.example.spinnerwheel.model.WheelItem;
import com.example.spinnerwheel.utils.StringUtils;

import java.util.List;

public class EditListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context mContext;
    private List<WheelItem> mWheelItemList;

    public EditListAdapter(Context mContext, List<WheelItem> mWheelItemList) {
        this.mContext = mContext;
        this.mWheelItemList = mWheelItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_edit, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        String text = mWheelItemList.get(position).text;
        holder.title.setText(StringUtils.isEmpty(text) ? "No name" : text);
        holder.color.setBackground(mContext.getDrawable(mWheelItemList.get(position).color));
    }

    @Override
    public int getItemCount() {
        return mWheelItemList.size();
    }
}
