package com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms;

import android.graphics.Canvas;
import android.view.View;

/**
 * Created by mobi app on 24.08.2017.
 */

public interface ClippingTransform {

    void transform(Canvas canvas, float currentFillPhase, View view);
}
