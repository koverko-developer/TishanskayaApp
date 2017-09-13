package com.example.mobiapp.tishanskayaapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.TestActivity;
import com.example.mobiapp.tishanskayaapp.view.DiseaseView;

/**
 * Created by mobi app on 24.08.2017.
 */

@SuppressLint("ValidFragment")
public class FragmentSelectDisease extends Fragment implements View.OnClickListener {

    View v;
    DiseaseView view1, view2, view3,view4,view5,view6,view7,view8,view9,view10,view11,view12;
    TextView tv_col;
    int count = 0;
    Button btn_next;

    TestActivity activity;

    public FragmentSelectDisease(TestActivity activity){
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.ffragment_select_disease, container, false);

        init();

        return v;
    }

    private void init(){
        view1 = (DiseaseView) v.findViewById(R.id.view1);
        view1.setImage(R.drawable.telka6);
        view1.setText("Сложно сделать глубокий вдох или выдох.");

        view2 = (DiseaseView) v.findViewById(R.id.view2);
        view2.setText("Головокружение, непостоянство ощущений или усталость.");

        view3 = (DiseaseView) v.findViewById(R.id.view3);
        view3.setImage(R.drawable.telka9);
        view3.setText("Усиление скорости сердечных сокращений (тахикардия).");

        view4 = (DiseaseView) v.findViewById(R.id.view4);
        view4.setImage(R.drawable.telka4);
        view4.setText("Дрожание или покачивание.");

        view5 = (DiseaseView) v.findViewById(R.id.view5);
        view5.setImage(R.drawable.telka2);
        view5.setText("Потливость.");

        view6 = (DiseaseView) v.findViewById(R.id.view6);
        view6.setImage(R.drawable.telka7);
        view6.setText("Удушье.");

        view7 = (DiseaseView) v.findViewById(R.id.view7);
        view7.setImage(R.drawable.telka8);
        view7.setText("Тошнота или дискомфорт в желудке.");

        view8 = (DiseaseView) v.findViewById(R.id.view8);
        view8.setImage(R.drawable.telka10);
        view8.setText("Непонимание кто я и где я нахожусь в настоящее время.");

        view9 = (DiseaseView) v.findViewById(R.id.view9);
        view9.setImage(R.drawable.telka11);
        view9.setText("Онемение или покалывание.");

        view10 = (DiseaseView) v.findViewById(R.id.view10);
        view10.setImage(R.drawable.telka5);
        view10.setText("Покраснение (отсутствие покраснения лица), гусиная кожа.");

        view11 = (DiseaseView) v.findViewById(R.id.view11);
        view11.setImage(R.drawable.telka12);
        view11.setText("Боль или дискомфорт в груди.");

        view12 = (DiseaseView) v.findViewById(R.id.view12);
        view12.setImage(R.drawable.telka3);
        view12.setText("Страх смерти.");

        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
        view7.setOnClickListener(this);
        view8.setOnClickListener(this);
        view9.setOnClickListener(this);
        view10.setOnClickListener(this);
        view11.setOnClickListener(this);
        view12.setOnClickListener(this);

        btn_next = (Button) v.findViewById(R.id.description_btn);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>0) {
                    if(count>4)activity.fragmentSimptoms();
                    else activity.fragmentAgorafobiya();
                }
                else Toast.makeText(v.getContext(), v.getResources().getString(R.string.toast_error_test), Toast.LENGTH_SHORT).show();
            }
        });

        tv_col = (TextView) v.findViewById(R.id.tv_col_simptoms);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view1:
                counter(view1.check());
                break;
            case R.id.view2:
                counter(view2.check());
                break;
            case R.id.view3:
                counter(view3.check());
                break;
            case R.id.view4:
                counter(view4.check());
                break;
            case R.id.view5:
                counter(view5.check());
                break;
            case R.id.view6:
                counter(view6.check());
                break;
            case R.id.view7:
                counter(view7.check());
                break;
            case R.id.view8:
                counter(view8.check());
                break;
            case R.id.view9:
                counter(view9.check());
                break;
            case R.id.view10:
                counter(view10.check());
                break;
            case R.id.view11:
                counter(view11.check());
                break;
            case R.id.view12:
                counter(view12.check());
                break;

        }
    }

    private void counter(boolean b){
        if(b) count++;
        else count--;

        tv_col.setText(count+" из 12");
    }
}
