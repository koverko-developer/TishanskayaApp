package com.example.mobiapp.tishanskayaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mobi app on 09.09.2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "app";
    public static final String TABLE_COMPANY = "list";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String KEY_ID = "_id";
    public static final String KEY_DATE = "_date";
    public static final String KEY_TIME = "_time";
    public static final String KEY_TEXT = "_text";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_COMPANY + "(" + KEY_ID
                + " integer primary key," + KEY_DATE + " text,"+
                KEY_TIME + " text,"
                + KEY_TEXT + " text"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_COMPANY);
        onCreate(db);
    }




}
