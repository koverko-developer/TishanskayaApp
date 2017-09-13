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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mobiapp.tishanskayaapp.classes.Disease;
import com.example.mobiapp.tishanskayaapp.disease.DiseaseGenerate;
import com.example.mobiapp.tishanskayaapp.view.CircularView;
import com.example.mobiapp.tishanskayaapp.view.ScratchView;

public class SelectActionActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnTest;
    RelativeLayout action_more, action_stop, action_zhurnal;
    ImageView action_img_bg, action_select_circle;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        DiseaseGenerate generate = new DiseaseGenerate(this);

        getSupportActionBar().setTitle(generate.getAllDisease().get(id).getName());



        action_stop = (RelativeLayout) findViewById(R.id.action_stop);
        action_zhurnal = (RelativeLayout) findViewById(R.id.action_zhurnal);
        action_more = (RelativeLayout) findViewById(R.id.action_more);
        action_img_bg = (ImageView) findViewById(R.id.action_img_bg);
        action_select_circle = (ImageView) findViewById(R.id.action_select_circle);

        Glide.with(this).load(R.drawable.bg).into(action_img_bg);
        Glide.with(this).load(R.drawable.circle).into(action_select_circle);
//        CircularView cl = (CircularView) findViewById(R.id.circular_layout);
//        cl.setCount();
//        if (cl != null) {
//            cl.setOnCircularItemClickListener(new CircularView.OnCircularItemClickListener() {
//                @Override
//                public void onCircularItemClick(int index) {
//                    switch (index){
//                        case -1:
//                            Toast.makeText(SelectActionActivity.this, "STOP", Toast.LENGTH_SHORT).show();
//                            break;
//                        case 0:
//                            Toast.makeText(SelectActionActivity.this, "Журнал", Toast.LENGTH_SHORT).show();
//                            break;
//                        case 1:
//                            Toast.makeText(SelectActionActivity.this, "STOP", Toast.LENGTH_SHORT).show();
//                            break;
//                        case 2:
//                            Toast.makeText(SelectActionActivity.this, "Полное описание", Toast.LENGTH_SHORT).show();
//                            break;
//                    }
//                    //scratchView.setVisibility(View.VISIBLE);
//                    //imageView.setVisibility(View.GONE);
//                    //startActivity(new Intent(SelectActionActivity.this, UnwindActivity.class));
//                }
//            });
//        }

        action_more.setOnClickListener(this);
        action_stop.setOnClickListener(this);
        action_zhurnal.setOnClickListener(this);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.action_more:
                Intent intentDescr = new Intent(SelectActionActivity.this, DescriptionActivity.class);
                intentDescr.putExtra("id",id);
                startActivity(intentDescr);
                break;
            case R.id.action_stop:
                startActivity(new Intent(SelectActionActivity.this, UnwindActivity.class));
                break;
            case R.id.action_zhurnal:
                startActivity(new Intent(SelectActionActivity.this, ZhurnalActivity.class));
                break;

        }
    }
}
