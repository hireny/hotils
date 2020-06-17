package org.hotilsframework.math.geometry;

import org.hotilsframework.lang.FatalInstanceException;

/**
 * 几何处理
 * @author hireny
 * @className Geometrys
 * @create 2020-02-21 22:55
 */
public class Geometrys {

    private Geometrys() {
        throw new FatalInstanceException("实例化失败");
    }

    /**
     * 计算空间中两个点坐标之间的距离
     *
     * @param c1
     *      点坐标
     * @param c2
     *      点坐标
     * @return
     *      距离
     */
    public static double distance(Coordinate c1, Coordinate c2) {
        double diffX = c1.getX() - c2.getX();
        double diffY = c1.getY() - c2.getY();
        double diffZ = c1.getZ() - c2.getZ();

        double distance = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);

        return distance;
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------

    /**
     * 三角形
     */
    public static class Triangles {

        // 工具类，禁止实例化
        private Triangles() {
            throw new FatalInstanceException("实例化失败");
        }

        /**
         * 判断3条线段是否可以构成三角形
         *
         * @param a
         *      边长
         * @param b
         *      边长
         * @param c
         *      边长
         * @return
         *      能否构成三角形
         */
        public static boolean isTriangle(double a, double b, double c) {
            if (a <= 0 || b <= 0 || c <= 0) {
                return false;
            }

            boolean f1 = a + b > c;
            boolean f2 = a + c > b;
            boolean f3 = b + c > a;

            if (f1 && f2 && f3) {
                return true;
            }

            return false;
        }

        /**
         * 计算一个三角形的面积
         *
         * @param a
         *      边长
         * @param b
         *      边长
         * @param c
         *      边长
         * @return
         *      面积
         */
        public static double area(double a, double b, double c) {
            if (!isTriangle(a, b, c)) {
                throw new FatalTriangleException("三角形构建失败");
            }

            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p -a) * (p -b) * (p -c));
        }
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------

    /**
     * 圆形
     */
    public static class Circulars {

        // 工具类，禁止实例化
        private Circulars() {
            throw new FatalInstanceException("实例化失败");
        }

        /**
         * 计算一个圆形的面积
         *
         * @param r
         *      半径
         * @return
         *      面积
         * @throws ShapeException
         *      形状异常
         */
        public static double area(double r) throws ShapeException {
            if (r < 0) {
                throw new ShapeException("");
            }

            return Math.PI * r * r;
        }
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------

    /**
     * 球形
     */
    public static class Spheres {

        // 工具类，禁止实例化
        private Spheres() {
            throw new FatalInstanceException("请不要试图实例化我");
        }

        @Deprecated
        public static double area(Sphere sphere) throws ShapeException {
            if (sphere.getRadius() < 0) {
                throw new ShapeException("我不能构成一个球");
            }

            return Math.PI * sphere.getRadius() * sphere.getRadius() * sphere.getRadius();
        }
    }
}
