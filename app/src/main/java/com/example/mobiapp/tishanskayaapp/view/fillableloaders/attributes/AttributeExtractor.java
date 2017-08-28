package com.example.mobiapp.tishanskayaapp.view.fillableloaders.attributes;

import com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms.ClippingTransform;

/**
 * Created by mobi app on 24.08.2017.
 */

public interface AttributeExtractor {

    int getStrokeColor();

    int getFillColor();

    int getStrokeWidth();

    int getOriginalWidth();

    int getOriginalHeight();

    int getStrokeDrawingDuration();

    int getFillDuration();

    ClippingTransform getClippingTransform();

    void recycleAttributes();

    void release();
}
