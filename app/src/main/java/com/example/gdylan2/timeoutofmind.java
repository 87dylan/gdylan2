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

public class timeoutofmind extends AppCompatActivity implements View.OnClickListener{

    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeoutofmind);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Time Out Of Mind");

        searchviewcode();

        Button Button_lovesick=findViewById(R.id.Button_lovesick);
        Button Button_dirtroadblues=findViewById(R.id.Button_dirtroadblues);
        Button Button_standinginthedoorway=findViewById(R.id.Button_standinginthedoorway);
        Button Button_millionmiles=findViewById(R.id.Button_millionmiles);
        Button Button_tryingtogetotheaven=findViewById(R.id.Button_tryintogettoheaven);
        Button Button_tillifellinlovewithyou=findViewById(R.id.Button_tillifellinlovewithyou);
        Button Button_notdarkyet=findViewById(R.id.Button_notdarkyet);
        Button Button_coldironsbound=findViewById(R.id.Button_coldironbound);
        Button Button_makeyoufeelmylove=findViewById(R.id.Button_makeyoufeelmylove);
        Button Button_cantwait=findViewById(R.id.Button_cantwait);
        Button Button_highlands=findViewById(R.id.Button_highlands);





        Button_lovesick.setOnClickListener(this);
        Button_dirtroadblues.setOnClickListener(this);
        Button_standinginthedoorway.setOnClickListener(this);
        Button_millionmiles.setOnClickListener(this);
        Button_tryingtogetotheaven.setOnClickListener(this);
        Button_tillifellinlovewithyou.setOnClickListener(this);
        Button_notdarkyet.setOnClickListener(this);
        Button_coldironsbound.setOnClickListener(this);
        Button_makeyoufeelmylove.setOnClickListener(this);
        Button_cantwait.setOnClickListener(this);
        Button_highlands.setOnClickListener(this);


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
                            startActivity(new Intent(timeoutofmind.this, Class.forName(songnameclass)));
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
        switch (v.getId()) {

            case R.id.Button_lovesick: {
                Intent intent = new Intent(this, lovesick.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_standinginthedoorway: {
                Intent intent2 = new Intent(this, standinginthedoorway.class);
                startActivity(intent2);
                break;
            }
            case R.id.Button_millionmiles: {
                Intent intent3 = new Intent(this, millionmiles.class);
                startActivity(intent3);
                break;
            }
            case R.id.Button_tryintogettoheaven: {
                Intent intent4 = new Intent(this, tryintogettoheaven.class);
                startActivity(intent4);
                break;
            }
            case R.id.Button_tillifellinlovewithyou: {
                Intent intent5 = new Intent(this, tillifellinlovewithyou.class);
                startActivity(intent5);
                break;
            }
            case R.id.Button_notdarkyet: {
                Intent intent6 = new Intent(this, notdarkyet.class);
                startActivity(intent6);
                break;
            }
            case R.id.Button_coldironbound: {
                Intent intent7 = new Intent(this, coldironbounds.class);
                startActivity(intent7);
                break;
            }
            case R.id.Button_makeyoufeelmylove: {
                Intent intent8 = new Intent(this, makeyoufeelmylove.class);
                startActivity(intent8);
                break;
            }
            case R.id.Button_cantwait: {
                Intent intent9 = new Intent(this, cantwait.class);
                startActivity(intent9);
                break;
            }
            case R.id.Button_highlands: {
                Intent intent10 = new Intent(this, highlands.class);
                startActivity(intent10);
                break;
            }


            default:
                break;
        }
    }
}

