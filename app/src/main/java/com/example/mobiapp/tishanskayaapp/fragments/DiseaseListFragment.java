package com.example.mobiapp.tishanskayaapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.SelectActionActivity;
import com.example.mobiapp.tishanskayaapp.TestActivity;
import com.example.mobiapp.tishanskayaapp.adapter.DiseaseAdapter;
import com.example.mobiapp.tishanskayaapp.disease.DiseaseGenerate;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiseaseListFragment extends Fragment {

    View v;
    private DiseaseAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    DiseaseGenerate generate;

    public DiseaseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_disease_list, container, false);
        setRecyclerCiew();
        return v;
    }

    private void setRecyclerCiew(){

        RelativeLayout button = (RelativeLayout) v.findViewById(R.id.disease_rel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TestActivity.class));
            }
        });

        RecyclerView recyclerDisease = (RecyclerView) v.findViewById(R.id.recyclerDisease);
        recyclerDisease.setHasFixedSize(true);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerDisease.setLayoutManager(mLayoutManager);
        // создаем адаптер
        try {
            generate = new DiseaseGenerate(this.getContext());
            mAdapter = new DiseaseAdapter(getDataSet(), this,generate.getAllDisease() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        recyclerDisease.setAdapter(mAdapter);
    }

    private String[] getDataSet() {

        String[] mDataSet = new String[10];
        for (int i = 0; i < 10; i++) {
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
    }

    public void clickBuy(int position){
        Intent intent = new Intent(getActivity(), SelectActionActivity.class);
        intent.putExtra("id", position);
        startActivity(intent);
    }

}
