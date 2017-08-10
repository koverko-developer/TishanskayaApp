package com.example.mobiapp.tishanskayaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobiapp.tishanskayaapp.classes.Unwind;
import com.example.mobiapp.tishanskayaapp.disease.GenerateUnwind;
import com.example.mobiapp.tishanskayaapp.view.ScratchView;

import java.util.List;

public class UnwindActivity extends AppCompatActivity implements View.OnClickListener {

    List<Unwind> list;
    Button button;
    int currentPosition = 0;
    boolean isDone = false;
    TextView title, text;
    ScratchView scratchView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unwind);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GenerateUnwind generateUnwind = new GenerateUnwind(this);
        list = generateUnwind.getAllUnwindPA();

        button = (Button) findViewById(R.id.unwind_button);
        button.setOnClickListener(this);

        text = (TextView) findViewById(R.id.unwind_text);
        title = (TextView) findViewById(R.id.unwind_title);

        scratchView = (ScratchView) findViewById(R.id.select_action_scratch_view);
        imageView = (ImageView) findViewById(R.id.select_action_image);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.unwind_button:
                if(!isDone) nextUnwind();
                else onBackPressed();
                break;
        }
    }

    private void nextUnwind() {
        if(currentPosition!=list.size()-1){
            title.setText(list.get(currentPosition).getName());
            text.setText(list.get(currentPosition).getDescription());
            currentPosition++;
        }else {
            isDone = true;
            scratchView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
            button.setText(getResources().getString(R.string.done));
            text.setVisibility(View.GONE);
            title.setText(getResources().getString(R.string.unwind_text_end));
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
