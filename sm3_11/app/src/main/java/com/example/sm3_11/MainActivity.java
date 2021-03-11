package com.example.sm3_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                ((TextView) findViewById(R.id.text)).setText("Search");
                return true;
            case R.id.item2:
                ((TextView) findViewById(R.id.text)).setText("Account");
                return true;
            case R.id.item3:
                ((TextView) findViewById(R.id.text)).setText("Setting");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}