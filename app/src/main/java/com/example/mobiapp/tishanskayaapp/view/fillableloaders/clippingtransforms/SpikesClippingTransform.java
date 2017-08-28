package com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms;

/**
 * Created by mobi app on 24.08.2017.
 */

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;

public class SpikesClippingTransform implements ClippingTransform {

    private int width, height;
    private Path spikesPath;

    @Override public void transform(Canvas canvas, float currentFillPhase, View view) {
        cacheDimensions(view.getWidth(), view.getHeight());
        buildClippingPath();
        spikesPath.offset(0, height * -currentFillPhase);
        canvas.clipPath(spikesPath, Region.Op.DIFFERENCE);
    }

    private void cacheDimensions(int width, int height) {
        if (this.width == 0 || this.height == 0) {
            this.width = width;
            this.height = height;
        }
    }

    private void buildClippingPath() {
        spikesPath = new Path();
        float heightDiff = width * 1f / 32;
        float widthDiff = width * 1f / 32;
        float startingHeight = height - heightDiff;

        spikesPath.moveTo(0, startingHeight);

        float nextX = widthDiff;
        float nextY = startingHeight + heightDiff;

        for (int i = 0; i < 32; i++) {
            spikesPath.lineTo(nextX, nextY);
            nextX += widthDiff;
            nextY += (i % 2 == 0) ? heightDiff : -heightDiff;
        }

        spikesPath.lineTo(width + 100, startingHeight);
        spikesPath.lineTo(width + 100, 0);
        spikesPath.lineTo(0, 0);
        spikesPath.close();
    }
}
