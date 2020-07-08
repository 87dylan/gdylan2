package com.example.gdylan2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class contentview extends AppCompatActivity {
    MaterialSearchView searchView;

    databasehelper dbh= new databasehelper(this);
    ArrayList<String> listitems=new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontent);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Great Taste");
        searchviewcode();


        ListView listView=(ListView)findViewById(R.id.triallistview);

        Cursor data=dbh.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){

                listitems.add(data.getString(1));
                listView.setAdapter(new customadapter(contentview.this,R.layout.listcustom,listitems));

            }



    }







        }

    public void searchviewcode(){




        searchView=(MaterialSearchView) findViewById(R.id.search_view);

        searchView.setSuggestions(getResources().getStringArray(R.array.querry_suggestion));

        searchView.setEllipsize(true);
        searchView.setHint("search by song name");


        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Cursor data=dbh.getListContents();

                while(data.moveToNext()){
                    if(data.getString(1).equals(query)) {
                        String songnameclass=data.getString(2);


                        try {
                            startActivity(new Intent(contentview.this, Class.forName(songnameclass)));
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


    public class customadapter extends ArrayAdapter {

        ArrayList<String> thelist;

        public customadapter(@NonNull Context context, int resource, ArrayList<String> items) {
            super(context, resource,items);
            this.thelist=items;

        }


        public class ViewHolder{
            Button button;
            CheckBox checkBox;
        }

        @Override
        public int getCount() {
            return thelist.size();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row;
            row=convertView;
            final ViewHolder viewHolder;
            if(row==null){
                row= LayoutInflater.from(getContext()).inflate(R.layout.listcustom,parent,false);
                viewHolder= new ViewHolder();
                viewHolder.button=row.findViewById(R.id.textView2);
                viewHolder.checkBox=row.findViewById(R.id.checkBox);
                row.setTag(viewHolder);

            }
            else{
                viewHolder =(ViewHolder) row.getTag();
            }
            viewHolder.button.setText(thelist.get(position));
// onlclick listener for the button implementation
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String str=((TextView)viewHolder.button).getText().toString();

                    Cursor data=dbh.getListContents();

                    while(data.moveToNext()){
                        if(data.getString(1).equals(str)) {
                            String songnameclass=data.getString(2);


                            try {
                                startActivity(new Intent(contentview.this, Class.forName(songnameclass)));
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }


                        }

                    }
                }
            });

            //on statechanged listener for the checkox

            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                String classnameofsong;

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String currentsongname=((TextView)viewHolder.button).getText().toString();
                    Cursor data=dbh.getListContents();
                    while(data.moveToNext()){
                        if(data.getString(1).equals(currentsongname)) {
                           classnameofsong=data.getString(2);
                            break;

                        }

                    }

                    if(isChecked){
                        dbh.deleteData(currentsongname);
                        Toast.makeText(contentview.this, "The song is removed from fav",Toast.LENGTH_SHORT).show();

                    }
                    else{

                        dbh.addData(currentsongname, classnameofsong);
                        Toast.makeText(contentview.this, "The song added back to favlist ",Toast.LENGTH_SHORT).show();


                    }
                }
            });







            return row;
        }
    }







}
