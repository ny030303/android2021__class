package com.example.sm4_15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    EditText first_num, second_num;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        first_num = findViewById(R.id.first_num);
        second_num = findViewById(R.id.second_num);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                int result1 = Integer.parseInt(first_num.getText().toString()) + Integer.parseInt(second_num.getText().toString());
                Toast.makeText(this, "결과는 "+ result1 + "입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                int result2 = Integer.parseInt(first_num.getText().toString()) - Integer.parseInt(second_num.getText().toString());
                Toast.makeText(this, "결과는 "+ result2 + "입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                int result3 = Integer.parseInt(first_num.getText().toString()) * Integer.parseInt(second_num.getText().toString());
                Toast.makeText(this, "결과는 "+ result3 + "입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                int result4 = Integer.parseInt(first_num.getText().toString()) / Integer.parseInt(second_num.getText().toString());
                Toast.makeText(this, "결과는 "+ result4 + "입니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}