package com.example.gdylan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class shotoflove extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shotoflove);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shot of love");

        searchviewcode();

        Button Button_shotoflovesong=findViewById(R.id.Button_shotoflovesong);
        Button Button_heartofmine=findViewById(R.id.Button_heartofmine);
        Button Button_propertyofjesus=findViewById(R.id.Button_propertyofjesus);
        Button Button_lennywater=findViewById(R.id.Button_lennybruce);
        Button Button_watereddownlove=findViewById(R.id.Button_watereddownlove);
        Button Button_thegroomstillwaiting=findViewById(R.id.Button_thegroomstillatalter);
        Button Button_deadmandeadman=findViewById(R.id.Button_deadmandeadman);
        Button Button_inthesummertime=findViewById(R.id.Button_inthesummertime);
        Button Button_trouble=findViewById(R.id.Button_trouble);
        Button Button_everygrainofsanf=findViewById(R.id.Button_everygrainofsand);


        Button_shotoflovesong.setOnClickListener(this);
        Button_heartofmine.setOnClickListener(this);
        Button_propertyofjesus.setOnClickListener(this);
        Button_lennywater.setOnClickListener(this);
        Button_watereddownlove.setOnClickListener(this);
        Button_thegroomstillwaiting.setOnClickListener(this);
        Button_deadmandeadman.setOnClickListener(this);
        Button_inthesummertime.setOnClickListener(this);
        Button_trouble.setOnClickListener(this);
        Button_everygrainofsanf.setOnClickListener(this);





    }
    public void searchviewcode(){


        searchView=(MaterialSearchView) findViewById(R.id.search_view);

        searchView.setSuggestions(getResources().getStringArray(R.array.querry_suggestion));

        searchView.setEllipsize(true);
        searchView.setHint("search by song name");
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Cursor data=dbh2.getListContents();

                while(data.moveToNext()){
                    if(data.getString(1).equals(query)) {
                        String songnameclass=data.getString(2);


                        try {
                            startActivity(new Intent(shotoflove.this, Class.forName(songnameclass)));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }


                    }

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem item=menu.findItem(R.id.searchlyrics);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.searchlyrics:
            {
                return  true;
            }
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        if(searchView.isSearchOpen()){
            searchView.closeSearch();
        }
        else{
            super.onBackPressed();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Button_shotoflovesong:
                Intent intent=new Intent(this, shotoflovesong.class);
                startActivity(intent);

                break;

            case R.id.Button_heartofmine:
                Intent intent1=new Intent(this, heartofmine.class);
                startActivity(intent1);

                break;
            case R.id.Button_propertyofjesus:
                Intent intent2=new Intent(this, propertyofjesus.class);
                startActivity(intent2);

                break;
            case R.id.Button_lennybruce:
                Intent intent3=new Intent(this, lennybruce.class);
                startActivity(intent3);

                break;
            case R.id.Button_watereddownlove:
                Intent intent4=new Intent(this, watereddownlove.class);
                startActivity(intent4);

                break;
            case R.id.Button_thegroomstillatalter:
                Intent intent5=new Intent(this, thegroomstillwaiting.class);
                startActivity(intent5);

                break;
            case R.id.Button_deadmandeadman:
                Intent intent6=new Intent(this, deadman.class);
                startActivity(intent6);

                break;
            case R.id.Button_inthesummertime:
                Intent intent7=new Intent(this, inthesummertime.class);
                startActivity(intent7);

                break;
            case R.id.Button_trouble:
                Intent intent8=new Intent(this, trouble.class);
                startActivity(intent8);

                break;
            case R.id.Button_everygrainofsand:
                Intent intent9=new Intent(this, everygrainofsand.class);
                startActivity(intent9);

                break;




        }
    }
}