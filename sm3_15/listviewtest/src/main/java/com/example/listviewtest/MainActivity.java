package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new ListItem("icon", "홍길동", "잘지내시죠"));
        items.add(new ListItem("icon1", "강은진", "잘지내시죠~~"));
        items.add(new ListItem("icon2", "김가현", "안녕!!!"));
        items.add(new ListItem("icon", "이유진", "잘지내시죠"));
        items.add(new ListItem("icon1", "임채영", "잘지내시죠~~"));
        items.add(new ListItem("icon2", "정나영", "!!!!!"));
        items.add(new ListItem("icon", "조한슬", "잘지내시죠~~!~!"));
        items.add(new ListItem("icon1", "하늘새미", "잘지내시죠~~~~"));
        items.add(new ListItem("icon2", "한다원", "안녕~~"));

        MyAdapter myAdapter = new MyAdapter(items);
        listView.setAdapter(myAdapter);
    }
}