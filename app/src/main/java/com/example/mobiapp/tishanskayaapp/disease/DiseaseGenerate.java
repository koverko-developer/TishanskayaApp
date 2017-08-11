package com.example.mobiapp.tishanskayaapp.disease;

import android.content.Context;
import android.content.res.Resources;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.classes.Disease;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobi app on 04.08.2017.
 */

public class DiseaseGenerate {

    Context context;

    public DiseaseGenerate(Context context){
        this.context = context;
    }

    private Disease generatePA(){
        Disease disease = new Disease();
        disease.setId(0);
        disease.setName(context.getResources().getString(R.string.pa_name));
        disease.setDescription(context.getResources().getString(R.string.pa_descr));
        //disease.setPrice(Double.valueOf(context.getResources().getString(R.string.pa_price)));

        return disease;
    }

    private Disease generatePAA(){
        Disease disease = new Disease();
        disease.setId(1);
        disease.setName(context.getResources().getString(R.string.paa_name));
        disease.setDescription(context.getResources().getString(R.string.paa_descr));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.paa_price)));

        return disease;
    }


    private Disease generateSEX(){
        Disease disease = new Disease();
        disease.setId(2);
        disease.setName(context.getResources().getString(R.string.sex_name));
        disease.setDescription(context.getResources().getString(R.string.sex_descr));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.sex_price)));

        return disease;
    }

    private Disease generateDIPRESSIA(){
        Disease disease = new Disease();
        disease.setId(3);
        disease.setName(context.getResources().getString(R.string.depressia_name));
        disease.setDescription(context.getResources().getString(R.string.depressia_descr));
        //disease.setPrice(Double.valueOf(context.getResources().getString(R.string.depressia_price)));

        return disease;
    }

    private Disease generateMONO(){
        Disease disease = new Disease();
        disease.setId(4);
        disease.setName(context.getResources().getString(R.string.mono_name));
        disease.setDescription(context.getResources().getString(R.string.mono_descr));
        //disease.setPrice(Double.valueOf(context.getResources().getString(R.string.mono_price)));

        return disease;
    }

    public List<Disease> getAllDisease(){
        List<Disease> list = new ArrayList<>();
        list.add(generatePA());
        list.add(generatePAA());
        list.add(generateSEX());
        list.add(generateDIPRESSIA());
        list.add(generateMONO());

        return list;
    }

}
