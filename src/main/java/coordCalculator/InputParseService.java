package coordCalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParseService {

    public Coords parse(String input) {
        try {
            String[] coords = input.split("-");

            ArrayList<Point> points = new ArrayList<>();
            Arrays.stream(coords).forEach(coord -> points.add(new Point(coord.substring(1, coord.length() - 1).split(","))));

            return new Coords(coords.length, points);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw new UnsupportedOperationException("입력 유효하지 않음");
        }
    }

}
