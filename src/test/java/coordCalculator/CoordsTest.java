package coordCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoordsTest {

    @Test
    void chkPointsBound() {
        Assertions.assertThrows(InvalidInputException.class,
                () -> new Coords(2, new ArrayList<>(Arrays.asList(new Point(10, 10), new Point(26, 15)))));
    }

    @Test
    void calc() {
        Coords coords = new Coords(2, new ArrayList<>(Arrays.asList(new Point(10, 10), new Point(14, 15))));
        assertEquals(6.403, coords.calc(), 0.001);
    }
}