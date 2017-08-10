package com.example.mobiapp.tishanskayaapp.disease;

import android.content.Context;

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

        list.add(new Quest(0, "Вопрос 1","Ответ 1", "Ответ 2", 1, 2, -1));
        list.add(new Quest(1, "Вопрос 2","Ответ 1", "Ответ 2", 2, 5, 0));
        list.add(new Quest(2, "Вопрос 3","Ответ 1", "Ответ 2", 3, 4, 1));
        list.add(new Quest(3, "Вопрос 4","Ответ 1", "Ответ 2", 5, 999,2));
        list.add(new Quest(4, "Вопрос 5","Ответ 1", "Ответ 2", 999, 999, 2));
        list.add(new Quest(5, "Вопрос 6","Ответ 1", "Ответ 2", 999, 999, 1));

        return list;
    }
}
