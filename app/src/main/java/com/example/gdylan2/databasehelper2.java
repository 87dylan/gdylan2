package com.example.gdylan2;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper2 extends SQLiteOpenHelper {

    private final Context fContext;

    public static final String DATABASE_NAME = "songlist2.db";
    public static final String TABLE_NAME = "songandclass_data";
    public static final String C0l1 = "ID";
    public static final String COL2 = "SONGNAME";
    public static final String COL3 = "SONGCLASSNAME";



    public databasehelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
        fContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(

        "CREATE TABLE IF NOT EXISTS songandclass_data " +
                        "(ID integer primary key, SONGNAME text,SONGCLASSNAME text)"
        );

        ContentValues Values = new ContentValues();
        Resources res = fContext.getResources();
        String[] songnamerecords = res.getStringArray(R.array.querry_suggestion);
        String[] songclassnamerecords = res.getStringArray(R.array.songclassnames);
        int sizeofentries = songnamerecords.length;

        for (int i = 0; i < sizeofentries; i++) {

            {
                Values.put(COL2, songnamerecords[i]);
                Values.put(COL3, songclassnamerecords[i]);
                db.insert(TABLE_NAME, null, Values);
            }


        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }


    public Cursor getListContents(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
