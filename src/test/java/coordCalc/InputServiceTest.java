package coordCalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputServiceTest {

    @Test
    void inputCoords() {
        List<Point> points = InputService.inputCoords("(10,10)-(14,15)");
        Assertions.assertThat(points).containsOnly(new Point(10, 10), new Point(14, 15));
    }

}