package com.example.webbookadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WebBookHolder {

    public ImageView imageView;
    public TextView titleView;
    public TextView dateView;
    public TextView sizeView;
    public TextView bookNumView;

    public WebBookHolder(View root) {
        imageView = (ImageView) root.findViewById(R.id.item_img);
        titleView = (TextView) root.findViewById(R.id.item_title);
        dateView = (TextView) root.findViewById(R.id.item_date);
        sizeView = (TextView) root.findViewById(R.id.item_size);
        bookNumView = (TextView) root.findViewById(R.id.item_book_num);
    }
}
