package com.example.mobiapp.tishanskayaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.classes.Quest;
import com.example.mobiapp.tishanskayaapp.disease.GenerateQuest;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton btn_R1;
    RadioButton btn_R2;
    TextView tvTitle;
    Button next;

    RadioButton rbtn1,rbtn2;

    int currentPosition = 0;

    List<Quest> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            GenerateQuest generateQuest = new GenerateQuest(this);
            list = generateQuest.questsPA();
            radioGroup = (RadioGroup) findViewById(R.id.test_radio_gr);
            tvTitle = (TextView) findViewById(R.id.test_quest);
            next = (Button) findViewById(R.id.test_next);
            rbtn1 = new RadioButton(this);
            rbtn2 = new RadioButton(this);

            radioGroup.addView(rbtn1);
            radioGroup.addView(rbtn2);

            tvTitle.setText(list.get(0).getTitle());
            rbtn1.setText(list.get(0).getAnsver1());
            rbtn2.setText(list.get(0).getAnsver2());

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(radioGroup.getCheckedRadioButtonId()!=-1)nextQuest();
                    else Toast.makeText(TestActivity.this, getResources().getString(R.string.toast_error_test), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void nextQuest() {

        if(list.get(currentPosition).getNextQuestAnswer1()!=999 || list.get(currentPosition).getNextQuestAnswer2()!=999) {
            if(radioGroup.getCheckedRadioButtonId()==0){
                currentPosition = list.get(currentPosition).getNextQuestAnswer1();
            }else {
                currentPosition = list.get(currentPosition).getNextQuestAnswer2();
            }

            tvTitle.setText(list.get(currentPosition).getTitle());
            rbtn1.setText(list.get(currentPosition).getAnsver1());
            rbtn2.setText(list.get(currentPosition).getAnsver2());

        }else {
            Toast.makeText(this, "End test", Toast.LENGTH_SHORT).show();}


    }

}
