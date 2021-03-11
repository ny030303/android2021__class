package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("리스트뷰 테스트");
        ListView listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("java");
        arrayList.add("24시");
        arrayList.add("로스트");
        arrayList.add("jsp");
        arrayList.add("안드로이드");
        arrayList.add("탐정몽크");
        arrayList.add("빅뱅");
        arrayList.add("프렌즈");
        arrayList.add("덱스터");
        arrayList.add("빈센조");
        arrayList.add("test");
        arrayList.add("테이큰");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, arrayList.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }
}