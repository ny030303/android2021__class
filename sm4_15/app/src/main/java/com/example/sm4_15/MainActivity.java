package com.example.sm4_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Toast.makeText(this, "토스트", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.button2) {
            new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                    .setMessage("정말종료하시겠습니까?")
                    .setPositiveButton("아니오", null)
                    .setNeutralButton("예", null).show();
        } else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://y-y.hs.kr"));
            startActivity(intent);
        } else if (v.getId() == R.id.button4) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }
}