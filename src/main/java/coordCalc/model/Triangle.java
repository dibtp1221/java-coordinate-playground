package coordCalc.model;

import java.util.List;

public class Triangle implements Figure {

    private final List<Point> points;
    public static final Integer TRIANGLE_POINT_SIZE = 3;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String getName() {
        return "삼각형";
    }

    @Override
    public void showArea() {
        System.out.println("삼각형 넓이는 " + calcArea());
    }

    @Override
    public double calcArea() {
        double lineA = calcLineLength(points.get(0), points.get(1));
        double lineB = calcLineLength(points.get(0), points.get(2));
        double lineC = calcLineLength(points.get(1), points.get(2));

        double v = lineA * lineA + lineB * lineB - lineC * lineC;
        return Math.sqrt((4*lineA*lineA*lineB*lineB) - v * v) / 4;
    }

    private double calcLineLength(Point p1, Point p2) {
        int xDiff = p1.xDiff(p2);
        int yDiff = p1.yDiff(p2);
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
