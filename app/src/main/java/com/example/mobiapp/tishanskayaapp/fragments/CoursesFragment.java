package com.example.mobiapp.tishanskayaapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.adapter.CoursesAdapter;
import com.example.mobiapp.tishanskayaapp.adapter.DiseaseAdapter;
import com.example.mobiapp.tishanskayaapp.disease.CoursesGenerate;
import com.example.mobiapp.tishanskayaapp.disease.DiseaseGenerate;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    View v;
    private CoursesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_courses, container, false);
        setRecyclerCiew();
        return v;
    }
    private void setRecyclerCiew(){
        RecyclerView recyclerDisease = (RecyclerView) v.findViewById(R.id.recyclerCourses);
        recyclerDisease.setHasFixedSize(true);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerDisease.setLayoutManager(mLayoutManager);
        // создаем адаптер
        try {
            CoursesGenerate generate = new CoursesGenerate(this.getContext());
            mAdapter = new CoursesAdapter(getDataSet(), this,generate.getAllCourses() );
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


    public void clickBuy(){

    }


}
