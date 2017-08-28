package com.example.mobiapp.tishanskayaapp.disease;

import android.content.Context;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.classes.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobi app on 10.08.2017.
 */

public class GenerateQuest {

    Context context;

    public GenerateQuest(Context context) {
        this.context = context;
    }

    public List<Quest> questsPA(){
        List<Quest> list = new ArrayList<>();

        list.add(new Quest(0, context.getResources().getString(R.string.simptom1),
                context.getResources().getString(R.string.simptom1_1),
                context.getResources().getString(R.string.simptom1_2),
                context.getResources().getString(R.string.simptom1_3),1, 203,202, -1));

        list.add(new Quest(1, context.getResources().getString(R.string.simptom2),
                context.getResources().getString(R.string.simptom_yes),
                context.getResources().getString(R.string.simptom_no),null,201, 202,0, 0));

        list.add(new Quest(2, context.getResources().getString(R.string.simptom3),
                context.getResources().getString(R.string.simptom_yes),
                context.getResources().getString(R.string.simptom_no),
                null,0, 0,0, -1));

//        list.add(new Quest(0, context.getResources().getString(R.string.simptom1),
//                context.getResources().getString(R.string.simptom1_1),
//                context.getResources().getString(R.string.simptom1_2),
//                context.getResources().getString(R.string.simptom1_3),0, 0,0, -1));


        return list;
    }
}
