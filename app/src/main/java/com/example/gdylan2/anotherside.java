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

public class anotherside extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotherside);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Another side of bob dylan");
        searchviewcode();

        Button Button_alliwant=findViewById(R.id.Button_allireaddywant);
        Button Button_blackcrowblues=findViewById(R.id.Button_blackcrowblues);
        Button Button_spanishharlem=findViewById(R.id.Button_spanishharmlem);

        Button Button_chimesoffreedom=findViewById(R.id.Button_chimesoffreedom);
        Button Button_ishallbereleased=findViewById(R.id.Button_ishallbefree);
        Button Button_toromana=findViewById(R.id.Button_toramona);
        Button Button_motorpsycho=findViewById(R.id.Button_motorpsycho);
        Button Button_myblackpages=findViewById(R.id.Button_myblackpages);
        Button Button_idontbeleieveyou=findViewById(R.id.Button_idontbelieveyou);
        Button Button_baladinD=findViewById(R.id.Button_baladinD);
        Button Button_itaintmebabe=findViewById(R.id.Button_itaintmebabe);


        Button_alliwant.setOnClickListener(this);
        Button_blackcrowblues.setOnClickListener(this);
        Button_spanishharlem.setOnClickListener(this);
        Button_chimesoffreedom.setOnClickListener(this);
        Button_ishallbereleased.setOnClickListener(this);
        Button_toromana.setOnClickListener(this);
        Button_motorpsycho.setOnClickListener(this);
        Button_myblackpages.setOnClickListener(this);
        Button_idontbeleieveyou.setOnClickListener(this);
        Button_baladinD.setOnClickListener(this);
        Button_itaintmebabe.setOnClickListener(this);






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
                            startActivity(new Intent(anotherside.this, Class.forName(songnameclass)));
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

            case R.id.Button_allireaddywant:
            {
                Intent intent=new Intent(this,allireallywantodo.class);
                startActivity(intent);
                break;
            }
            case R.id.Button_blackcrowblues:
            {
                Intent intent2=new Intent(this,blackcrowblues.class);
                startActivity(intent2);
                break;
            }
            case R.id.Button_spanishharmlem:
            {
                Intent intent3=new Intent(this,spanishharlem.class);
                startActivity(intent3);
                break;
            }

            case R.id.Button_chimesoffreedom:
            {
                Intent intent4=new Intent(this,com.example.gdylan2.chimesoffreedom.class);
                startActivity(intent4);
                break;
            }
            case R.id.Button_ishallbefree:
            {
                Intent intent5=new Intent(this,ishallbefree.class);
                startActivity(intent5);
                break;
            }
            case R.id.Button_toramona:
            {
                Intent intent6=new Intent(this,toromana.class);
                startActivity(intent6);
                break;
            }
            case R.id.Button_motorpsycho:
            {
                Intent intent7=new Intent(this,motorpsycho.class);
                startActivity(intent7);
                break;
            }
            case R.id.Button_myblackpages:
            {
                Intent intent8=new Intent(this,myblackpages.class);
                startActivity(intent8);
                break;
            }
            case R.id.Button_idontbelieveyou:
            {
                Intent intent9=new Intent(this,idontbelieveyou.class);
                startActivity(intent9);
                break;
            }
            case R.id.Button_baladinD:
            {
                Intent intent10=new Intent(this,balladind.class);
                startActivity(intent10);
                break;
            }
            case R.id.Button_itaintmebabe:
            {
                Intent intent11=new Intent(this,itaintmebabe.class);
                startActivity(intent11);
                break;
            }


            default:
                break;


        }



    }
}