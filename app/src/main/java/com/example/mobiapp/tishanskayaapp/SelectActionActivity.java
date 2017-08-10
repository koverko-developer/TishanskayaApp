package com.example.mobiapp.tishanskayaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.view.CircularView;
import com.example.mobiapp.tishanskayaapp.view.ScratchView;

public class SelectActionActivity extends AppCompatActivity {


    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnTest = (Button) findViewById(R.id.select_action_test);

        CircularView cl = (CircularView) findViewById(R.id.circular_layout);
        cl.setCount();
        if (cl != null) {
            cl.setOnCircularItemClickListener(new CircularView.OnCircularItemClickListener() {
                @Override
                public void onCircularItemClick(int index) {
                    //scratchView.setVisibility(View.VISIBLE);
                    //imageView.setVisibility(View.GONE);
                    startActivity(new Intent(SelectActionActivity.this, UnwindActivity.class));
                }
            });
        }
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActionActivity.this, TestActivity.class));
            }
        });
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
