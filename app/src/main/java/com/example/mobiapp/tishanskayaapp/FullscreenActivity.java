package com.example.mobiapp.tishanskayaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    int[] arrImage = new int[]{R.drawable.sertificate_1, R.drawable.sertificate_2, R.drawable.sertificate_3,
                                R.drawable.sertificate_4, R.drawable.sertificate_5, R.drawable.sertificate_6,
                                R.drawable.sertificate_7, R.drawable.sertificate_8, R.drawable.sertificate_9,
                                R.drawable.sertificate_10};
    int[] arrString = new int[]{
            R.string.sertificate_1_name,
            R.string.sertificate_2_name,
            R.string.sertificate_3_name,
            R.string.sertificate_4_name,
            R.string.sertificate_5_name,
            R.string.sertificate_6_name,
            R.string.sertificate_7_name,
            R.string.sertificate_8_name,
            R.string.sertificate_9_name,
            R.string.sertificate_10_name
                                    };
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        img = (ImageView) findViewById(R.id.full_image);
        try {
            Intent intent = getIntent();
            int id = intent.getIntExtra("id",0);
            img.setImageDrawable(getResources().getDrawable(arrImage[id-1]));
            getSupportActionBar().setTitle(getResources().getString(arrString[id-1]));
        } catch (Exception e) {
            e.printStackTrace();
        }


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
