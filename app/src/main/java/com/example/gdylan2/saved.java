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

public class saved extends AppCompatActivity implements View.OnClickListener{
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Saved");

        searchviewcode();

        Button Button_asatisfiedmind=findViewById(R.id.Button_astisfiedman);
        Button Button_savedsong=findViewById(R.id.Button_savedsong);
        Button Button_covenantwomen=findViewById(R.id.Button_covenantman);
        Button Button_whatcanidoforyou=findViewById(R.id.Button_whatcanidoforyou);
        Button Button_solidrock=findViewById(R.id.Button_solidrock);
        Button Button_pressingon=findViewById(R.id.Button_perssingon);
        Button Button_inthegarden=findViewById(R.id.Button_inthegarden);
        Button Button_savinggrace=findViewById(R.id.Button_savinggrace);
        Button Button_areourady=findViewById(R.id.Button_areyouready);
      ;






        Button_asatisfiedmind.setOnClickListener(this);
        Button_savedsong.setOnClickListener(this);
        Button_covenantwomen.setOnClickListener(this);
        Button_whatcanidoforyou.setOnClickListener(this);
        Button_solidrock.setOnClickListener(this);
        Button_pressingon.setOnClickListener(this);
        Button_inthegarden.setOnClickListener(this);
        Button_savinggrace.setOnClickListener(this);
        Button_areourady.setOnClickListener(this);



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
                            startActivity(new Intent(saved.this, Class.forName(songnameclass)));
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

            case R.id.Button_astisfiedman:
                {

                Intent intent = new Intent(this, asatsisfiedmind.class);
                startActivity(intent);
                break;
                }
            case R.id.Button_savedsong:
            {

                Intent intent = new Intent(this, savedsong.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_covenantman:
            {

                Intent intent = new Intent(this, covenantwomen.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_whatcanidoforyou:
            {

                Intent intent = new Intent(this, whatcanidoforyou.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_solidrock:
            {

                Intent intent = new Intent(this, solidrock.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_perssingon:
            {

                Intent intent = new Intent(this, pressingon.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_inthegarden:
            {

                Intent intent = new Intent(this, inthegarden.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_savinggrace:
            {

                Intent intent = new Intent(this, savinggrace.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_areyouready:
            {

                Intent intent = new Intent(this, areyouready.class);
                startActivity(intent);
                break;
            }



            default:
                break;
        }
    }
}

