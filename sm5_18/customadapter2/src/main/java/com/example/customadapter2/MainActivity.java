package com.example.customadapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.customadapter2.DBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.custom_listview);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db= helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_message", null);

        ArrayList<MessageVO> datas = new ArrayList<>();

        while (cursor.moveToNext()) {
            MessageVO vo = new MessageVO();
            vo.name = cursor.getString(1);
            vo.message = cursor.getString(2);
            vo.date = cursor.getString(3);
            datas.add(vo);
        }
        db.close();
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_item, datas);
        listView.setAdapter(adapter);
    }
}