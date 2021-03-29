package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView titleView, contentView;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView = findViewById(R.id.title);
        contentView = findViewById(R.id.content);

        add = findViewById(R.id.add);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title = titleView.getText().toString();
        String context = contentView.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo(title, content) values(?,?)", new String[]{title, context});
        db.close();
        Toast.makeText(this, "메모 입력 완료", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ReadDBActivity.class);
        startActivity(intent);
    }
}