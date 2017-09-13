package com.example.mobiapp.tishanskayaapp.classes;

/**
 * Created by mobi app on 12.09.2017.
 */

public class Note {

    int id;
    public String dat;
    public String time;
    public String text;

    public Note(int id, String dat, String time, String text) {
        this.id = id;
        this.dat = dat;
        this.time = time;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
