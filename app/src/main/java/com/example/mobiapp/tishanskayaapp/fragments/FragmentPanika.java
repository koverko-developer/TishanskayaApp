package com.example.mobiapp.tishanskayaapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.TestActivity;
import com.example.mobiapp.tishanskayaapp.view.CardView;

/**
 * Created by mobi app on 25.08.2017.
 */

@SuppressLint("ValidFragment")
public class FragmentPanika extends Fragment implements View.OnClickListener {

    TestActivity activity;
    View v;
    int position = 1;
    CardView cardView1, cardView2, cardView3;
    Button btn_next;

    public FragmentPanika(TestActivity activity) {

        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_panika, container, false);

        init();
        return v;
    }

    private void init(){
        cardView1 = (CardView) v.findViewById(R.id.panika_card1);
        cardView1.setChecked();
        cardView1.setText(this.getResources().getString(R.string.simptom1_1));

        cardView2 = (CardView) v.findViewById(R.id.panika_card2);
        cardView2.setText(this.getResources().getString(R.string.simptom1_2));

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);

        btn_next = (Button) v.findViewById(R.id.panika_btn_next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.panika_card1:
                reset();
                if(cardView1.check()) position = 2;
                else position = 1;
                break;
            case R.id.panika_card2:
                reset();
                if(cardView2.check()) position = 1;
                else position = 2;
                break;
            case R.id.panika_btn_next:
                next();
                break;
        }
    }

    private void reset(){
        cardView1.dontChecked();
        cardView2.dontChecked();
    }

    private void next(){
        switch (position){
            case 1:
                Toast.makeText(activity,"Агорафобия с паническими атаками.", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(activity,"Паническиe атаки.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
