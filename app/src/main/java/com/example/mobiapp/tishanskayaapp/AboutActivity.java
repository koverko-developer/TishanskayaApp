package com.example.mobiapp.tishanskayaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.mobiapp.tishanskayaapp.R.id.imageView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgDescription, imgMain;
    TextView tvDescription, tvAllDescr;
    ImageView img, img2, img3, img4, img5, img6, img7, img8, img9, img10;
    LinearLayout about_phone, about_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle(getResources().getString(R.string.about));

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        registerClickListener();
    }

    public void init(){


        try {
            tvDescription = (TextView) findViewById(R.id.textView13);
            tvAllDescr = (TextView) findViewById(R.id.textView15);
            img = (ImageView) findViewById(R.id.about_1);
            img2 = (ImageView) findViewById(R.id.full_2);
            img3 = (ImageView) findViewById(R.id.about_3);
            img4 = (ImageView) findViewById(R.id.about_4);
            img5 = (ImageView) findViewById(R.id.about_5);
            img6 = (ImageView) findViewById(R.id.about_6);
            img7 = (ImageView) findViewById(R.id.about_7);
            img8 = (ImageView) findViewById(R.id.about_8);
            img9 = (ImageView) findViewById(R.id.about_9);
            img10 = (ImageView) findViewById(R.id.about_10);
            about_phone = (LinearLayout) findViewById(R.id.about_phone);
            about_email = (LinearLayout) findViewById(R.id.about_email);

            imgMain = (ImageView) findViewById(R.id.main_backdrop);
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
            }
        });

        try {
            about_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    call();
                }
            });
            about_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendEmail();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(AboutActivity.this, FullscreenActivity.class);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                // do what you want to be done on home button click event
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
