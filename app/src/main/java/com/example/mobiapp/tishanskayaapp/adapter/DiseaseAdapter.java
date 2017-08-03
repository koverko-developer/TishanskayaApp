package com.example.mobiapp.tishanskayaapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.fragments.DiseaseListFragment;

/**
 * Created by mobi app on 03.08.2017.
 */
public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.ViewHolder> implements View.OnClickListener {

    private String[] mDataset;

    DiseaseListFragment fragment;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView tvPrice,tvBuy;

        public ViewHolder(View v) {
            super(v);
            tvPrice = (TextView) v.findViewById(R.id.card_Price);
            tvBuy = (TextView) v.findViewById(R.id.card_buy);

        }
    }

    // Конструктор
    public DiseaseAdapter(String[] dataset, DiseaseListFragment fragment) {
        mDataset = dataset;
        this.fragment = fragment;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public DiseaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_disease, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //holder.mTextView.setText(mDataset[position]);
        holder.tvBuy.setOnClickListener(this);

    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_buy:
                fragment.clickBuy();
                break;
        }
    }

}
