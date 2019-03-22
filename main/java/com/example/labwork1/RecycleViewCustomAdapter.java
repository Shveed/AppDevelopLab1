package com.example.labwork1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RecycleViewCustomAdapter extends RecyclerView.Adapter<ItemViewCustomHolder> {
    private LayoutInflater LInflater;
    public int kol;

    public RecycleViewCustomAdapter(Context context, int count) {
        LInflater = LayoutInflater.from(context);
        kol = count;
    }

    @Override
    public ItemViewCustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewCustomHolder(LInflater.inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewCustomHolder holder, int position) {
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.WHITE);
        } else {
            holder.itemView.setBackgroundColor(Color.GRAY);
        }
        holder.setItemText(WriteNumbers.digitsToText(1000000 - position));
    }

    @Override
    public int getItemCount() {
        return kol;
    }
}
