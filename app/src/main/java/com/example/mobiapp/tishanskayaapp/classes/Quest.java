package com.example.mobiapp.tishanskayaapp.classes;

/**
 * Created by mobi app on 10.08.2017.
 */

public class Quest {

    int id;
    String title;
    String ansver1;
    String ansver2;
    int nextQuestAnswer1;
    int nextQuestAnswer2;
    int predQuest;

    public Quest(int id, String title, String ansver1, String ansver2, int nextQuestAnswer1, int nextQuestAnswer2, int predQuest) {
        this.id = id;
        this.title = title;
        this.ansver1 = ansver1;
        this.ansver2 = ansver2;
        this.nextQuestAnswer1 = nextQuestAnswer1;
        this.nextQuestAnswer2 = nextQuestAnswer2;
        this.predQuest = predQuest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnsver1() {
        return ansver1;
    }

    public void setAnsver1(String ansver1) {
        this.ansver1 = ansver1;
    }

    public String getAnsver2() {
        return ansver2;
    }

    public void setAnsver2(String ansver2) {
        this.ansver2 = ansver2;
    }

    public int getNextQuestAnswer1() {
        return nextQuestAnswer1;
    }

    public void setNextQuestAnswer1(int nextQuestAnswer1) {
        this.nextQuestAnswer1 = nextQuestAnswer1;
    }

    public int getNextQuestAnswer2() {
        return nextQuestAnswer2;
    }

    public void setNextQuestAnswer2(int nextQuestAnswer2) {
        this.nextQuestAnswer2 = nextQuestAnswer2;
    }

    public int getPredQuest() {
        return predQuest;
    }

    public void setPredQuest(int predQuest) {
        this.predQuest = predQuest;
    }
}
