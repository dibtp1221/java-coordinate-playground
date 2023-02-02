package coordCalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputService {

    private static final String INPUT_FORMAT_INVALID = "입력값 형식 오류";
    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값";
    private static final String DELIMITER = "-";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Point> inputCoords() {
        try {
            return inputCoords(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoords(scanner.nextLine());
        }
    }

    public static List<Point> inputCoords(String input) {
        validateInput(input);
        return parsePoints(input);
    }

    private static void validateInput(String input) {
        if (!input.matches("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}")) {
            throw new IllegalArgumentException(INPUT_FORMAT_INVALID);
        }
    }

    private static List<Point> parsePoints(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(InputService::parsePoint).collect(Collectors.toList());
    }

    private static Point parsePoint(String inputPoint) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(inputPoint);
        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
    }

}
