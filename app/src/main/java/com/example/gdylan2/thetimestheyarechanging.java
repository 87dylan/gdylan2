package com.example.gdylan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class thetimestheyarechanging extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thetimestheyarechanging);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("The times they are a-changing");

        searchviewcode();

        Button Button_thetimestheyareachagingsong=findViewById(R.id.Button_thetimestheyareachingingsong);
        Button Button_balladofhollisbrown=findViewById(R.id.Button_balladofhollisbrown);
        Button Button_withgodonourside=findViewById(R.id.Button_withgodonourside);
        Button Button_onetoomanymorning_timeschange=findViewById(R.id.Button_onetoomany_timeschange);
        Button Button_northcountryblues=findViewById(R.id.Button_northcountryblues);
        Button Button_onlyapawnintheirgame=findViewById(R.id.Button_onlyapawninthegame);
        Button Button_bootsofspanishleather=findViewById(R.id.Button_bootsofspanishleather);
        Button Button_whentheshipcomesin=findViewById(R.id.Button_whentheshipcomesin);
        Button Button_thelonesomedeathofhattie=findViewById(R.id.Button_thelonesomedeathofhattiecarroll);
        Button Button_restlessfarewell=findViewById(R.id.Button_restlessfarewell);


        Button_thetimestheyareachagingsong.setOnClickListener(this);
        Button_balladofhollisbrown.setOnClickListener(this);
        Button_withgodonourside.setOnClickListener(this);
        Button_onetoomanymorning_timeschange.setOnClickListener(this);
        Button_northcountryblues.setOnClickListener(this);
        Button_onlyapawnintheirgame.setOnClickListener(this);
        Button_bootsofspanishleather.setOnClickListener(this);
        Button_whentheshipcomesin.setOnClickListener(this);
        Button_thelonesomedeathofhattie.setOnClickListener(this);
        Button_restlessfarewell.setOnClickListener(this);














    }

    public void searchviewcode(){


        searchView=(MaterialSearchView) findViewById(R.id.search_view);

        searchView.setSuggestions(getResources().getStringArray(R.array.querry_suggestion));

        searchView.setEllipsize(true);
        searchView.setHint("search by song name");
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                try {
                    startActivity(new Intent(thetimestheyarechanging.this, Class.forName("com.example.gdylan2."+query)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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

            case R.id.Button_thetimestheyareachingingsong:
            {
                Intent intent=new Intent(this,thetimestheyarechangingsong.class);
                startActivity(intent);
                break;

            }
            case R.id.Button_balladofhollisbrown:
            {
                Intent intent1=new Intent(this,balladofhollisbrown.class);
                startActivity(intent1);
                break;

            }
            case R.id.Button_withgodonourside:
            {
                Intent intent2=new Intent(this,withgodonourside.class);
                startActivity(intent2);
                break;

            }
            case R.id.Button_onetoomany_timeschange:
            {
                Intent intent3=new Intent(this,onetoomanymorning_timeschange.class);
                startActivity(intent3);
                break;

            }
            case R.id.Button_northcountryblues:
            {
                Intent intent4=new Intent(this,northcountryblues.class);
                startActivity(intent4);
                break;

            }
            case R.id.Button_onlyapawninthegame:
            {
                Intent intent5=new Intent(this,onlyapawnintheirgame.class);
                startActivity(intent5);
                break;

            }
            case R.id.Button_bootsofspanishleather:
            {
                Intent intent6=new Intent(this,bootsofspanishleather.class);
                startActivity(intent6);
                break;

            }
            case R.id.Button_whentheshipcomesin:
            {
                Intent intent7=new Intent(this,whenthesipcomesin.class);
                startActivity(intent7);
                break;

            }
            case R.id.Button_thelonesomedeathofhattiecarroll:
            {
                Intent intent8=new Intent(this,thelonesomedeathofhatti.class);
                startActivity(intent8);
                break;

            }  case R.id.Button_restlessfarewell:
            {
                Intent intent9=new Intent(this,restlessfarewell.class);
                startActivity(intent9);
                break;

            }
            default:
                break;






        }


    }
}