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

public class desire extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desire);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Desire");

        searchviewcode();

        Button Button_hurricane=findViewById(R.id.Button_hurricane);
        Button Button_isis=findViewById(R.id.Button_isis);
        Button Button_mozambique=findViewById(R.id.Button_mozambique);
        Button Button_onemorecupofcoffee=findViewById(R.id.Button_onemorecupofcoffee);
        Button Button_ohsisterdesire=findViewById(R.id.Button_ohsisterdesire);
        Button Button_joey=findViewById(R.id.Button_joey);
        Button Button_romanceindurango=findViewById(R.id.Button_romanceindurango);
        Button Button_blackdiamondbay=findViewById(R.id.Button_blackdiamondbay);
        Button Button_sara=findViewById(R.id.Button_sara);


        Button_hurricane.setOnClickListener(this);
        Button_isis.setOnClickListener(this);
        Button_mozambique.setOnClickListener(this);
        Button_onemorecupofcoffee.setOnClickListener(this);
        Button_ohsisterdesire.setOnClickListener(this);
        Button_joey.setOnClickListener(this);
        Button_romanceindurango.setOnClickListener(this);
        Button_blackdiamondbay.setOnClickListener(this);
        Button_sara.setOnClickListener(this);

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
                            startActivity(new Intent(desire.this, Class.forName(songnameclass)));
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


            case R.id.Button_hurricane:
            {
                Intent intent=new Intent(this,hurricane.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_isis:
            {
                Intent intent=new Intent(this,isis.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_mozambique:
            {
                Intent intent=new Intent(this,mozambique.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_onemorecupofcoffee:
            {
                Intent intent=new Intent(this,onemorecupofcoffee.class);
                startActivity(intent);
                break;
            }  case R.id.Button_ohsisterdesire:
            {
                Intent intent=new Intent(this,ohsisterdesire.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_joey:
            {
                Intent intent=new Intent(this,joey.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_romanceindurango:
            {
                Intent intent=new Intent(this,romanceindurango.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_blackdiamondbay:
            {
                Intent intent=new Intent(this,blackdiamond.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_sara:
            {
                Intent intent=new Intent(this,sara.class);
                startActivity(intent);
                break;
            }
            default:
                break;





        }

    }
}