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

public class blonde extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blonde);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Blonde on Blonde");

        searchviewcode();

        Button Button_sadeye=findViewById(R.id.Button_sadeyedlady);
        Button Button_rainyday=findViewById(R.id.Button_rainyday);
        Button Button_pledging=findViewById(R.id.Button_pledgging);
        Button Button_visoions=findViewById(R.id.Button_visionsofojoana);
        Button Button_oneofus=findViewById(R.id.Button_oneoofusmustknow);
        Button Button_iwantyou=findViewById(R.id.Button_iwantyou);
        Button Button_stuckinside=findViewById(R.id.Button_stuckinsidememphis);
        Button Button_leopardskin=findViewById(R.id.Button_leopardskin);
        Button Button_justlikewomen=findViewById(R.id.Button_justlikewomen);
        Button Button_mostlikelyyougoyourway=findViewById(R.id.Button_mostlikely);
        Button Button_temporarylike=findViewById(R.id.Button_temporarylike);
        Button Button_4thtimearound=findViewById(R.id.Button_4thtimearound);
        Button Button_obviously5believer=findViewById(R.id.Button_obviously5believe);
        Button Button_absolutelysweet=findViewById(R.id.Button_absolutelysweet);





        Button_sadeye.setOnClickListener(this);
        Button_rainyday.setOnClickListener(this);
        Button_pledging.setOnClickListener(this);
        Button_visoions.setOnClickListener(this);
        Button_oneofus.setOnClickListener(this);
        Button_iwantyou.setOnClickListener(this);
        Button_4thtimearound.setOnClickListener(this);
        Button_leopardskin.setOnClickListener(this);
        Button_stuckinside.setOnClickListener(this);
        Button_justlikewomen.setOnClickListener(this);
        Button_mostlikelyyougoyourway.setOnClickListener(this);
        Button_temporarylike.setOnClickListener(this);
        Button_obviously5believer.setOnClickListener(this);
        Button_absolutelysweet.setOnClickListener(this);


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
                            startActivity(new Intent(blonde.this, Class.forName(songnameclass)));
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

            case R.id.Button_sadeyedlady:
                Intent intent =new Intent(this, sadeyelady.class);
                startActivity(intent);
                break;

            case R.id.Button_rainyday:
                Intent intent2 =new Intent(this, rainyday_women.class);
                startActivity(intent2);
                break;
            case R.id.Button_pledgging:
                Intent intent3 =new Intent(this, pledggingmytime.class);
                startActivity(intent3);
                break;
            case R.id.Button_visionsofojoana:
                Intent intent4 =new Intent(this, visionsofjoana.class);
                startActivity(intent4);
                break;
            case R.id.Button_oneoofusmustknow:
                Intent intent5 =new Intent(this, oneofusmustknow.class);
                startActivity(intent5);
                break;
            case R.id.Button_iwantyou:
                Intent intent6 =new Intent(this, iwantyou.class);
                startActivity(intent6);
                break;
            case R.id.Button_stuckinsidememphis:
                Intent intent7 =new Intent(this, stuckinside.class);
                startActivity(intent7);
                break;
            case R.id.Button_leopardskin:
                Intent intent8 =new Intent(this, leopardskin.class);
                startActivity(intent8);
                break;
            case R.id.Button_justlikewomen:
                Intent intent9 =new Intent(this, justlikeawomen.class);
                startActivity(intent9);
                break;
            case R.id.Button_mostlikely:
                Intent intent10 =new Intent(this, mostlikelyyougo.class);
                startActivity(intent10);
                break;
            case R.id.Button_temporarylike:
                Intent intent11 =new Intent(this, temporarylikeachiles.class);
                startActivity(intent11);
                break;
            case R.id.Button_absolutelysweet:
                Intent intent12 =new Intent(this, AbsolutelySweetMarie.class);
                startActivity(intent12);
                break;
            case R.id.Button_4thtimearound:
                Intent intent13 =new Intent(this, fourthtimearound.class);
                startActivity(intent13);
                break;
            case R.id.Button_obviously5believe:
                Intent intent14 =new Intent(this, Obviously5Believer.class);
                startActivity(intent14);
                break;










            default:
                break;
        }
    }
}

