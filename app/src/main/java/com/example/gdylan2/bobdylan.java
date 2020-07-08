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

public class bobdylan extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    databasehelper2 dbh2=new databasehelper2(this);

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bobdylan);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bob Dylan");

        searchviewcode();

        Button Button_youarenogood=findViewById(R.id.Button_youarenogood);
        Button Button_talkingnewyork=findViewById(R.id.Button_talkingnewyork);
        Button Button_inmytimeofdyin=findViewById(R.id.Button_inmytimeofdying);

        Button Button_manofconstantsorrow=findViewById(R.id.Button_manofconstantsorrow);
        Button Button_fixingtodie=findViewById(R.id.Button_fixingtodie);
        Button Button_prettypeggy=findViewById(R.id.Button_prettypeggy);
        Button Button_highway51=findViewById(R.id.Button_highway51);
        Button Button_gospelplow=findViewById(R.id.Button_gospelplow);
        Button Button_babyletmefollowu=findViewById(R.id.Button_babyletmefollowu);
        Button Button_houseofrisingsun=findViewById(R.id.Button_houseoftherisingsun);
        Button Button_freighttrainblues=findViewById(R.id.Button_freighttrainblues);
        Button Button_songtowoody=findViewById(R.id.Button_songtowoody);
        Button Button_seethatmygrave=findViewById(R.id.Button_seethatmygraveiskeptclean);

        Button_youarenogood.setOnClickListener(this);
        Button_talkingnewyork.setOnClickListener(this);
        Button_inmytimeofdyin.setOnClickListener(this);
        Button_manofconstantsorrow.setOnClickListener(this);
        Button_fixingtodie.setOnClickListener(this);
        Button_prettypeggy.setOnClickListener(this);
        Button_highway51.setOnClickListener(this);
        Button_gospelplow.setOnClickListener(this);
        Button_babyletmefollowu.setOnClickListener(this);
        Button_houseofrisingsun.setOnClickListener(this);
        Button_freighttrainblues.setOnClickListener(this);
        Button_songtowoody.setOnClickListener(this);
        Button_seethatmygrave.setOnClickListener(this);




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
                            startActivity(new Intent(bobdylan.this, Class.forName(songnameclass)));
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

            case R.id.Button_youarenogood:
                Intent intent=new Intent(this,youarenogood.class);
                startActivity(intent);
                break;

            case R.id.Button_talkingnewyork:
                Intent intent2=new Intent(this,talkingnewyork.class);
                startActivity(intent2);
                break;

            case R.id.Button_inmytimeofdying:
                Intent intent3=new Intent(this,inmytimeofdying.class);
                startActivity(intent3);
                break;

            case R.id.Button_manofconstantsorrow:
                Intent intent4=new Intent(this,manofcontantsorrow.class);
                startActivity(intent4);
                break;


            case R.id.Button_fixingtodie:
                Intent intent5=new Intent(this,fixingtodie.class);
                startActivity(intent5);
                break;


            case R.id.Button_prettypeggy:
                Intent intent6=new Intent(this,prettypeggy.class);
                startActivity(intent6);
                break;


            case R.id.Button_highway51:
                Intent intent7=new Intent(this,highway51.class);
                startActivity(intent7);
                break;


            case R.id.Button_gospelplow:
                Intent intent8=new Intent(this,gospelplow.class);
                startActivity(intent8);
                break;


            case R.id.Button_babyletmefollowu:
                Intent intent9=new Intent(this,babyletmefollowyou.class);
                startActivity(intent9);
                break;



            case R.id.Button_houseoftherisingsun:
                Intent intent10=new Intent(this,houseofrisingsun.class);
                startActivity(intent10);
                break;


            case R.id.Button_freighttrainblues:
                Intent intent11=new Intent(this,freighttrainblues.class);
                startActivity(intent11);
                break;


            case R.id.Button_songtowoody:
                Intent intent12=new Intent(this,songtowoody.class);
                startActivity(intent12);
                break;


            case R.id.Button_seethatmygraveiskeptclean:
                Intent intent13=new Intent(this,seethatmygrave.class);
                startActivity(intent13);
                break;


            default:
                break;


        }






    }
}