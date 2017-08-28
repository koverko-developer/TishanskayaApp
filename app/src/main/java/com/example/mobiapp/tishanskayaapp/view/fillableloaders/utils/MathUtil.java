package com.example.mobiapp.tishanskayaapp.view.fillableloaders.utils;

/**
 * Created by mobi app on 24.08.2017.
 */

public class MathUtil {
    public static float constrain(float min, float max, float v) {
        return Math.max(min, Math.min(max, v));
    }
}