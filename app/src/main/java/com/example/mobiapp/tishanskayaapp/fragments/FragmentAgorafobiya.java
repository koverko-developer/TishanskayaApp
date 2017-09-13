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
public class FragmentAgorafobiya extends Fragment implements View.OnClickListener {

    TestActivity activity;
    View v;
    CardView cardView1, cardView2;
    Button btn_next;
    int position = 1;

    public FragmentAgorafobiya(TestActivity activity){

        this.activity = activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_agorafobiya, container, false);

        init();
        return  v;
    }

    private void init(){
        cardView1 = (CardView) v.findViewById(R.id.agorafobiya_card1);
        cardView1.setChecked();
        cardView1.setText(this.getResources().getString(R.string.simptom_yes));

        cardView2 = (CardView) v.findViewById(R.id.agorafobiya_card2);
        cardView2.setText(this.getResources().getString(R.string.simptom_no));

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);

        btn_next = (Button) v.findViewById(R.id.agorafobiya_btn_next);
        btn_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.agorafobiya_card1:
                reset();
                if(cardView1.check()) position = 2;
                else position = 1;
                break;
            case R.id.agorafobiya_card2:
                reset();
                if(cardView2.check()) position = 1;
                else position = 2;
                break;
            case R.id.agorafobiya_btn_next:
                next();
                break;
        }
    }
    private void reset(){
        cardView1.dontChecked();
        cardView2.dontChecked();
    }

    private void next(){
        int i = position;
        switch (position){
            case 1:
                Intent intent= new Intent(activity, DescriptionActivity.class);
                intent.putExtra("id",3);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(activity, "Возможно ваше состояние имеет какой-либо органический фактор, обратитесь пожалуйста к вашему врачу.", Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
