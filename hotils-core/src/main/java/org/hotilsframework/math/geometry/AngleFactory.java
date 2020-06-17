package org.hotilsframework.math.geometry;

/**
 * @author hireny
 * @className AngleFactory
 * @create 2020-02-21 22:52
 */
public class AngleFactory implements ShapeFactory, AngleCreator {
    @Override
    public Angle createAngle() {
        return new Triangle();
    }
}
