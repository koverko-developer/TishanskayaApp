package com.example.mobiapp.tishanskayaapp.disease;

import android.content.Context;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.classes.Unwind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobi app on 10.08.2017.
 */

public class GenerateUnwind {

    Context context;

    public GenerateUnwind(Context context) {
        this.context = context;
    }

    private Unwind step1PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text1));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description1));

        return unwind;
    }
    private Unwind step2PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text2));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description2));

        return unwind;
    }
    private Unwind step3PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text3));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description3));

        return unwind;
    }
    private Unwind step4PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text4));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description4));

        return unwind;
    }
    private Unwind step5PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text5));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description5));

        return unwind;
    }
    private Unwind step6PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text6));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description6));

        return unwind;
    }
    private Unwind step7PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text7));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description7));

        return unwind;
    }
    private Unwind step8PA(){
        Unwind unwind = new Unwind();
        unwind.setName(context.getResources().getString(R.string.pa_unwind_text8));
        unwind.setDescription(context.getResources().getString(R.string.pa_unwind_description8));

        return unwind;
    }

    public List<Unwind> getAllUnwindPA(){

        List<Unwind> list = new ArrayList<>();
        list.add(step1PA());
        list.add(step2PA());
        list.add(step3PA());
        list.add(step4PA());
        list.add(step5PA());
        list.add(step6PA());
        list.add(step7PA());
        list.add(step8PA());

        return list;
    }
}
