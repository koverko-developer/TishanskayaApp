package com.example.mobiapp.tishanskayaapp.adapter;

/**
 * Created by mobi app on 09.08.2017.
 */

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.classes.Disease;
import com.example.mobiapp.tishanskayaapp.fragments.CoursesFragment;
import com.example.mobiapp.tishanskayaapp.fragments.DiseaseListFragment;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> implements View.OnClickListener {

    private String[] mDataset;
    List<Disease> list;

    CoursesFragment fragment;
    Bitmap bitmap ;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView tvPrice,tvBuy, tvName, tvDescr;
        public ImageView img;

        public ViewHolder(View v) {
            super(v);
            tvPrice = (TextView) v.findViewById(R.id.card_Price);
            tvBuy = (TextView) v.findViewById(R.id.card_buy);
            tvName = (TextView) v.findViewById(R.id.card_name);
            tvDescr = (TextView) v.findViewById(R.id.card_descr);

        }
    }

    // Конструктор
    public CoursesAdapter(String[] dataset, CoursesFragment fragment, List<Disease> list) {
        mDataset = dataset;
        this.fragment = fragment;
        this.list = list;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_disease, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        //ViewHolder vh = new ViewHolder(v);
        return new ViewHolder(v);
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            //holder.mTextView.setText(mDataset[position]);
            if(list.get(position).getPrice()!=null){
                holder.tvPrice.setText(String.valueOf(list.get(position).getPrice()) + " $");
                holder.tvBuy.setText(fragment.getResources().getString(R.string.buy_course));
            }else {
                holder.tvBuy.setText(fragment.getResources().getString(R.string.description_course));
                holder.tvPrice.setText(fragment.getResources().getString(R.string.free));
            }

            holder.tvDescr.setText(list.get(position).getDescription());
            holder.tvName.setText(list.get(position).getName());
            holder.tvBuy.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return list.size();
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

