package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    static Map<Integer, FigureCreator> map;
    static {
        map = new HashMap<>();
        map.put(Line.LINE_POINT_SIZE, new LineCreator());
        map.put(Triangle.TRIANGLE_POINT_SIZE, new TriangleCreator());
        map.put(Rectangle.RECTANGLE_POINT_SIZE, new RectangleCreator());
    }

    static Figure getInstance(List<Point> points) {
        return map.getOrDefault(points.size(), new InvalidCreator()).create(points);
    }
}
