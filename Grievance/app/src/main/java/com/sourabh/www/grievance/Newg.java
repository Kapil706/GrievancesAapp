package com.sourabh.www.grievance;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Newg extends Fragment {

    ImageView img,img2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_newg, container, false);
        img=(ImageView) rootView.findViewById(R.id.imageView4);
        img2=(ImageView)rootView.findViewById(R.id.imageView5);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in= new Intent(getActivity(),djb.class);
                startActivity(in);
            }
        });

        return  rootView;
    }
}
