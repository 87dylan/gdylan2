package com.example.gdylan2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        view.findViewById(R.id.imageButton_blonde).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_anotherside).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_bobdylan).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_hardrains).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_bringingitallback).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_freewheeling).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_highway61).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_johnweasley).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_shotoflove).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_timeschanging).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_streetlegal).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_slowtrain).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_tempest).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_nashville).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_desire).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_bloodontrack).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_newmorning).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_timoutofmind).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_infedels).setOnClickListener(mListener);
        view.findViewById(R.id.imageButton_roughandrowdy).setOnClickListener(mListener);




        return  view;

    }

    private final View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton_blonde:
                {
                    startActivity(new Intent(getActivity(), blonde.class));

                    break;
                }
                case R.id.imageButton_anotherside:
                    {
                        startActivity(new Intent(getActivity(), anotherside.class));
                    break;
                }
                case R.id.imageButton_bobdylan:
                {
                    startActivity(new Intent(getActivity(), bobdylan.class));

                    break;
                }

                case R.id.imageButton_hardrains: {
                    startActivity(new Intent(getActivity(), hardrain.class));
                    break;
                }
                case R.id.imageButton_bringingitallback: {
                    startActivity(new Intent(getActivity(), bringingitallback.class));
                    break;
                }
                case R.id.imageButton_freewheeling:
                {
                    startActivity(new Intent(getActivity(), freewheelinbobdylan.class));

                    break;
                }

                case R.id.imageButton_highway61: {
                    startActivity(new Intent(getActivity(), highway61revisited.class));


                    break;
                }
                case R.id.imageButton_johnweasley: {
                    startActivity(new Intent(getActivity(), johnwesleyhardings.class));

                    break;
                }
                case R.id.imageButton_shotoflove: {
                    startActivity(new Intent(getActivity(), shotoflove.class));

                    break;
                }
                case R.id.imageButton_timeschanging: {
                    startActivity(new Intent(getActivity(), thetimestheyarechanging.class));

                    break;
                }
                case R.id.imageButton_streetlegal: {
                    startActivity(new Intent(getActivity(), streetlegal.class));
                    break;
                }
                case R.id.imageButton_slowtrain:
                {
                    startActivity(new Intent(getActivity(), slowtrain.class));
                    break;}

                case R.id.imageButton_tempest: {
                    startActivity(new Intent(getActivity(), tempest.class));

                    break;
                }
                case R.id.imageButton_nashville: {
                    startActivity(new Intent(getActivity(), nashvilleskyline.class));
                    break;
                }
                case R.id.imageButton_desire:
                {
                    startActivity(new Intent(getActivity(), desire.class));

                    break;}

                case R.id.imageButton_bloodontrack: {
                    startActivity(new Intent(getActivity(), bloodonthetracks.class));

                    break;
                }
                case R.id.imageButton_newmorning: {
                    startActivity(new Intent(getActivity(), newmorning.class));

                    break;
                }

                case R.id.imageButton_timoutofmind:{
                    startActivity(new Intent(getActivity(), timeoutofmind.class));

                    break;
                }
                case R.id.imageButton_roughandrowdy: {
                    startActivity(new Intent(getActivity(), roughandrowdyways.class));

                    break;
                }
                case R.id.imageButton_infedels: {
                    startActivity(new Intent(getActivity(), infedels.class));

                    break;
                }


                default:
                    break;


            }
        }
    };








}
