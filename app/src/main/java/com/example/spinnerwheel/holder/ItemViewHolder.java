package com.example.spinnerwheel.holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spinnerwheel.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView color;
    public TextView title;
    public Button editBtn;
    public Button deleteBtn;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        color = itemView.findViewById(R.id.color_item);
        title = itemView.findViewById(R.id.title_item);
        editBtn = itemView.findViewById(R.id.edit_item_button);
        deleteBtn = itemView.findViewById(R.id.delete_item_button);
    }
}
