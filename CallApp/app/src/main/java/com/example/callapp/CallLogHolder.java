package com.example.callapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallLogHolder {
    public ImageView personImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView dialerImageView;

    public CallLogHolder(View root) {
        personImageView = (ImageView) root.findViewById(R.id.item_person);
        nameView = (TextView) root.findViewById(R.id.item_name);
        dateView = (TextView) root.findViewById(R.id.item_date);
        dialerImageView = (ImageView) root.findViewById(R.id.item_dialer);
    }
}
