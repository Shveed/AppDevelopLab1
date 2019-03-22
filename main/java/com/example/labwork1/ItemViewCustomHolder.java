package com.example.labwork1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemViewCustomHolder extends RecyclerView.ViewHolder {
    private TextView ItemText;

    public ItemViewCustomHolder(View itemView) {
        super(itemView);
        ItemText = (TextView) itemView.findViewById(R.id.txtViewTitle);
    }

    public void setItemText(String text) {
        ItemText.setText(text);
    }
}
