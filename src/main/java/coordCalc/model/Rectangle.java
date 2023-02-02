package coordCalc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Rectangle implements Figure {
    private final List<Point> points;
    public static final Integer RECTANGLE_POINT_SIZE = 4;

    public Rectangle(List<Point> points) {
        this.points = points;
        consist4DifferentPoints();
        pointsMakesRectangle();
    }

    @Override
    public String getName() {
        return "사각형";
    }

    @Override
    public void showArea() {
        System.out.println("사각형 넓이는 " + calcArea());
    }

    @Override
    public double calcArea() {

        HashMap<Integer, Integer> countX = countX();
        HashMap<Integer, Integer> countY = countY();

        ArrayList<Integer> Xs = new ArrayList<>(countX.keySet());
        ArrayList<Integer> Ys = new ArrayList<>(countY.keySet());

        int width = Math.abs(Xs.get(0) - Xs.get(1));
        int height = Math.abs(Ys.get(0) - Ys.get(1));

        return width * height;
    }

    private void consist4DifferentPoints() {
        HashSet<Point> set = new HashSet<>(points);
        if (set.size() != 4) {
            throw new IllegalArgumentException("사각형 입력 무효");
        }
    }

    private void pointsMakesRectangle() {

        HashMap<Integer, Integer> countX = countX();
        HashMap<Integer, Integer> countY = countY();

        boolean XAndYOnlyTwoNumbers = countX.keySet().size() == 2 && countY.keySet().size() == 2;
        boolean eachXTwice = countX.values().stream().allMatch(v -> v == 2);
        boolean eachYTwice = countY.values().stream().allMatch(v -> v == 2);

        if (!XAndYOnlyTwoNumbers || !eachXTwice || !eachYTwice) {
            throw new IllegalArgumentException("사각형 입력 무효");
        }
    }
    private HashMap<Integer, Integer> countX() {
        HashMap<Integer, Integer> countX = new HashMap<>();
        for (Point point : points) {
            countX.put(point.getX(), countX.getOrDefault(point.getX(), 0) + 1);
        }
        return countX;
    }

    private HashMap<Integer, Integer> countY() {
        HashMap<Integer, Integer> countY = new HashMap<>();
        for (Point point : points) {
            countY.put(point.getY(), countY.getOrDefault(point.getY(), 0) + 1);
        }
        return countY;
    }


}
