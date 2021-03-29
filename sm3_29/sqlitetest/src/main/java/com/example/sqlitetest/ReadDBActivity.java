package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {

    TextView titleView, contextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_d_b);

        titleView = findViewById(R.id.title);
        contextView = findViewById(R.id.content);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select title, content from tb_memo order by _id desc limit 1", null);
        while(cursor.moveToNext()) {
            titleView.setText(cursor.getString(0));
            contextView.setText(cursor.getString(1));
        }
    }
}