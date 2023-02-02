package coordCalc.model;

import coordCalc.model.Point;
import coordCalc.model.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void calcArea() {
        Triangle triangle = new Triangle(Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8)));
        assertEquals(29.0, triangle.calcArea(), 0.1);
    }
}