package com.example.webbookadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "webbookDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_webbook (" +
                "_id integer primary key autoincrement," +
                "title text," +
                "book_num integer," +
                " date text, " +
                "size text, " +
                "expire integer)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','30','2021-05-01','0.25M','0')");
        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','40','2021-05-01','0.25M','0')");
        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','50','2021-05-11','0.25M','0')");
        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','60','2021-05-12','0.25M','0')");
        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','70','2021-05-11','0.25M','0')");
        db.execSQL("insert into tb_webbook (title, book_num,date,size,expire) values ('김비서가 왜 그럴까?','80','2021-06-01','0.25M','0')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_webbook");
            onCreate(db);
        }

    }
}