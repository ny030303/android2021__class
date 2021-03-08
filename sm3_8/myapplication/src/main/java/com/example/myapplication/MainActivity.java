package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn1) {
            showToast("toast");
        }
        else if (v == btn2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setPositiveButton("확인", null);
            builder.setNegativeButton("취소", null);

            alertDialog = builder.create();
            alertDialog.show();
        } else if (v == btn3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array, 0, null);
            builder.setPositiveButton("확인", null);
            builder.setNegativeButton("취소", null);

            alertDialog = builder.create();
            alertDialog.show();
        } else if (v == btn4) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setIcon(android.R.drawable.ic_dialog_alert);
            progressDialog.setTitle("기다리세요");

            progressDialog.setMessage("서버연동중입니다.");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        } else if (v == btn5) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    showToast(year+"/"+(month+1) + "/" + dayOfMonth);
                }
            }, year, month, day);
            dateDialog.show();
        } else if(v == btn6) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    showToast(hourOfDay + " : " + minute);
                }
            }, hour, minute, false);
            timeDialog.show();
        }

    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }
}