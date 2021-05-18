package com.example.customadapter2;

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

public class CustomAdapter extends ArrayAdapter<MessageVO> {
    Context context;
    int resId;
    ArrayList<MessageVO> datas;

    public CustomAdapter(@NonNull Context context, int resId, ArrayList<MessageVO> datas) {
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            MessageHolder holder = new MessageHolder(convertView);
            convertView.setTag(holder);
        }
        MessageHolder holder = (MessageHolder) convertView.getTag();

        TextView nameView = holder.nameView;
        TextView messageView  = holder.messageView;
        TextView dateView = holder.dateView;

        final MessageVO vo = datas.get(position);
        nameView.setText(vo.name);
        messageView.setText(vo.message);
        dateView.setText(vo.date);

//        if(vo.type.equals("doc")) {
//            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_doc, null));
//        } else if(vo.type.equals("file")) {
//            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_file, null));
//        } else if(vo.type.equals("img")) {
//            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_image, null));
//        }

        messageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, vo.name + "님의 메시지를 클릭함", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        return convertView;
    }
}
