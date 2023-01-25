package coordCalculator;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static InputParseService inputParseService = new InputParseService();

    public static void main(String[] args) {
        System.out.println("좌표를 입력하세요.");

        String input = scanner.nextLine();

        Coords coords = inputParseService.parse(input);
        coords.printCoord();
        System.out.println("두 점 사이 거리는 " + coords.calc());
    }

}
