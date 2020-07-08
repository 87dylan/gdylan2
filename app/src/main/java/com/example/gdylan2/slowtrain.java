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
import android.widget.Switch;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class slowtrain extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slowtrain);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Slow Train coming");

        searchviewcode();

        Button Button_gottaservesomebody=findViewById(R.id.Button_gottaservesomebody);
        Button Button_preciousangel=findViewById(R.id.Button_preciousangel);
        Button Button_ibeleiveinyou=findViewById(R.id.Button_ibelieveinyou);
        Button Button_slowtrainsong=findViewById(R.id.Button_slowtrainsong);
        Button Button_gonnachangemywayofthinking=findViewById(R.id.Button_gonnachangemywayofthinking);
        Button Button_gonnachangemywayvesion2=findViewById(R.id.Button_gonnachangemywayofthinkingalternate);
        Button Button_dorighttomebaby=findViewById(R.id.Button_dorighttomebaby);
        Button Button_whenyougonnawakeup=findViewById(R.id.Button_whenyougonnawakeup);
        Button Button_mangavenamestoalltheanimals=findViewById(R.id.Button_mangavenametoalltheanimals);
        Button Button_whenhereturns=findViewById(R.id.Button_whenhereturns);


        Button_gottaservesomebody.setOnClickListener(this);
        Button_preciousangel.setOnClickListener(this);
        Button_ibeleiveinyou.setOnClickListener(this);
        Button_slowtrainsong.setOnClickListener(this);
        Button_gonnachangemywayofthinking.setOnClickListener(this);
        Button_dorighttomebaby.setOnClickListener(this);
        Button_whenyougonnawakeup.setOnClickListener(this);
        Button_mangavenamestoalltheanimals.setOnClickListener(this);
        Button_whenhereturns.setOnClickListener(this);
        Button_gonnachangemywayvesion2.setOnClickListener(this);


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
                            startActivity(new Intent(slowtrain.this, Class.forName(songnameclass)));
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

            case R.id.Button_gottaservesomebody:
            {
                Intent intent=new Intent(this,gottaservesomebody.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_preciousangel:
            {
                Intent intent=new Intent(this,preciousangel.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_ibelieveinyou:
            {
                Intent intent=new Intent(this,ibelieveinyou.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_slowtrainsong:
            {
                Intent intent=new Intent(this,slowtrainsong.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_gonnachangemywayofthinking:
            {
                Intent intent=new Intent(this,gonnachangemywayofthinking.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_gonnachangemywayofthinkingalternate:
            {
                Intent intent=new Intent(this,gonchangemywayofthinkingalternate.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_dorighttomebaby:
            {
                Intent intent=new Intent(this,dorighttomebaby.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_whenyougonnawakeup:
            {
                Intent intent=new Intent(this,whenyougonnawakeup.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_mangavenametoalltheanimals:
            {
                Intent intent=new Intent(this,mangavenametoalltheanimal.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_whenhereturns:
            {
                Intent intent=new Intent(this,whenhereturns.class);
                startActivity(intent);
                break;

            }
            default:
                break;









        }












    }
}

