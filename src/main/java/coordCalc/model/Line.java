package coordCalc.model;

import java.util.List;

public class Line implements Figure {

    private final List<Point> points;

    public static final String RESULT_MSG = "선의 길이는 ";
    public static final Integer LINE_POINT_SIZE = 2;

    public Line(List<Point> points) {
        this.points = points;
    }

    @Override
    public String getName() {
        return "선";
    }

    @Override
    public void showArea() {
        System.out.println(RESULT_MSG + calcArea());
    }

    @Override
    public double calcArea() {
        int xDiff = points.get(0).xDiff(points.get(1));
        int yDiff = points.get(0).yDiff(points.get(1));
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
