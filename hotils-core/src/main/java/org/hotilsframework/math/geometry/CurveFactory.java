package org.hotilsframework.math.geometry;

/**
 * @author hireny
 * @className CurveFactory
 * @create 2020-02-21 22:53
 */
public class CurveFactory implements ShapeFactory, CurveCreator {
    @Override
    public Curve createCurve() {
        return new Sphere();
    }
}
