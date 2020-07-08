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

public class newmorning extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmorning);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Morning");

        searchviewcode();

        Button Button_ifnotforyou=findViewById(R.id.Button_ifnotforyou);
        Button Button_dayofthelocust=findViewById(R.id.Button_dayofthelocusts);
        Button Button_timepassessslowly=findViewById(R.id.Button_timepassesslowly);
        Button Button_wenttoseethegypsy=findViewById(R.id.Button_wenttoseethegypsy);
        Button Button_winterlude=findViewById(R.id.Button_winterlude);
        Button Button_ifdogsrunfree=findViewById(R.id.Button_ifdogsrunfree);
        Button Button_newmorningsong=findViewById(R.id.Button_newmorningsong);
        Button Button_signonthewindow=findViewById(R.id.Button_signonthewind);
        Button Button_onemoreweekend=findViewById(R.id.Button_onemoreweekend);
        Button Button_themaninme=findViewById(R.id.Button_themaninme);
        Button Button_threeangels=findViewById(R.id.Button_threeangels);
        Button Button_fatherofnight=findViewById(R.id.Button_fatherofnight);





        Button_ifnotforyou.setOnClickListener(this);
        Button_dayofthelocust.setOnClickListener(this);
        Button_timepassessslowly.setOnClickListener(this);
        Button_wenttoseethegypsy.setOnClickListener(this);
        Button_winterlude.setOnClickListener(this);
        Button_ifdogsrunfree.setOnClickListener(this);
        Button_newmorningsong.setOnClickListener(this);
        Button_signonthewindow.setOnClickListener(this);
        Button_onemoreweekend.setOnClickListener(this);
        Button_themaninme.setOnClickListener(this);
        Button_threeangels.setOnClickListener(this);
        Button_fatherofnight.setOnClickListener(this);


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
                            startActivity(new Intent(newmorning.this, Class.forName(songnameclass)));
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

            case R.id.Button_ifnotforyou:
                Intent intent =new Intent(this, ifnotforyou.class);
                startActivity(intent);
                break;

            case R.id.Button_dayofthelocusts:
                Intent intent2 =new Intent(this, dayofthelocust.class);
                startActivity(intent2);
                break;
            case R.id.Button_timepassesslowly:
                Intent intent3 =new Intent(this, timepassesslowly.class);
                startActivity(intent3);
                break;
            case R.id.Button_wenttoseethegypsy:
                Intent intent4 =new Intent(this, wenttoseethegypsy.class);
                startActivity(intent4);
                break;
            case R.id.Button_winterlude:
                Intent intent5 =new Intent(this, winterlude.class);
                startActivity(intent5);
                break;
            case R.id.Button_ifdogsrunfree:
                Intent intent6 =new Intent(this, ifdogsrunfree.class);
                startActivity(intent6);
                break;
            case R.id.Button_newmorningsong:
                Intent intent7 =new Intent(this, newmorningsong.class);
                startActivity(intent7);
                break;
            case R.id.Button_signonthewind:
                Intent intent8 =new Intent(this, signonthewindow.class);
                startActivity(intent8);
                break;
            case R.id.Button_onemoreweekend:
                Intent intent9 =new Intent(this, onemoreweekend.class);
                startActivity(intent9);
                break;
            case R.id.Button_themaninme:
                Intent intent10 =new Intent(this, themaninme.class);
                startActivity(intent10);
                break;
            case R.id.Button_threeangels:
                Intent intent11 =new Intent(this, threeangels.class);
                startActivity(intent11);
                break;
            case R.id.Button_fatherofnight:
                Intent intent12 =new Intent(this, fatherofthenight.class);
                startActivity(intent12);
                break;



            default:
                break;
        }
    }
}

