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

public class nashvilleskyline extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nashvilleskyline);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nashville skyline");

        searchviewcode();

        Button Button_girlfromnorthcountrynashville=findViewById(R.id.Button_girlfromthenorthcountrynashville);
        Button Button_nashvilleskylinerag=findViewById(R.id.Button_nashvilleskylinerag);
        Button Button_tobealonewithyou=findViewById(R.id.Button_tobealonewithyou);
        Button Button_peggydays=findViewById(R.id.Button_peggydays);
        Button Button_onemorenight=findViewById(R.id.Button_onemorenight);
        Button Button_tellmethatitisnttrue=findViewById(R.id.Button_tellmethatitisnttrue);
        Button Button_layladylaynashville=findViewById(R.id.Button_layladylaynashville);
        Button Button_countrypie=findViewById(R.id.Button_countrypie);
        Button Button_ithrewitallawaynashville=findViewById(R.id.Button_ithrewitallawaynashville);
        Button Button_tonightiwllbestaying=findViewById(R.id.Button_tonightillbestayingherewithyou);


        Button_girlfromnorthcountrynashville.setOnClickListener(this);
        Button_nashvilleskylinerag.setOnClickListener(this);
        Button_tobealonewithyou.setOnClickListener(this);
        Button_peggydays.setOnClickListener(this);
        Button_onemorenight.setOnClickListener(this);
        Button_tellmethatitisnttrue.setOnClickListener(this);
        Button_layladylaynashville.setOnClickListener(this);
        Button_countrypie.setOnClickListener(this);
        Button_ithrewitallawaynashville.setOnClickListener(this);
        Button_tonightiwllbestaying.setOnClickListener(this);


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
                            startActivity(new Intent(nashvilleskyline.this, Class.forName(songnameclass)));
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

            case R.id.Button_girlfromthenorthcountrynashville:
            {
                Intent intent=new Intent(this, girlfromthenorthcountry_nashville.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_nashvilleskylinerag:
            {
                Intent intent=new Intent(this, nashvilleskylinerag.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_tobealonewithyou:
            {
                Intent intent=new Intent(this, tobealonewithyou.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_ithrewitallawaynashville:
            {
                Intent intent=new Intent(this, itthrewitallaway_nashville.class);
                startActivity(intent);
                break;

            }  case R.id.Button_peggydays:
            {
                Intent intent=new Intent(this, peggydays.class);
                startActivity(intent);
                break;

            }

        case R.id.Button_layladylaynashville:
        {
            Intent intent=new Intent(this, layladylaynashville.class);
            startActivity(intent);
            break;

        }
        case R.id.Button_onemorenight:
            {
                Intent intent=new Intent(this, onemorenight.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_tellmethatitisnttrue:
            {
                Intent intent=new Intent(this, tellmethatitisnttrue.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_countrypie:
            {
                Intent intent=new Intent(this, countrypie.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_tonightillbestayingherewithyou:
            {
                Intent intent=new Intent(this, tonightillbestayinhere.class);
                startActivity(intent);
                break;

            }
            default:
                break;






        }

    }
}