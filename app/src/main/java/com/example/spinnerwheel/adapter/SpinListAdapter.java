package com.example.spinnerwheel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spinnerwheel.R;
import com.example.spinnerwheel.holder.SpinViewHolder;
import com.example.spinnerwheel.Wheel;
import com.example.spinnerwheel.listener.ClickListener;

import java.util.ArrayList;
import java.util.List;

public class SpinListAdapter extends RecyclerView.Adapter<SpinViewHolder> {

    Context mContext;
    List<Wheel> mWheelList;
    ClickListener mListener;

    public SpinListAdapter(Context context, List<Wheel> wheelList, ClickListener listener) {
        mContext = context;
        mWheelList = wheelList;
        mListener = listener;
    }

    @NonNull
    @Override
    public SpinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_spin_list, parent, false);
        return new SpinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpinViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.title.setText(mWheelList.get(position).title);
        holder.itemView.setOnClickListener(v -> mListener.onClick(index));
        holder.itemView.setOnLongClickListener(v -> {
            mListener.onLongClick(index);
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return mWheelList.size();
    }
}
