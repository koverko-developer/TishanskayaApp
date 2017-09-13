package com.example.mobiapp.tishanskayaapp.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.DescriptionActivity;
import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.TestActivity;
import com.example.mobiapp.tishanskayaapp.view.CardView;

/**
 * Created by mobi app on 25.08.2017.
 */

@SuppressLint("ValidFragment")
public class FragmentSimptoms extends Fragment implements View.OnClickListener {

    TestActivity activity;
    View v;
    int position = 1;
    CardView cardView1, cardView2, cardView3;
    Button btn_next;

    public FragmentSimptoms(TestActivity activity){

        this.activity = activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_simptoms, container, false);

        init();
        return v;
    }

    private void init(){
        cardView1 = (CardView) v.findViewById(R.id.simptoms_card1);
        cardView1.setChecked();
        cardView1.setText(this.getResources().getString(R.string.simptom1_1));

        cardView2 = (CardView) v.findViewById(R.id.simptoms_card2);
        cardView2.setText(this.getResources().getString(R.string.simptom1_2));

        cardView3 = (CardView) v.findViewById(R.id.simptoms_card3);
        cardView3.setText(this.getResources().getString(R.string.simptom1_3));

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);

        btn_next = (Button) v.findViewById(R.id.simptoms_btn_next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simptoms_card1:
                reset();
                if(!cardView1.check()) position = 1;
                break;
            case R.id.simptoms_card2:
                reset();
                if(!cardView2.check()) position = 2;
                break;
            case R.id.simptoms_card3:
                reset();
                if(!cardView3.check()) position = 3;
                break;
            case R.id.simptoms_btn_next:
                next();
                break;
        }
    }

    private void reset(){
        cardView1.dontChecked();
        cardView2.dontChecked();
        cardView3.dontChecked();
    }

    private void next(){
        switch (position){
            case 1:
                activity.fragmentPanika();
                break;
            case 2:
                Intent intent= new Intent(activity, DescriptionActivity.class);
                intent.putExtra("id",4);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(activity,"Возможно ваше состояние имеет какой-либо органический фактор, обратитесь пожалуйста к вашему врачу.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
