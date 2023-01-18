package fuelInject.domain.step2;

public class Avante implements Car {
    private final String name = "Avante";
    private final int mileage = 15;
    private final int distance;
    public Avante(int distance) {
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
