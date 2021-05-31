package com.example.webbookadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<WebBookVO> datas;
    WebBookAdapter adapter;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.webBookListView);
        datas = new ArrayList<WebBookVO>();
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();

        cursor = db.rawQuery("select _id, title, book_num,date,size,expire from tb_webbook", null);
        while (cursor.moveToNext()) {
            WebBookVO vo = new WebBookVO();
            vo.id = cursor.getInt(0);
            vo.title = cursor.getString(1);
            vo.book_num = cursor.getString(2);
            vo.date = cursor.getString(3);
            vo.size = cursor.getString(4);
            vo.expire = cursor.getString(5);
            datas.add(vo);
        }
        db.close();
        adapter = new WebBookAdapter(this, R.layout.main_list_item, datas);
        listView.setAdapter(adapter);
//        listView.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(this, MainActivity2.class);
//        startActivity(intent);
//    }

}