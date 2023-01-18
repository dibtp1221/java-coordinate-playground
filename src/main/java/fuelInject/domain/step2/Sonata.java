package fuelInject.domain.step2;

public class Sonata implements Car {
    private final String name = "Sonata";
    private final int mileage = 10;
    private final int distance;
    public Sonata(int distance) {
        this.distance = distance;
    }

    @Override
    public int getFuelToPut() {
        return distance / mileage;
    }

    @Override
    public String report() {
        return name + " : " + getFuelToPut() + "리터";
    }

}
