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

public class infedels extends AppCompatActivity implements View.OnClickListener{

    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infedels);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Infedels");

        searchviewcode();

        Button Button_jokerman=findViewById(R.id.Button_jokerman);
        Button Button_sweetheartlikeyou=findViewById(R.id.Button_sweetheartlikeyou);
        Button Button_neighborhoodbully=findViewById(R.id.Button_neighborhoodbully);
        Button Button_licensetokill=findViewById(R.id.Button_licensetokill);
        Button Button_manofpeace=findViewById(R.id.Button_manofpeace);
        Button Button_unionsundown=findViewById(R.id.Button_unionsundown);
        Button Button_iandi=findViewById(R.id.Button_iandi);
        Button Button_dontfallapartonme=findViewById(R.id.Button_dontfallapartonme);





        Button_jokerman.setOnClickListener(this);
        Button_sweetheartlikeyou.setOnClickListener(this);
        Button_neighborhoodbully.setOnClickListener(this);
        Button_licensetokill.setOnClickListener(this);
        Button_manofpeace.setOnClickListener(this);
        Button_unionsundown.setOnClickListener(this);
        Button_iandi.setOnClickListener(this);
        Button_dontfallapartonme.setOnClickListener(this);





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
                            startActivity(new Intent(infedels.this, Class.forName(songnameclass)));
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

            case R.id.Button_jokerman: {


                Intent intent = new Intent(this,jokerman.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_sweetheartlikeyou: {


                Intent intent = new Intent(this,sweetheartlikeyou.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_neighborhoodbully: {


                Intent intent = new Intent(this,neighborhoodbully.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_licensetokill: {


                Intent intent = new Intent(this,licensetokill.class);
                startActivity(intent);
                break;
            }

            case R.id.Button_manofpeace: {


                Intent intent = new Intent(this,manofpeace.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_unionsundown: {


                Intent intent = new Intent(this,unionsundown.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_iandi: {


                Intent intent = new Intent(this,iandi.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_dontfallapartonme: {
                Intent intent = new Intent(this,dontfallapartonme.class);
                startActivity(intent);
                break;

            }




            default:
                break;
        }
    }
}

