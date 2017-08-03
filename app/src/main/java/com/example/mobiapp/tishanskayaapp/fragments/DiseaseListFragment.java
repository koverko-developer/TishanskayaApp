package com.example.mobiapp.tishanskayaapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.adapter.DiseaseAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiseaseListFragment extends Fragment {

    View v;
    private DiseaseAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        RecyclerView recyclerDisease = (RecyclerView) v.findViewById(R.id.recyclerDisease);
        recyclerDisease.setHasFixedSize(true);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerDisease.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new DiseaseAdapter(getDataSet(), this);
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
        Toast.makeText(this.getActivity(), "click buy", Toast.LENGTH_SHORT).show();
    }

}
