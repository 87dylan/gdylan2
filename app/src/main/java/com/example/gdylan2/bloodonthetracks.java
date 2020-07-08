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

public class bloodonthetracks extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodonthetracks);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Blood on the tracks");

        searchviewcode();


        Button Button_tangledupinblue=findViewById(R.id.Button_tangledupinblue);
        Button Button_simpletwistoffate=findViewById(R.id.Button_simpletwistoffate);
        Button Button_yourabiggirlnowblood=findViewById(R.id.Button_youareabiggirlnow_bloodontrack);
        Button Button_idiotwindblood=findViewById(R.id.Button_idiotwind_bloodontrack);
        Button Button_youaregonnamakemelonesome=findViewById(R.id.Button_yourgonnamakemelonesome);
        Button Button_meetmeinthemorning=findViewById(R.id.Button_meetmeinthemorning);
        Button Button_lilyrosemaryandthejack=findViewById(R.id.Button_rosemerryandthejackofhearts);
        Button Button_ifyouseehersayhello=findViewById(R.id.Button_ifyouseehersayhello);
        Button Button_shelterfromthestorm=findViewById(R.id.Button_shelterfromthestrom_bloodontrack);
        Button Button_bucketsofrain=findViewById(R.id.Button_bucketsofrain);

        Button_tangledupinblue.setOnClickListener(this);
        Button_simpletwistoffate.setOnClickListener(this);
        Button_youaregonnamakemelonesome.setOnClickListener(this);
        Button_meetmeinthemorning.setOnClickListener(this);
        Button_yourabiggirlnowblood.setOnClickListener(this);
        Button_idiotwindblood.setOnClickListener(this);
        Button_lilyrosemaryandthejack.setOnClickListener(this);
        Button_ifyouseehersayhello.setOnClickListener(this);
        Button_shelterfromthestorm.setOnClickListener(this);
        Button_bucketsofrain.setOnClickListener(this);



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
                            startActivity(new Intent(bloodonthetracks.this, Class.forName(songnameclass)));
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

            case R.id.Button_tangledupinblue:
            {
                Intent intent=new Intent(this,tangledupinblue.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_simpletwistoffate:
            {
                Intent intent=new Intent(this,simpletwistoffate.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_youareabiggirlnow_bloodontrack:
            {
                Intent intent=new Intent(this,youareabiggirlnow_bloodontracks.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_idiotwind_bloodontrack:
            {
                Intent intent=new Intent(this,idiotwind_bloodontracks.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_yourgonnamakemelonesome:
            {
                Intent intent=new Intent(this,youaregonnamakemelonesome.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_meetmeinthemorning:
            {
                Intent intent=new Intent(this,meetmeinthemorning.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_rosemerryandthejackofhearts:
            {
                Intent intent=new Intent(this,lilyrosemaryandthejackofhearts.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_ifyouseehersayhello:
            {
                Intent intent=new Intent(this,ifyouseehersayhello.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_shelterfromthestrom_bloodontrack:
            {
                Intent intent=new Intent(this,shelterfromthestorm_bloodontracks.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_bucketsofrain:
            {
                Intent intent=new Intent(this,bucketsofrain.class);
                startActivity(intent);
                break;
            }
            default:
                break;


        }
    }
}