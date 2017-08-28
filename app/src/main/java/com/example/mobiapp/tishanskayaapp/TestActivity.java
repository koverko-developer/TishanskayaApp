package com.example.mobiapp.tishanskayaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.classes.Quest;
import com.example.mobiapp.tishanskayaapp.disease.GenerateQuest;
import com.example.mobiapp.tishanskayaapp.fragments.FragmentAgorafobiya;
import com.example.mobiapp.tishanskayaapp.fragments.FragmentPanika;
import com.example.mobiapp.tishanskayaapp.fragments.FragmentSelectDisease;
import com.example.mobiapp.tishanskayaapp.fragments.FragmentSimptoms;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private static Fragment fragment;
    private FragmentManager fragmentManager;

    private FragmentTransaction transaction;
    int currentPosition = 0;

    List<Quest> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        fragment = new FragmentSelectDisease(this);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

//    private void nextQuest() {
//
//        if(currentPosition==0){
//            int id = radioGroup.getCheckedRadioButtonId();
//            switch (id){
//                case 1:
//                case 4:
//                    currentPosition = 1;
//                    tvTitle.setText(list.get(currentPosition).getTitle());
//                    rbtn1.setText(list.get(currentPosition).getAnsver1());
//                    rbtn2.setText(list.get(currentPosition).getAnsver2());
//                    rbtn3.setVisibility(View.GONE);
//                    break;
//                case 2:
//                case 5:
//                    Toast.makeText(TestActivity.this, "Монофобическое растройство",Toast.LENGTH_SHORT).show();
//                    break;
//                case 3:
//                case 6:
//                    Toast.makeText(TestActivity.this, "Возможно ваше состояние имеет какой-либо органический фактор, обратитесь пожалуйста к вашему врачу.",Toast.LENGTH_SHORT).show();
//                    break;
//            }
//            String s = "";
//        }else if(currentPosition==2){
//
//            switch (radioGroup.getCheckedRadioButtonId()){
//                case 1:
//                case 3:
//                    Toast.makeText(TestActivity.this, "Агорафобия без Панических атак.",Toast.LENGTH_SHORT).show();
//                    break;
//                case 2:
//                case 4:
//                    Toast.makeText(TestActivity.this, "Возможно ваше состояние имеет какой-либо органический фактор, обратитесь пожалуйста к вашему врачу.",Toast.LENGTH_SHORT).show();
//                    break;
//
//            }
//        }else {
//           switch (radioGroup.getCheckedRadioButtonId()){
//               case 1:
//               case 3:
//                   Toast.makeText(TestActivity.this, "Агорафобия с паническими атаками.",Toast.LENGTH_SHORT).show();
//                   break;
//               case 2:
//               case 4:
//                   Toast.makeText(TestActivity.this, "Паническиe атаки.",Toast.LENGTH_SHORT).show();
//                   break;
//           }
//        }
//
//    }
//    private void selectRadio(){
//
//        if(getCountItemSelected()<4){
//            currentPosition = 2;
//            rbtn3.setVisibility(View.GONE);
//        }else {
//            currentPosition = 0;
//        }
//        tvTitle.setText(list.get(currentPosition).getTitle());
//        rbtn1.setText(list.get(currentPosition).getAnsver1());
//        rbtn2.setText(list.get(currentPosition).getAnsver2());
//        lvMain.setVisibility(View.GONE);
//        radioGroup.setVisibility(View.VISIBLE);
//    }
//
//    private void getChecked(){
//        int i = radioGroup.getCheckedRadioButtonId();
//        String s = "";
//
//    }

    public void fragmentSimptoms(){
        fragment = new FragmentSimptoms(this);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void fragmentAgorafobiya(){
        fragment = new FragmentAgorafobiya(this);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void fragmentPanika(){
        fragment = new FragmentPanika(this);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
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

//    private int  getCountItemSelected(){
//        int count = 0;
//        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
//        for (int i = 0; i < sbArray.size(); i++) {
//            int key = sbArray.keyAt(i);
//            if (sbArray.get(key))
//                count++;
//        }
//
//        return count;
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //init();
    }
//    private void init(){
//        try {
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//            lvMain = (ListView) findViewById(R.id.test_list);
//            // устанавливаем режим выбора пунктов списка
//            lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//            // Создаем адаптер, используя массив из файла ресурсов
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                    this, R.array.simptoms,
//                    android.R.layout.simple_list_item_single_choice);
//            lvMain.setAdapter(adapter);
//
//            GenerateQuest generateQuest = new GenerateQuest(this);
//            list = generateQuest.questsPA();
//            radioGroup = (RadioGroup) findViewById(R.id.test_radio_gr);
//            tvTitle = (TextView) findViewById(R.id.test_quest);
//            next = (Button) findViewById(R.id.test_next);
//            rbtn1 = new RadioButton(this);
//            rbtn2 = new RadioButton(this);
//            rbtn3 = new RadioButton(this);
//
//            radioGroup.addView(rbtn1);
//            radioGroup.addView(rbtn2);
//            radioGroup.addView(rbtn3);
//
//            tvTitle.setText(list.get(0).getTitle());
//            rbtn1.setText(list.get(0).getAnsver1());
//            rbtn2.setText(list.get(0).getAnsver2());
//            if(list.get(0).getAnsver3()!=null) rbtn3.setText(list.get(0).getAnsver3());
//            else rbtn3.setVisibility(View.GONE);
////
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(lvMain.getVisibility()==View.GONE) {
//                        nextQuest();
//                        //getChecked();
//                    }
//                    else selectRadio();
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
