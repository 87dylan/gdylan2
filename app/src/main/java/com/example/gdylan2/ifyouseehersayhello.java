package com.example.gdylan2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class ifyouseehersayhello extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    databasehelper dbh=new databasehelper(this);
    CheckBox checkBoxfav;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ifyouseehersayhello);

        //copy from here




        TextView textView = findViewById(R.id.textView3);
        title=textView.getText().toString();
        checkBoxfav = findViewById(R.id.favcheck);
        favretrieve();
        checkBoxfav.setOnCheckedChangeListener(this);

    }


    public void AddData(String songname,String classname) {

        boolean insertData = dbh.addData(songname,classname);

        if (insertData) {
            Toast.makeText(this, "Lyrics Added To Favourite", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }

    }
    public void DeleteData(String songname){

        Integer rowseffected=dbh.deleteData(songname);
        if(rowseffected!=0){
            Toast.makeText(this, "Song Removed From Favourite List", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();

        }


    }


    public void favretrieve() {

        Cursor objcursor = dbh.getListContents();

        if (objcursor.getCount() == 0) {
            Toast.makeText(this, "Click Heart To Add To Favourite!", Toast.LENGTH_LONG).show();
        } else {
            while (objcursor.moveToNext()) {
                if (objcursor.getString(1).equals(title)) {
                    checkBoxfav.setChecked(true);

                }

            }


        }
    }






    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String className = this.getClass().getName();
        if(isChecked){

            AddData(title, className);
        }
        else{
            DeleteData(title);

        }

    }

}








