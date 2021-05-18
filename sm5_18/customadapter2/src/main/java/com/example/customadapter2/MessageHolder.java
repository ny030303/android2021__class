package com.example.customadapter2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageHolder {
    public TextView nameView;
    public TextView messageView;
    public TextView dateView;

    public MessageHolder(View root) {
        nameView = root.findViewById(R.id.item_name);
        messageView = root.findViewById(R.id.item_message);
        dateView =  root.findViewById(R.id.item_date);
    }

}
