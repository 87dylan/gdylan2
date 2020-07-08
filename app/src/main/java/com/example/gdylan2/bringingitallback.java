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

public class bringingitallback extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    databasehelper2 dbh2=new databasehelper2(this);

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bringingitallback);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bringing it all back");

        searchviewcode();
        Button Button_subterraneanhomesick=findViewById(R.id.Button_subterraneanhomesick);
        Button Button_shebelongtome=findViewById(R.id.Button_shebelongtome);

        Button Button_maggiesfarmbringit=findViewById(R.id.Button_maggiesfarmbringingit);
        Button Button_loveminuszero=findViewById(R.id.Button_loveminuzero);
        Button Button_outlawblues=findViewById(R.id.Button_outlawblue);
        Button Button_ontheroadagain=findViewById(R.id.Button_ontheroadagain);
        Button Button_bobdylansdream=findViewById(R.id.Button_bobdylans115);
        Button Button_mrtambourineman=findViewById(R.id.Button_mrtambourineman);
        Button Button_gatesofeden=findViewById(R.id.Button_gatesofeden);
        Button Button_itsalrightma=findViewById(R.id.Button_itsallrightma);
        Button Button_itsallovernowbabyblue=findViewById(R.id.Button_itsallovernowbabyblue);


        Button_subterraneanhomesick.setOnClickListener(this);
        Button_shebelongtome.setOnClickListener(this);
        Button_maggiesfarmbringit.setOnClickListener(this);
        Button_loveminuszero.setOnClickListener(this);
        Button_outlawblues.setOnClickListener(this);
        Button_ontheroadagain.setOnClickListener(this);
        Button_bobdylansdream.setOnClickListener(this);
        Button_mrtambourineman.setOnClickListener(this);
        Button_gatesofeden.setOnClickListener(this);
        Button_itsalrightma.setOnClickListener(this);
        Button_itsallovernowbabyblue.setOnClickListener(this);



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
                            startActivity(new Intent(bringingitallback.this, Class.forName(songnameclass)));
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

            case R.id.Button_subterraneanhomesick:
                Intent intent=new Intent(this, subtarraneanhomesick.class);
                startActivity(intent);
               break;

            case R.id.Button_shebelongtome:
                Intent intent2=new Intent(this, shebelongtome.class);
                startActivity(intent2);
                break;

            case R.id.Button_maggiesfarmbringingit:
                Intent intent3=new Intent(this, maggiesfarmbringingit.class);
                startActivity(intent3);
                break;
            case R.id.Button_loveminuzero:
                Intent intent4=new Intent(this, loveminuszero.class);
                startActivity(intent4);
                break;

            case R.id.Button_outlawblue:
                Intent intent5=new Intent(this, outlawblues.class);
                startActivity(intent5);
                break;
            case R.id.Button_ontheroadagain:
                Intent intent6=new Intent(this, ontheroadagain.class);
                startActivity(intent6);
                break;
            case R.id.Button_bobdylans115:
                Intent intent7=new Intent(this, bobdylansdream.class);
                startActivity(intent7);
                break;
            case R.id.Button_mrtambourineman:
                Intent intent8=new Intent(this, mrtambourineman.class);
                startActivity(intent8);
                break;
            case R.id.Button_gatesofeden:
                Intent intent9=new Intent(this, gatesofeden.class);
                startActivity(intent9);
                break;
            case R.id.Button_itsallrightma:
                Intent intent10=new Intent(this, itsallrightma.class);
                startActivity(intent10);
                break;
            case R.id.Button_itsallovernowbabyblue:
                Intent intent11=new Intent(this, itsallovernowbaby.class);
                startActivity(intent11);
                break;
            default:
                break;




        }

    }
}