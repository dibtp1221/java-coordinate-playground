package coordCalc.model;

import coordCalc.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FigureFactoryTest {
    @Test
    public void line() throws Exception {
        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(2, 3));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Line.class);
        assertThat(figure.getName()).isEqualTo("선");
    }

    @Test
    public void triangle() throws Exception {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(4, 1),
                new Point(1, 4));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Triangle.class);
        assertThat(figure.getName()).isEqualTo("삼각형");
    }

    @Test
    public void rectangle() throws Exception {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(4, 1),
                new Point(1, 4),
                new Point(4, 4));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Rectangle.class);
        assertThat(figure.getName()).isEqualTo("사각형");
    }
}