package com.example.gdylan2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fav_fragment extends Fragment {
    databasehelper dbh= new databasehelper(getActivity());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fav,container,false);

        ListView listView=(ListView)view.findViewById(R.id.triallistview);

        ArrayList<String> thelist=new ArrayList<>();

        Cursor data=dbh.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(getActivity(), "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }

        return view;

    }




}


