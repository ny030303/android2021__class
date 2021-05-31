package com.example.webbookadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class WebBookAdapter extends ArrayAdapter<WebBookVO> {

    Context context;
    int resId;
    ArrayList<WebBookVO> datas;


    public WebBookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WebBookVO> obj) {
        super(context, resource);
        this.context = context;
        this.resId = resource;
        this.datas = obj;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            WebBookHolder holder = new WebBookHolder(convertView);
            convertView.setTag(holder);
        }
        WebBookHolder holder = (WebBookHolder) convertView.getTag();
        ImageView imageView = holder.imageView;
        TextView titleView = holder.titleView;
        TextView dateView = holder.dateView;
        TextView sizeView = holder.sizeView;
        TextView bookNumView = holder.bookNumView;

        final WebBookVO vo = datas.get(position);
        titleView.setText(vo.title);
        dateView.setText(vo.date);
        sizeView.setText(vo.size);
        bookNumView.setText(vo.book_num);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.hong, null));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, vo.book_num + "화 click", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return convertView;
    }
}
