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

public class johnwesleyhardings extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_johnwesleyhardings);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("John Wesley hardings");

        searchviewcode();
        Button Button_johnwesleyhardingsong=findViewById(R.id.Button_johnwesleyhardingsong);
        Button Button_asiwentoutonemorm=findViewById(R.id.Button_asiwentoutonemorn);
        Button Button_idreamedisawaugustine=findViewById(R.id.Button_idreamedisawstaugustie);
        Button Button_allalongthewatchtower=findViewById(R.id.Button_allalongthewatchtower);
        Button Button_theballadoffrankie=findViewById(R.id.Button_theballadoffrankieleeandjudas);
        Button Button_driftersescape=findViewById(R.id.Button_driftersescape);
        Button Button_dearlandlord=findViewById(R.id.Button_dearlandlord);
        Button Button_iamlonesomehobo=findViewById(R.id.Button_iamalonesomehobo);
        Button Button_ipitythepoorimmigrant=findViewById(R.id.Button_ipitythepoorimmigrant);
        Button Button_thewickedmessenger=findViewById(R.id.Button_thewickedmessenger);
        Button Button_downalongthecove=findViewById(R.id.Button_downalongthecove);
        Button Button_illbeyourbabytonight=findViewById(R.id.Button_illbeyourbabytonight);


        Button_johnwesleyhardingsong.setOnClickListener(this);
        Button_asiwentoutonemorm.setOnClickListener(this);
        Button_idreamedisawaugustine.setOnClickListener(this);
        Button_allalongthewatchtower.setOnClickListener(this);
        Button_theballadoffrankie.setOnClickListener(this);
        Button_driftersescape.setOnClickListener(this);
        Button_dearlandlord.setOnClickListener(this);
        Button_iamlonesomehobo.setOnClickListener(this);
        Button_ipitythepoorimmigrant.setOnClickListener(this);
        Button_thewickedmessenger.setOnClickListener(this);
        Button_downalongthecove.setOnClickListener(this);
        Button_illbeyourbabytonight.setOnClickListener(this);






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
                            startActivity(new Intent(johnwesleyhardings.this, Class.forName(songnameclass)));
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

            case R.id.Button_johnwesleyhardingsong:
                Intent intent=new Intent(this, johnwesleyhardingsong.class);
                startActivity(intent);
                break;

            case R.id.Button_asiwentoutonemorn:
                Intent intent2=new Intent(this, asiwentoutonemorning.class);
                startActivity(intent2);
                break;
            case R.id.Button_idreamedisawstaugustie:
                Intent intent3=new Intent(this, idreamedisawstaugustine.class);
                startActivity(intent3);
                break;
            case R.id.Button_allalongthewatchtower:
                Intent intent4=new Intent(this, allalongthewatchtower.class);
                startActivity(intent4);
                break;
            case R.id.Button_theballadoffrankieleeandjudas:
                Intent intent5=new Intent(this, theballadoffrankielee.class);
                startActivity(intent5);
                break;
            case R.id.Button_driftersescape:
                Intent intent6=new Intent(this, driftersescape.class);
                startActivity(intent6);
                break;
            case R.id.Button_dearlandlord:
                Intent intent7=new Intent(this, dearlandlord.class);
                startActivity(intent7);
                break;
            case R.id.Button_iamalonesomehobo:
                Intent intent8=new Intent(this, iamalonesomehobo.class);
                startActivity(intent8);
                break;
            case R.id.Button_ipitythepoorimmigrant:
                Intent intent9=new Intent(this, ipitythepoorimmigrant.class);
                startActivity(intent9);
                break;
            case R.id.Button_thewickedmessenger:
                Intent intent10=new Intent(this, thewickedmessenger.class);
                startActivity(intent10);
                break;
            case R.id.Button_downalongthecove:
                Intent intent11=new Intent(this, downalongthecove.class);
                startActivity(intent11);
                break;
            case R.id.Button_illbeyourbabytonight:
                Intent intent12=new Intent(this, illbeyourbabytonight.class);
                startActivity(intent12);
                break;

            default:
                break;


        }

    }
}