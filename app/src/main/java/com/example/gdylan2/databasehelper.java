package com.example.gdylan2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class databasehelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "favsonglist2.db";
    public static final String TABLE_NAME = "favsongtable";
    public static final String C0l1 = "ID";
    public static final String COL2 = "SONGNAME";
    public static final String COL3 = "SONGCLASS";


    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE favsongtable " +
                        "(ID integer primary key, SONGNAME text,SONGCLASS text)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public boolean addData(String item1,String item2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3,item2);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Integer deleteData(String column){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"SONGNAME=?", new String[]{column});



    }

    public Cursor getListContents(){

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return data;
        }



}
