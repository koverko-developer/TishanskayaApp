package com.example.mobiapp.tishanskayaapp.classes;

/**
 * Created by mobi app on 03.08.2017.
 */

public class Disease {
    int id;
    String name;
    String description;
    Double price;
    String textClick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTextClick() {
        return textClick;
    }

    public void setTextClick(String textClick) {
        this.textClick = textClick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
