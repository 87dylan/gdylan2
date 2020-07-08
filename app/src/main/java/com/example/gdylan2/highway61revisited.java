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

public class highway61revisited extends AppCompatActivity  implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highway61revisited);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Highway 61 revisited");

        searchviewcode();


        Button Button_likearollinstone=findViewById(R.id.Button_likearollingstone);
        Button Button_tombstoneblues=findViewById(R.id.Button_tombstoneblues);

        Button Button_ittakesalottolaugh=findViewById(R.id.Button_ittakesalottolaugh);

        Button Button_fromabuick6=findViewById(R.id.Button_fromabuick6);
        Button Button_balladofthinman=findViewById(R.id.Button_balladofathinman);
        Button Button_queenjane=findViewById(R.id.Button_queenjane);
        Button Button_highway61revisited=findViewById(R.id.Button_highway61revistedsong);
        Button Button_justliketomthumbblues=findViewById(R.id.Button_justliketomthumbblues);
        Button Button_desolationrow=findViewById(R.id.Button_desolationrow);


        Button_likearollinstone.setOnClickListener(this);
        Button_tombstoneblues.setOnClickListener(this);
        Button_ittakesalottolaugh.setOnClickListener(this);
        Button_fromabuick6.setOnClickListener(this);
        Button_balladofthinman.setOnClickListener(this);
        Button_queenjane.setOnClickListener(this);
        Button_highway61revisited.setOnClickListener(this);
        Button_justliketomthumbblues.setOnClickListener(this);
        Button_desolationrow.setOnClickListener(this);


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
                            startActivity(new Intent(highway61revisited.this, Class.forName(songnameclass)));
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

            case R.id.Button_likearollingstone:
                Intent intent=new Intent(this, likearollingstone.class);
                startActivity(intent);
                break;
            case R.id.Button_tombstoneblues:
                Intent intent2=new Intent(this, tombstoneblues.class);
                startActivity(intent2);
                break;
            case R.id.Button_ittakesalottolaugh:
                Intent intent3=new Intent(this, ittakesalottolaugh.class);
                startActivity(intent3);
                break;
            case R.id.Button_fromabuick6:
                Intent intent4=new Intent(this, fromabuick6.class);
                startActivity(intent4);
                break;
            case R.id.Button_balladofathinman:
                Intent intent5=new Intent(this, balladofathinman.class);
                startActivity(intent5);
                break;
            case R.id.Button_queenjane:
                Intent intent6=new Intent(this, queenjaneapprox.class);
                startActivity(intent6);
                break;
            case R.id.Button_highway61revistedsong:
                Intent intent7=new Intent(this, highway61song.class);
                startActivity(intent7);
                break;
                case R.id.Button_justliketomthumbblues:
                Intent intent8=new Intent(this, justlketomthumbs.class);
                startActivity(intent8);
                break;
            case R.id.Button_desolationrow:
                Intent intent9=new Intent(this, desolationrow.class);
                startActivity(intent9);
                break;
            default:
                break;

        }

    }
}