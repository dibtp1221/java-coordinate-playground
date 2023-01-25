package coordCalculator;

import java.util.ArrayList;
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

    public double calc() {
        if (size == 2) {
            return calcLineLength();
        }
        return 0;
    }

    private double calcLineLength() {
        int xDiff = points.get(0).xDiff(points.get(1));
        int yDiff = points.get(0).yDiff(points.get(1));
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
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
