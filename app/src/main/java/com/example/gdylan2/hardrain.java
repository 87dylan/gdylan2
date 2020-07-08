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

public class hardrain extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardrain);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hardrain");

        searchviewcode();

        Button Button_maggiesfarm=findViewById(R.id.Button_maggiesfarm);
        Button Button_onetoomanymorn=findViewById(R.id.Button_onetoomanymorning);
        Button Button_stuckinsidemememphislive=findViewById(R.id.Button_stuckinmemphisblueslive);
        Button Button_ohsister=findViewById(R.id.Button_ohsister);
        Button Button_layladylay=findViewById(R.id.Button_layladylay);
        Button Button_shelterfromthestorm=findViewById(R.id.Button_shelterfromthestorm);
        Button Button_youareabiggirlnow=findViewById(R.id.Button_youareabiggirlnow);
        Button Button_ithrewitallaway=findViewById(R.id.Button_ithrewitallaway);
        Button Button_idiotwind=findViewById(R.id.Button_idiotwind);


        Button_maggiesfarm.setOnClickListener(this);
        Button_onetoomanymorn.setOnClickListener(this);
        Button_stuckinsidemememphislive.setOnClickListener(this);

        Button_ohsister.setOnClickListener(this);
        Button_layladylay.setOnClickListener(this);
        Button_shelterfromthestorm.setOnClickListener(this);
        Button_youareabiggirlnow.setOnClickListener(this);
        Button_ithrewitallaway.setOnClickListener(this);
        Button_idiotwind.setOnClickListener(this);





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
                            startActivity(new Intent(hardrain.this, Class.forName(songnameclass)));
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

            case R.id.Button_maggiesfarm:
                Intent intent=new Intent(this,maggiesfarm.class);
                startActivity(intent);
                break;
            case R.id.Button_onetoomanymorning:
                Intent intent2=new Intent(this,onetoomanymorning.class);
                startActivity(intent2);
                break;
            case R.id.Button_stuckinmemphisblueslive:
                Intent intent3=new Intent(this,stuckmemphishardrain.class);
                startActivity(intent3);
                break;
            case R.id.Button_ohsister:
                Intent intent4=new Intent(this,ohsister.class);
                startActivity(intent4);
                break;
            case R.id.Button_layladylay:
                Intent intent5=new Intent(this,layladylay.class);
                startActivity(intent5);
                break;
            case R.id.Button_shelterfromthestorm:
                Intent intent6=new Intent(this,shelterfromthestorm.class);
                startActivity(intent6);
                break;
            case R.id.Button_youareabiggirlnow:
                Intent intent7=new Intent(this,youareabigirlnow.class);
                startActivity(intent7);
                break;
            case R.id.Button_ithrewitallaway:
                Intent intent8=new Intent(this,ithrewitallaway.class);
                startActivity(intent8);
                break;
            case R.id.Button_idiotwind:
                Intent intent9=new Intent(this,idiotwind.class);
                startActivity(intent9);
                break;

            default:
                break;



        }
    }
}