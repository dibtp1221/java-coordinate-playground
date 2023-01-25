package coordCalculator;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String[] coord) {
        this(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
    }

    public boolean isNotInBound(int bound) {
        return x > bound || y > bound;
    }

    public int xDiff(Point p2) {
        return Math.abs(this.x - p2.x);
    }

    public int yDiff(Point p2) {
        return Math.abs(this.y - p2.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
