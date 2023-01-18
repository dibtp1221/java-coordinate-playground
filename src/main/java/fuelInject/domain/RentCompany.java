package fuelInject.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final ArrayList<Car> cars = new ArrayList<>();
    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream().map(Car::report).collect(Collectors.joining(NEWLINE));
    }
}
