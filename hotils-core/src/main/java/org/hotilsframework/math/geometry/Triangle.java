package org.hotilsframework.math.geometry;

import java.util.Objects;

/**
 * 三角形
 * @author hireny
 * @className Triangle
 * @create 2020-02-21 22:38
 */
public class Triangle implements Angle {
    // 三边

    private double edgeA;
    private double edgeB;
    private double edgeC;

    // 三点

    private Coordinate pointA;
    private Coordinate pointB;
    private Coordinate pointC;

    public Triangle() {
    }

    public double getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(double edgeA) {
        this.edgeA = edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(double edgeB) {
        this.edgeB = edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }

    public void setEdgeC(double edgeC) {
        this.edgeC = edgeC;
    }

    public Coordinate getPointA() {
        return pointA;
    }

    public void setPointA(Coordinate pointA) {
        this.pointA = pointA;
    }

    public Coordinate getPointB() {
        return pointB;
    }

    public void setPointB(Coordinate pointB) {
        this.pointB = pointB;
    }

    public Coordinate getPointC() {
        return pointC;
    }

    public void setPointC(Coordinate pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.edgeA, edgeA) == 0 &&
                Double.compare(triangle.edgeB, edgeB) == 0 &&
                Double.compare(triangle.edgeC, edgeC) == 0 &&
                Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeA, edgeB, edgeC, pointA, pointB, pointC);
    }
}
