package com.example.mobiapp.tishanskayaapp.view.fillableloaders.svg;

/**
 * Created by mobi app on 24.08.2017.
 */

public class ConstrainedSvgPathParser extends SvgPathParser {

    private int originalWidth, originalHeight;
    private int viewWidth, viewHeight;

    private ConstrainedSvgPathParser(int originalWidth, int originalHeight, int viewWidth,
                                     int viewHeight) {
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }

    @Override protected float transformX(float x) {
        return x * viewWidth / originalWidth;
    }

    @Override protected float transformY(float y) {
        return y * viewHeight / originalHeight;
    }

    public static class Builder {

        private int originalWidth, originalHeight;
        private int viewWidth, viewHeight;

        public Builder originalWidth(int originalWidth) {
            this.originalWidth = originalWidth;
            return this;
        }

        public Builder originalHeight(int originalHeight) {
            this.originalHeight = originalHeight;
            return this;
        }

        public Builder viewWidth(int width) {
            this.viewWidth = width;
            return this;
        }

        public Builder viewHeight(int height) {
            this.viewHeight = height;
            return this;
        }

        public ConstrainedSvgPathParser build() {
            return new ConstrainedSvgPathParser(originalWidth, originalHeight, viewWidth, viewHeight);
        }
    }
}