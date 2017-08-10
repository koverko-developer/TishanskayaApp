package com.example.mobiapp.tishanskayaapp.disease;

import android.content.Context;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.classes.Disease;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobi app on 09.08.2017.
 */

public class CoursesGenerate {

    Context context;

    public CoursesGenerate(Context context) {
        this.context = context;
    }

    private Disease generateCourse1(){
        Disease disease = new Disease();

        disease.setName(context.getResources().getString(R.string.trening_1_name));
        disease.setDescription(context.getResources().getString(R.string.trening_1_description));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.trening_1_price)));

        return disease;
    }

    private Disease generateCourse2(){
        Disease disease = new Disease();

        disease.setName(context.getResources().getString(R.string.trening_2_name));
        disease.setDescription(context.getResources().getString(R.string.trening_2_description));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.trening_2_price)));

        return disease;
    }

    private Disease generateCourse3(){
        Disease disease = new Disease();

        disease.setName(context.getResources().getString(R.string.trening_3_name));
        disease.setDescription(context.getResources().getString(R.string.trening_3_description));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.trening_3_price)));

        return disease;
    }

    private Disease generateCourse4(){
        Disease disease = new Disease();

        disease.setName(context.getResources().getString(R.string.trening_4_name));
        disease.setDescription(context.getResources().getString(R.string.trening_4_description));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.trening_4_price)));

        return disease;
    }

    private Disease generateCourse5(){
        Disease disease = new Disease();

        disease.setName(context.getResources().getString(R.string.trening_5_name));
        disease.setDescription(context.getResources().getString(R.string.trening_5_description));
        disease.setPrice(Double.valueOf(context.getResources().getString(R.string.trening_5_price)));

        return disease;
    }

    public List<Disease> getAllCourses(){
        List<Disease> list = new ArrayList<>();
        list.add(generateCourse1());
        list.add(generateCourse2());
        list.add(generateCourse3());
        list.add(generateCourse4());
        list.add(generateCourse5());
        return list;
    }
}
