package com.example.gdylan2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class FragmentSecond extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view=inflater.inflate(R.layout.fragment_second,container,false);

        WebView webView=(WebView)view.findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(Color.TRANSPARENT);

        webView.loadUrl("https://en.m.wikipedia.org/wiki/Bob_Dylan");


     return view;


    }


}
