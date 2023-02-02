package coordCalc.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    static Map<Integer, Class<? extends Figure>> map;
    static {
        map = new HashMap<>();
        map.put(Line.LINE_POINT_SIZE, Line.class);
        map.put(Triangle.TRIANGLE_POINT_SIZE, Triangle.class);
        map.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle.class);
    }

    public static Figure getInstance(List<Point> points) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return map.get(points.size()).getConstructor(List.class).newInstance(points);
    }
}
