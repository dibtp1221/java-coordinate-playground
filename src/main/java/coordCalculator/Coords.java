package coordCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Coords {

    private static final int BOUND = 24;
    private final int size;
    private final ArrayList<Point> points;

    public Coords(int size, ArrayList<Point> list) {
        this.size = size;
        this.points = list;
        this.chkPointsBound();
    }

    public void chkPointsBound() {
        boolean invalid = points.stream().anyMatch(point -> point.isNotInBound(BOUND));
        if (invalid) {
            throw new InvalidInputException("입력값 범위 오류");
        }
    }

    public void chkRectangle() {
        consist4DifferentPoints();

        pointsMakesRectangle();
    }

    private void consist4DifferentPoints() {
        HashSet<Point> set = new HashSet<>(points);
        if (set.size() != 4) {
            throw new InvalidInputException("사각형 입력 무효");
        }
    }

    private void pointsMakesRectangle() {

        HashMap<Integer, Integer> countX = countX();
        HashMap<Integer, Integer> countY = countY();

        boolean XAndYOnlyTwoNumbers = countX.keySet().size() == 2 && countY.keySet().size() == 2;
        boolean eachXTwice = countX.values().stream().allMatch(v -> v == 2);
        boolean eachYTwice = countY.values().stream().allMatch(v -> v == 2);

        if (!XAndYOnlyTwoNumbers || !eachXTwice || !eachYTwice) {
            throw new InvalidInputException("사각형 입력 무효");
        }
    }

    public void printCoord() {
        for (int i=24; i>=0; i--) {
            System.out.printf("%2d|\n", i);
        }
        System.out.print("  +");
        for (int i=0; i<24; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i=0; i<=24; i+=2) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }

    public double calc() {
        if (size == 2) {
            return calcLineLength();
        }
        if (size == 4) {
            return calcArea();
        }
        return 0;
    }

    private double calcLineLength() {
        int xDiff = points.get(0).xDiff(points.get(1));
        int yDiff = points.get(0).yDiff(points.get(1));
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private int calcArea() {

        HashMap<Integer, Integer> countX = countX();
        HashMap<Integer, Integer> countY = countY();

        ArrayList<Integer> Xs = new ArrayList<>(countX.keySet());
        ArrayList<Integer> Ys = new ArrayList<>(countY.keySet());

        int width = Math.abs(Xs.get(0) - Xs.get(1));
        int height = Math.abs(Ys.get(0) - Ys.get(1));

        return width * height;
    }

    private HashMap<Integer, Integer> countY() {
        HashMap<Integer, Integer> countY = new HashMap<>();
        for (Point point : points) {
            countY.put(point.getY(), countY.getOrDefault(point.getY(), 0) + 1);
        }
        return countY;
    }

    private HashMap<Integer, Integer> countX() {
        HashMap<Integer, Integer> countX = new HashMap<>();
        for (Point point : points) {
            countX.put(point.getX(), countX.getOrDefault(point.getX(), 0) + 1);
        }
        return countX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coords coords = (Coords) o;
        return size == coords.size && Objects.equals(points, coords.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, points);
    }
}
