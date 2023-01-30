package coordinate;

import java.util.List;

public class InvalidCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
