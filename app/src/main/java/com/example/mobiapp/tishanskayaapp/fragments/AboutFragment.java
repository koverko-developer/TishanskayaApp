package com.example.mobiapp.tishanskayaapp.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mobiapp.tishanskayaapp.AboutActivity;
import com.example.mobiapp.tishanskayaapp.FullscreenActivity;
import com.example.mobiapp.tishanskayaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment implements View.OnClickListener {

    ImageView imgDescription, imgMain;
    TextView tvDescription, tvAllDescr;
    ImageView img, img2, img3, img4, img5, img6, img7, img8, img9, img10;
    View v;
    RelativeLayout about_geo;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v = inflater.inflate(R.layout.fragment_about, container, false);
        init();
        registerClickListener();

        return v;
    }

    public void init(){


        try {
            about_geo = (RelativeLayout) v.findViewById(R.id.about_geo);
            tvDescription = (TextView) v.findViewById(R.id.textView13);
            tvAllDescr = (TextView) v.findViewById(R.id.textView15);
            img = (ImageView) v.findViewById(R.id.about_1);
            Glide.with(this).load(R.drawable.sertificate_1).into(img);
            img2 = (ImageView) v.findViewById(R.id.full_2);
            Glide.with(this).load(R.drawable.sertificate_2).into(img2);
            img3 = (ImageView) v.findViewById(R.id.about_3);
            Glide.with(this).load(R.drawable.sertificate_3).into(img3);
            img4 = (ImageView) v.findViewById(R.id.about_4);
            Glide.with(this).load(R.drawable.sertificate_4).into(img4);
            img5 = (ImageView) v.findViewById(R.id.about_5);
            Glide.with(this).load(R.drawable.sertificate_5).into(img5);
            img6 = (ImageView) v.findViewById(R.id.about_6);
            Glide.with(this).load(R.drawable.sertificate_6).into(img6);
            img7 = (ImageView) v.findViewById(R.id.about_7);
            Glide.with(this).load(R.drawable.sertificate_7).into(img7);
            img8 = (ImageView) v.findViewById(R.id.about_8);
            Glide.with(this).load(R.drawable.sertificate_8).into(img8);
            img9 = (ImageView) v.findViewById(R.id.about_9);
            Glide.with(this).load(R.drawable.sertificate_9).into(img9);
            img10 = (ImageView) v.findViewById(R.id.about_10);
            Glide.with(this).load(R.drawable.sertificate_10).into(img10);

            imgMain = (ImageView) v.findViewById(R.id.main_backdrop);
            Glide.with(this).load(R.drawable.photo_psiholog).into(imgMain);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void registerClickListener(){
        img.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        img10.setOnClickListener(this);


        tvAllDescr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDescription.setText(getResources().getString(R.string.about_text_4));
                tvAllDescr.setVisibility(View.GONE);
            }
        });

        about_geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getResources().getString(R.string.address);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.getActivity(), FullscreenActivity.class);
        switch (view.getId()){
            case R.id.about_1:
                intent.putExtra("id", 1);
                break;
            case R.id.full_2:
                intent.putExtra("id", 2);
                break;
            case R.id.about_3:
                intent.putExtra("id", 3);
                break;
            case R.id.about_4:
                intent.putExtra("id", 4);
                break;
            case R.id.about_5:
                intent.putExtra("id", 5);
                break;
            case R.id.about_6:
                intent.putExtra("id", 6);
                break;
            case R.id.about_7:
                intent.putExtra("id", 7);
                break;
            case R.id.about_8:
                intent.putExtra("id", 8);
                break;
            case R.id.about_9:
                intent.putExtra("id", 9);
                break;
            case R.id.about_10:
                intent.putExtra("id", 10);
                break;
        }
        startActivity(intent);
    }

    public void call(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ getResources().getString(R.string.phone)));
        startActivity(Intent.createChooser(intent, "Call"));
    }

    public void sendEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, getResources().getString(R.string.email));
        startActivity(Intent.createChooser(intent, "Send Email"));
    }
}
