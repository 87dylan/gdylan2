package com.example.gdylan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class dashboard extends AppCompatActivity implements View.OnClickListener {

    MaterialSearchView searchView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchviewcode();

        ImageButton imageButton_blonde=findViewById(R.id.imageButton_blonde);
        ImageButton imageButton_anotherside=findViewById(R.id.imageButton_anotherside);
        ImageButton imageButton_bobdylan=findViewById(R.id.imageButton_bobdylan);
        ImageButton imageButton_hardrain=findViewById(R.id.imageButton_hardrains);
        ImageButton imageButton_bringingitallback=findViewById(R.id.imageButton_bringingitallback);
        ImageButton imageButton_freewheelinbobdylan=findViewById(R.id.imageButton_freewheeling);
        ImageButton imageButton_highway61revisited=findViewById(R.id.imageButton_highway61);
        ImageButton imageButton_johnwesleyhardings=findViewById(R.id.imageButton_johnweasley);
        ImageButton imageButton_shotoflove=findViewById(R.id.imageButton_shotoflove);
        ImageButton imageButton_thetimestheyareachangeging=findViewById(R.id.imageButton_timeschanging);
        ImageButton imageButton_streetlegal=findViewById(R.id.imageButton_streetlegal);
        ImageButton imageButton_slowtrain=findViewById(R.id.imageButton_slowtrain);
        ImageButton imageButton_tempest=findViewById(R.id.imageButton_tempest);
        ImageButton imageButton_nashville=findViewById(R.id.imageButton_nashville);
        ImageButton imageButton_desire=findViewById(R.id.imageButton_desire);
        ImageButton imageButton_bloodontrack=findViewById(R.id.imageButton_bloodontrack);







        imageButton_blonde.setOnClickListener(this);
        imageButton_anotherside.setOnClickListener(this);
        imageButton_bobdylan.setOnClickListener(this);
        imageButton_hardrain.setOnClickListener(this);
        imageButton_bringingitallback.setOnClickListener(this);
        imageButton_freewheelinbobdylan.setOnClickListener(this);
        imageButton_highway61revisited.setOnClickListener(this);
        imageButton_johnwesleyhardings.setOnClickListener(this);
        imageButton_shotoflove.setOnClickListener(this);
        imageButton_thetimestheyareachangeging.setOnClickListener(this);
        imageButton_streetlegal.setOnClickListener(this);
        imageButton_slowtrain.setOnClickListener(this);
        imageButton_tempest.setOnClickListener(this);
        imageButton_nashville.setOnClickListener(this);
        imageButton_desire.setOnClickListener(this);
        imageButton_bloodontrack.setOnClickListener(this);




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
                    startActivity(new Intent(dashboard.this, Class.forName("com.example.gdylan2."+query)));
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

            case R.id.imageButton_blonde:
            {
                Intent intent = new Intent(this, blonde.class);
                startActivity(intent);
                break;
            }
            case R.id.imageButton_anotherside: {
                Intent intent1 = new Intent(this, anotherside.class);
                startActivity(intent1);
                break;
            }
            case R.id.imageButton_bobdylan:
            { Intent intent2=new Intent(this,bobdylan.class);
                startActivity(intent2);
                break;}
            case R.id.imageButton_hardrains:
            { Intent intent3=new Intent(this,hardrain.class);
                startActivity(intent3);
                break;}

            case R.id.imageButton_bringingitallback:
            { Intent intent4=new Intent(this,bringingitallback.class);
                startActivity(intent4);
                break;}

            case R.id.imageButton_freewheeling:
            { Intent intent5=new Intent(this,freewheelinbobdylan.class);
                startActivity(intent5);
                break;}
            case R.id.imageButton_highway61:
            {  Intent intent6=new Intent(this,highway61revisited.class);
                startActivity(intent6);
                break;}
            case R.id.imageButton_johnweasley:
            {Intent intent7=new Intent(this,johnwesleyhardings.class);
                startActivity(intent7);
                break;}
            case R.id.imageButton_shotoflove:
            { Intent intent8=new Intent(this,shotoflove.class);
                startActivity(intent8);
                break;}
            case R.id.imageButton_timeschanging:
            {
                Intent intent9=new Intent(this,thetimestheyarechanging.class);
                startActivity(intent9);
                break;
            }
            case R.id.imageButton_streetlegal:
            {
                Intent intent10=new Intent(this,streetlegal.class);
                startActivity(intent10);
                break;
            }
            case R.id.imageButton_slowtrain:
            {
                Intent intent11=new Intent(this,slowtrain.class);
                startActivity(intent11);
                break;
            }
            case R.id.imageButton_tempest:
            {
                Intent intent12=new Intent(this,tempest.class);
                startActivity(intent12);
                break;
            }
            case R.id.imageButton_nashville:
            {
                Intent intent13=new Intent(this,nashvilleskyline.class);
                startActivity(intent13);
                break;
            }
            case R.id.imageButton_desire:
            {
                Intent intent14=new Intent(this,desire.class);
                startActivity(intent14);
                break;
            }
            case R.id.imageButton_bloodontrack:
            {
                Intent intent15=new Intent(this,bloodonthetracks.class);
                startActivity(intent15);
                break;
            }




            default:
                break;




        }

    }
}