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

public class streetlegal extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streetlegal);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Street legal");

        searchviewcode();

        Button Button_changingoftheguards=findViewById(R.id.Button_changingoftheguards);
        Button Button_newpony=findViewById(R.id.Button_newpony);
        Button Button_notimetothink=findViewById(R.id.Button_notimetothink);
        Button Button_babystopcrying=findViewById(R.id.Button_babystopcrying);
        Button Button_isyourloeinvain=findViewById(R.id.Button_isyourloveinvain);
        Button Button_senor=findViewById(R.id.Button_senor);
        Button Button_truelovetendstoforget=findViewById(R.id.Button_truelovetendstoforget);
        Button Button_webettertalkthisover=findViewById(R.id.Button_webettertalkthisover);
        Button Button_whereareyoutonight=findViewById(R.id.Button_whereareyoutonight);


        Button_changingoftheguards.setOnClickListener(this);
        Button_newpony.setOnClickListener(this);
        Button_notimetothink.setOnClickListener(this);
        Button_babystopcrying.setOnClickListener(this);
        Button_isyourloeinvain.setOnClickListener(this);
        Button_senor.setOnClickListener(this);
        Button_truelovetendstoforget.setOnClickListener(this);
        Button_webettertalkthisover.setOnClickListener(this);
        Button_whereareyoutonight.setOnClickListener(this);


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
                            startActivity(new Intent(streetlegal.this, Class.forName(songnameclass)));
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

        switch(v.getId()){

            case R.id.Button_changingoftheguards:
                {
                    Intent intent = new Intent(this, changingotheguard.class);
                     startActivity(intent);
                     break;

                }
            case R.id.Button_newpony:
            {
                Intent intent = new Intent(this, newpony.class);
                startActivity(intent);
                break;

            } case R.id.Button_notimetothink:
            {
                Intent intent = new Intent(this, notimetothink.class);
                startActivity(intent);
                break;

            } case R.id.Button_babystopcrying:
            {
                Intent intent = new Intent(this, babystopcrying.class);
                startActivity(intent);
                break;

            } case R.id.Button_isyourloveinvain:
            {
                Intent intent = new Intent(this, isyourloveinvain.class);
                startActivity(intent);
                break;

            } case R.id.Button_senor:
            {
                Intent intent = new Intent(this, senor.class);
                startActivity(intent);
                break;

            } case R.id.Button_truelovetendstoforget:
            {
                Intent intent = new Intent(this, truelovetendstoforget.class);
                startActivity(intent);
                break;

            } case R.id.Button_webettertalkthisover:
            {
                Intent intent = new Intent(this, webettertalkthisover.class);
                startActivity(intent);
                break;

            } case R.id.Button_whereareyoutonight:
            {
                Intent intent = new Intent(this, whereareyoutonight.class);
                startActivity(intent);
                break;

            }












        }

    }
}