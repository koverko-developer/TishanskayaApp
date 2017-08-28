package com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms;

/**
 * Created by mobi app on 24.08.2017.
 */

public class TransformFactoryImpl implements TransformAbstractFactory {

    @Override public ClippingTransform getClippingTransformFor(int value) {
        switch (value) {
            case FillMode.PLAIN:
                return new PlainClippingTransform();
            case FillMode.SPIKES:
                return new SpikesClippingTransform();
            case FillMode.ROUNDED:
                return new RoundedClippingTransform();
            case FillMode.SQUARES:
                return new SquareClippingTransform();
            case FillMode.BITES:
                return new BitesClippingTransform();
            default:
                return new WavesClippingTransform();
        }
    }
}
