package com.example.customadapter2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by kkang
 * 깡샘의 안드로이드 프로그래밍 - 루비페이퍼
 * 위의 교제에 담겨져 있는 코드로 설명 및 활용 방법은 교제를 확인해 주세요.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=8;

    public DBHelper(Context context){
        super(context, "messageDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql="create table tb_message ("+
                "_id integer primary key autoincrement," +
                "name not null," +
                "message not null," +
                "date not null)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_message (name, message, date) values ('홍길동','안녕하세요 잘 지내시는지요?', '18/3/5')");
        db.execSQL("insert into tb_message (name, message, date) values ('도깨비','안녕 도깨비신부', '18/4/8')");
        db.execSQL("insert into tb_message (name, message, date) values ('서준희','밥 잘 사주는 예쁜 누나 봐야 되', '18/6/8')");
        db.execSQL("insert into tb_message (name, message, date) values ('이서진','나 짐꾼하기 싫은데...', '18/7/12')");
        db.execSQL("insert into tb_message (name, message, date) values ('이영자','몰루겠당 ~~', '18/7/30')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_message");
            onCreate(db);
        }
    }
}
