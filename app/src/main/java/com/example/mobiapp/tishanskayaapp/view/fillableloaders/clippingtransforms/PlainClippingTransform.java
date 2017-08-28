package com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms;

import android.graphics.Canvas;
import android.view.View;

/**
 * Created by mobi app on 24.08.2017.
 */

public class PlainClippingTransform implements ClippingTransform {

    @Override public void transform(Canvas canvas, float currentFillPhase, View view) {
        canvas.clipRect(0, (view.getBottom() - view.getTop()) * (1f - currentFillPhase),
                view.getRight(), view.getBottom());
    }

}
