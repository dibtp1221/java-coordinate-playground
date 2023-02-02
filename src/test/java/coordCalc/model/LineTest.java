package coordCalc.model;

import coordCalc.model.Line;
import coordCalc.model.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void calcArea() {
        Line line = new Line(Arrays.asList(new Point(1, 4), new Point(1, 5)));
        assertEquals(1, line.calcArea());
    }
}