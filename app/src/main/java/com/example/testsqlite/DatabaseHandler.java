package com.example.testsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QuanLyMayTinh";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create table Category";
            createTable += "(idCategory int not null primary key,";
            createTable += "nameCategory text NULL)";
        db.execSQL(createTable);
        createTable = "CREATE table Computer";
        createTable += "(idPC int not null primary key,";
        createTable += "namePC text null,";
        createTable += "idCategory int null)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "DROP TABLE IF EXISTS Computer";
            dropTable += "DROP TABLE IF EXISTS Category";
        db.execSQL(dropTable);

        onCreate(db);
    }
}
