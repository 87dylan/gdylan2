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

public class freewheelinbobdylan extends AppCompatActivity implements View.OnClickListener {
    MaterialSearchView searchView;
    Toolbar toolbar;
    databasehelper2 dbh2=new databasehelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freewheelinbobdylan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Freewheelin' Bob dylan");

        searchviewcode();


        Button Button_blowinginthewind = findViewById(R.id.Button_blowininthewind);
        Button Button_girlfromnorthcountry = findViewById(R.id.Button_grilfromthenorthcountry);
        Button Button_mastersofwar = findViewById(R.id.Button_mastersofwar);
        Button Button_downthehighway = findViewById(R.id.Button_downthehighway);
        Button Button_bobdylansblue = findViewById(R.id.Button_bobdylansblue);
        Button Button_ahardrainsgonnafall = findViewById(R.id.Button_ahardrainsgonnafall);
        Button Button_dontthinktwice = findViewById(R.id.Button_dontthinktwiceitsallright);
        Button Button_bobdylansdreamfreewheelin = findViewById(R.id.Button_bobdylansdream);
        Button Button_oxfordtown = findViewById(R.id.Button_oxfordtown);
        Button Button_talkinworldwar3 = findViewById(R.id.Button_talkinworldwarthreeblue);
        Button Button_corrina = findViewById(R.id.Button_corrinacorrina);
        Button Button_honeyjustallowme = findViewById(R.id.Button_honeyjustallowmeonemorechance);
        Button Button_ishallbefree = findViewById(R.id.Button_ishallbefreefreewheelin);

        Button_blowinginthewind.setOnClickListener(this);
        Button_girlfromnorthcountry.setOnClickListener(this);
        Button_mastersofwar.setOnClickListener(this);
        Button_downthehighway.setOnClickListener(this);
        Button_bobdylansblue.setOnClickListener(this);
        Button_ahardrainsgonnafall.setOnClickListener(this);
        Button_dontthinktwice.setOnClickListener(this);
        Button_bobdylansdreamfreewheelin.setOnClickListener(this);
        Button_oxfordtown.setOnClickListener(this);
        Button_talkinworldwar3.setOnClickListener(this);
        Button_corrina.setOnClickListener(this);
        Button_honeyjustallowme.setOnClickListener(this);
        Button_ishallbefree.setOnClickListener(this);
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
                            startActivity(new Intent(freewheelinbobdylan.this, Class.forName(songnameclass)));
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

            case R.id.Button_blowininthewind:

                Intent intent = new Intent(this, blowinginthewind.class);
                startActivity(intent);
                break;
            case R.id.Button_grilfromthenorthcountry:

                Intent intent2 = new Intent(this, girlfromnorthcountry.class);
                startActivity(intent2);
                break;

            case R.id.Button_mastersofwar:

                Intent intent3 = new Intent(this, mastersofwar.class);
                startActivity(intent3);
                break;
            case R.id.Button_downthehighway:

                Intent intent4 = new Intent(this, downthehighway.class);
                startActivity(intent4);
                break;
            case R.id.Button_bobdylansblue:

                Intent intent5 = new Intent(this, bobdylansblues.class);
                startActivity(intent5);
                break;
            case R.id.Button_ahardrainsgonnafall:

                Intent intent6 = new Intent(this, ahardrainsgonnafall.class);
                startActivity(intent6);
                break;
            case R.id.Button_dontthinktwiceitsallright:

                Intent intent7 = new Intent(this, dontthinktwiceitsallright.class);
                startActivity(intent7);
                break;
            case R.id.Button_bobdylansdream:

                Intent intent8 = new Intent(this, bobdylansdream.class);
                startActivity(intent8);
                break;
            case R.id.Button_oxfordtown:

                Intent intent9 = new Intent(this, oxfordtown.class);
                startActivity(intent9);
                break;
            case R.id.Button_talkinworldwarthreeblue:

                Intent intent10 = new Intent(this, talkingworldwarthree.class);
                startActivity(intent10);
                break;
            case R.id.Button_corrinacorrina:

                Intent intent11 = new Intent(this, corrinacorrina.class);
                startActivity(intent11);
                break;
            case R.id.Button_honeyjustallowmeonemorechance:

                Intent intent12 = new Intent(this, honeyjustallowme.class);
                startActivity(intent12);
                break;
            case R.id.Button_ishallbefreefreewheelin:

                Intent intent13 = new Intent(this, ishallbefreefreewheelin.class);
                startActivity(intent13);
                break;
            default:
                break;


        }
    }
}