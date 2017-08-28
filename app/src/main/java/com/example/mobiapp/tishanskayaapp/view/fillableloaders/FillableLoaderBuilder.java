package com.example.mobiapp.tishanskayaapp.view.fillableloaders;

/**
 * Created by mobi app on 24.08.2017.
 */

import android.content.res.Resources;
import android.view.ViewGroup;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms.ClippingTransform;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms.PlainClippingTransform;

public class FillableLoaderBuilder {



    private ViewGroup parent;
    private ViewGroup.LayoutParams params;

    private int strokeColor = -1;
    private int fillColor = -1;
    private int strokeWidth = -1;
    private int originalWidth = -1;
    private int originalHeight = -1;
    private int strokeDrawingDuration = -1;
    private int fillDuration = -1;
    private boolean percentageEnabled;
    private float percentage;
    private ClippingTransform clippingTransform;
    private String svgPath;

    public FillableLoaderBuilder parentView(ViewGroup parent) {
        this.parent = parent;
        return this;
    }

    public FillableLoaderBuilder layoutParams(ViewGroup.LayoutParams params) {
        this.params = params;
        return this;
    }

    public FillableLoaderBuilder strokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public FillableLoaderBuilder fillColor(int fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public FillableLoaderBuilder strokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public FillableLoaderBuilder originalDimensions(int originalWidth, int originalHeight) {
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
        return this;
    }

    public FillableLoaderBuilder strokeDrawingDuration(int strokeDrawingDuration) {
        this.strokeDrawingDuration = strokeDrawingDuration;
        return this;
    }

    public FillableLoaderBuilder fillDuration(int fillDuration) {
        this.fillDuration = fillDuration;
        return this;
    }

    public FillableLoaderBuilder clippingTransform(ClippingTransform transform) {
        this.clippingTransform = transform;
        return this;
    }

    public FillableLoaderBuilder svgPath(String svgPath) {
        this.svgPath = svgPath;
        return this;
    }

    public FillableLoaderBuilder percentage(float percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("percentage needs to be a value from 0 to 100");
        }
        percentageEnabled = true;
        this.percentage = percentage;
        return this;
    }

    public FillableLoader build() {
        Resources res = parent.getContext().getResources();
        strokeColor = strokeColor == -1 ? res.getColor(R.color.strokeColor) : strokeColor;
        fillColor = fillColor == -1 ? res.getColor(R.color.fillColor) : fillColor;
        strokeWidth = strokeWidth < 0 ? res.getDimensionPixelSize(R.dimen.strokeWidth) : strokeWidth;
        strokeDrawingDuration =
                strokeDrawingDuration < 0 ? res.getInteger(R.integer.strokeDrawingDuration)
                        : strokeDrawingDuration;
        fillDuration = fillDuration < 0 ? res.getInteger(R.integer.fillDuration) : fillDuration;
        clippingTransform =
                clippingTransform == null ? new PlainClippingTransform() : clippingTransform;

        if (params == null) {
            throwArgumentException("layout params");
        }

        if (svgPath == null) {
            throwArgumentException("an svg path");
        }

        return new FillableLoader(parent, params, strokeColor, fillColor, strokeWidth, originalWidth,
                originalHeight, strokeDrawingDuration, fillDuration, clippingTransform, svgPath,
                percentageEnabled, percentage);
    }

    private void throwArgumentException(String neededStuff) {
        throw new IllegalArgumentException(
                "You must provide " + neededStuff + " in order to draw the view properly.");
    }

}
