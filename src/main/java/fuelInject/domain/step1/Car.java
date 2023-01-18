package fuelInject.domain.step1;

public abstract class Car {

    private final String name;
    private final int mileage;
    private final int distance;
    public Car(String name, int mileage, int distance) {
        this.name = name;
        this.mileage = mileage;
        this.distance = distance;
    }

    private int fuelToPut() {
        return distance / mileage;
    }

    public String report() {
        return name + " : " + fuelToPut() + "리터";
    }
}
