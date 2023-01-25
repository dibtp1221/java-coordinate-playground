package coordCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParseServiceTest {

    @Test
    void test() {
        String input = "(10,10)-(14,15)";
        InputParseService inputParseService = new InputParseService();
        Coords coords = inputParseService.parse(input);
        Assertions.assertEquals(
                new Coords(2, new ArrayList<>(Arrays.asList(new Point(10, 10), new Point(14, 15)))),
                coords);

        input = "(10,10)-(14,";
        String finalInput = input;
        Assertions.assertThrows(UnsupportedOperationException.class, () -> inputParseService.parse(finalInput));

        input = "(10,10)-(14,)";
        String finalInput2 = input;
        Assertions.assertThrows(UnsupportedOperationException.class, () -> inputParseService.parse(finalInput2));

        input = "(10,a)-";
        String finalInput3 = input;
        Assertions.assertThrows(UnsupportedOperationException.class, () -> inputParseService.parse(finalInput3));

        input = "(10)";
        String finalInput4 = input;
        Assertions.assertThrows(UnsupportedOperationException.class, () -> inputParseService.parse(finalInput4));

        input = "(10,10)-(14,30)";
        String finalInput5 = input;
        Assertions.assertThrows(InvalidInputException.class, () -> inputParseService.parse(finalInput5));
    }
}
