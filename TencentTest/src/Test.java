import java.util.*;
import java.util.Hashtable;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    public int getMin(String str, int num) {
        int result;
        int one = getNumOfOne(str);
        int zero = getNumOfZero(str);
        if (one < zero) {
            result = zero - one;
        } else {
            result = one - zero;
        }
        return result;
    }

    public int getNumOfZero(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    public int getNumOfOne(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line1 = sc.nextLine();
            double x = Double.valueOf(line1.split(",")[0]);
            double y = Double.valueOf(line1.split(",")[1]);
            String line2 = sc.nextLine();
            List<Double> xList = new ArrayList<>();
            List<Double> yList = new ArrayList<>();
            String[] temp = line2.split(",");
            int size = temp.length;
            for (int i = 0; i < size; i++) {
                xList.add(Double.valueOf(temp[i]));
                yList.add(Double.valueOf(temp[i + 1]));
                i++;
            }
            System.out.println(measureDistance(xList, yList, x, y));
        }
    }

    /**
     * 阿里巴巴笔试的一个模拟测试
     * @param xList 横坐标列表
     * @param yList 纵坐标列表
     * @param x 横坐标
     * @param y 纵坐标
     * @return 结果字符串
     */
    private static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        StringBuilder sb = new StringBuilder();
        int distance = 0;
        boolean can = false;
        int size = xList.size();
        double[] distances = new double[size];
        if (doesPointInPolygn(xList, yList, x, y)) {
            can = true;
        } else {
            allDistance(xList, yList, x, y, distances, size);
            double min = Double.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (distances[i] < min) {
                    min = distances[i];
                }
            }
            distance = (int)min;
        }
        return can ? sb.append("yes,0").toString() : sb.append("no,").append(distance).toString();
    }

    private static void allDistance(List<Double> xList, List<Double> yList, double x, double y, double[] distances, int size) {
        for (int i = 0; i < size; i++) {
            double xTemp = Math.pow(xList.get(i) - x, 2);
            double yTemp = Math.pow(yList.get(i) - y, 2);
            distances[i] = Math.sqrt(xTemp + yTemp);
        }
    }

    private static boolean doesPointInPolygn(List<Double> xlist, List<Double> yList, double x, double y) {
        int N = xlist.size();
        /**
         * 如果顶点位于多边形的顶点或边上，也算作点在多边形内
         */
        boolean boundOrVertex = true;
        /**
         * 与点相交的边的数量
         */
        int intersectCount = 0;
        double precision = 2e-10;
        Point p1, p2;
        Point p = new Point(x, y);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point point = new Point(xlist.get(i), yList.get(i));
            points.add(point);
        }
        p1 = points.get(0);
        for (int i = 1; i <= N; i++) {
            if (p.equals(p1)) {
                return boundOrVertex;
            }

            p2 = points.get(i % N);
            if (p.getX() < Math.min(p1.getX(), p2.getX()) || p.getX() > Math.max(p1.getX(), p2.getX())) {
                p1 = p2;
                continue;
            }
            if (p.getX() > Math.min(p1.getX(), p2.getX()) && p.getX() < Math.max(p1.getX(), p2.getX())) {
                if (p.getY() <= Math.max(p1.getY(), p2.getY())) {
                    if (p1.getX() == p2.getX() && p.getY() >= Math.min(p1.getY(), p2.getY())) {
                        return boundOrVertex;
                    }
                    if (p1.getY() == p2.getY()) {
                        if (p1.getY() == p.getY()) {
                            return boundOrVertex;
                        } else {
                            ++intersectCount;
                        }
                    } else {
                        double xinters = (p.getX() - p1.getX()) * (p2.getY() - p1.getY()) / (p2.getX() - p1.getX()) + p1.getY();
                        if (Math.abs(p.getY() - xinters) < precision) {
                            return boundOrVertex;
                        }
                        if (p.getY() < xinters) {
                            ++intersectCount;
                        }
                    }
                }
            } else {
                if (p.getX() == p2.getX() && p.getY() <= p2.getY()) {
                    Point p3 = points.get((i + 1) % N);
                    if (p.getX() >= Math.min(p1.getX(), p3.getX()) && p.getX() <= Math.max(p1.getX(), p3.getX())) {
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }
        return (intersectCount & 1) == 1;
    }

}

class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;

        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}