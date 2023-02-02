package coordCalc.view;

import coordCalc.model.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputServiceTest {

    @Test
    void inputCoords() {
        List<Point> points = InputService.inputCoords("(10,10)-(14,15)");
        Assertions.assertThat(points).containsOnly(new Point(10, 10), new Point(14, 15));
    }

    @Test
    void chkPointBound() {
        assertThrows(IllegalArgumentException.class, () -> InputService.chkPointBound(new Point(25, 10)));
    }
}