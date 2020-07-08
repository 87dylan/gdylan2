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

public class tempest extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempest);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tempest");

        searchviewcode();

        Button Button_duquesnewhistle=findViewById(R.id.Button_duquesnewhistle);
        Button Button_soonaftermidnight=findViewById(R.id.Button_soonaftermidnight);
        Button Button_narrowway=findViewById(R.id.Button_narrowway);
        Button Button_longandwastedyears=findViewById(R.id.Button_longandwastedyears);
        Button Button_payinblood=findViewById(R.id.Button_payinblood);
        Button Button_scarlettown=findViewById(R.id.Button_scarlettown);
        Button Button_earlyromanking=findViewById(R.id.Button_earlyromankings);
        Button Button_tinangel=findViewById(R.id.Button_tinangel);
        Button Button_tempestsong=findViewById(R.id.Button_tempestsong);
        Button Button_rollonjohn=findViewById(R.id.Button_rollonjohn);

        Button_duquesnewhistle.setOnClickListener(this);
        Button_soonaftermidnight.setOnClickListener(this);
        Button_narrowway.setOnClickListener(this);
        Button_longandwastedyears.setOnClickListener(this);
        Button_payinblood.setOnClickListener(this);
        Button_scarlettown.setOnClickListener(this);
        Button_earlyromanking.setOnClickListener(this);
        Button_tinangel.setOnClickListener(this);
        Button_tempestsong.setOnClickListener(this);
        Button_rollonjohn.setOnClickListener(this);


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
                            startActivity(new Intent(tempest.this, Class.forName(songnameclass)));
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

            case R.id.Button_duquesnewhistle:
            {
                Intent intent=new Intent(this,duquesnewhistle.class);
                startActivity(intent);
                break;
            }case R.id.Button_soonaftermidnight:
            {
                Intent intent=new Intent(this,soonaftermidnight.class);
                startActivity(intent);
                break;
            }case R.id.Button_narrowway:
            {
                Intent intent=new Intent(this,narrowway.class);
                startActivity(intent);
                break;
            }case R.id.Button_longandwastedyears:
            {
                Intent intent=new Intent(this,longandwastedyears.class);
                startActivity(intent);
                break;
            }case R.id.Button_payinblood:
            {
                Intent intent=new Intent(this,payinblood.class);
                startActivity(intent);
                break;
            }case R.id.Button_scarlettown:
            {
                Intent intent=new Intent(this,scarlettown.class);
                startActivity(intent);
                break;
            }case R.id.Button_earlyromankings:
            {
                Intent intent=new Intent(this,earlyromankings.class);
                startActivity(intent);
                break;
            }case R.id.Button_tinangel:
            {
                Intent intent=new Intent(this,tinangel.class);
                startActivity(intent);
                break;
            }case R.id.Button_tempestsong:
            {
                Intent intent=new Intent(this,tempestsong.class);
                startActivity(intent);
                break;
            }case R.id.Button_rollonjohn:
            {
                Intent intent=new Intent(this,rollonjohn.class);
                startActivity(intent);
                break;
            }
            default:
                break;




        }



    }
}