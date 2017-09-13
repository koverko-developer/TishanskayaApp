package com.example.mobiapp.tishanskayaapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    int id;
    TextView tv_descr;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;
        tv_descr = (TextView) findViewById(R.id.description_text);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        switch (id) {
            case 0:
                getSupportActionBar().setTitle(context.getResources().getString(R.string.pa_name));
                tv_descr.setText(context.getResources().getString(R.string.pa_descr));
                break;
            case 1:
                getSupportActionBar().setTitle(context.getResources().getString(R.string.paa_name));
                tv_descr.setText(context.getResources().getString(R.string.paa_descr));
                break;
            case 3:
                getSupportActionBar().setTitle(context.getResources().getString(R.string.depressia_name));
                tv_descr.setText(context.getResources().getString(R.string.depressia_descr));
                break;
            case 4:
                getSupportActionBar().setTitle(context.getResources().getString(R.string.mono_name));
                tv_descr.setText(context.getResources().getString(R.string.mono_descr));
                break;
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
