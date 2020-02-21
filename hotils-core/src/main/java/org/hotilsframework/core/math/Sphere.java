package org.hotilsframework.core.math;

import java.util.Objects;

/**
 * 球形
 * @author hireny
 * @className Sphere
 * @create 2020-02-21 22:44
 */
public class Sphere implements Curve {

    /**
     * 半径
     */
    private double radius;
    /**
     * 中心点
     */
    private Coordinate center;

    public Sphere() {}

    public Sphere(double radius, Coordinate center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                Objects.equals(center, sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }
}
