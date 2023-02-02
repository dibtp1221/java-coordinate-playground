package coordCalc.model;

import coordCalc.model.Point;
import coordCalc.model.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void calcArea() {
        Rectangle rectangle = new Rectangle(Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(14, 10), new Point(10, 15)));
        assertEquals(20, rectangle.calcArea());
    }
}