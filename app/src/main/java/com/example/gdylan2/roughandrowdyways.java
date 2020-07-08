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

public class roughandrowdyways extends AppCompatActivity implements View.OnClickListener{

    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roughandrowdyways);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rough And Rowdy Days");

        searchviewcode();

        Button Button_icontainmultitudes=findViewById(R.id.Button_icontainmultitudes);
        Button Button_falseprophet=findViewById(R.id.Button_falseprophet);
        Button Button_myownversionofyou=findViewById(R.id.Button_myownversionofyou);
        Button Button_ihavemadeupmymind=findViewById(R.id.Button_ihvmadeupmymindtogive);
        Button Button_blackrider=findViewById(R.id.Button_blackrider);
        Button Button_goodbyejimmyreed=findViewById(R.id.Button_goodbyejimmyreed);
        Button Button_motherofmuses=findViewById(R.id.Button_motherofmuses);
        Button Button_crossingtherubicon=findViewById(R.id.Button_crossingtherubicon);
        Button Button_keywest=findViewById(R.id.Button_keywest);
        Button Button_murdermostfoul=findViewById(R.id.Button_murdermostfoul);






        Button_icontainmultitudes.setOnClickListener(this);
        Button_falseprophet.setOnClickListener(this);
        Button_myownversionofyou.setOnClickListener(this);
        Button_ihavemadeupmymind.setOnClickListener(this);
        Button_blackrider.setOnClickListener(this);
        Button_goodbyejimmyreed.setOnClickListener(this);
        Button_motherofmuses.setOnClickListener(this);
        Button_crossingtherubicon.setOnClickListener(this);
        Button_keywest.setOnClickListener(this);
        Button_murdermostfoul.setOnClickListener(this);



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
                            startActivity(new Intent(roughandrowdyways.this, Class.forName(songnameclass)));
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

            case R.id.Button_icontainmultitudes:{



                Intent intent =new Intent(this, icontainmultitudes.class);
                startActivity(intent);
                break;
            }

            case R.id.Button_falseprophet: {
                Intent intent = new Intent(this, falseprophet.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_myownversionofyou: {
                Intent intent = new Intent(this, myownversionofyou.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_ihvmadeupmymindtogive: {
                Intent intent = new Intent(this, ivemadeupmymind.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_blackrider: {
                Intent intent = new Intent(this, blackrider.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_goodbyejimmyreed: {
                Intent intent = new Intent(this, goodbyejimmyreed.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_motherofmuses: {
                Intent intent = new Intent(this, motherofmuses.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_crossingtherubicon: {
                Intent intent = new Intent(this, crossingtherubicon.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_keywest: {
                Intent intent = new Intent(this, keywest.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_murdermostfoul: {
                Intent intent = new Intent(this, mudermostfoul.class);
                startActivity(intent);
                break;
            }


            default:
                break;
        }
    }
}

