package fuelInject.domain.step2;

public class K5 implements Car {
    private final String name = "K5";
    private final int mileage = 13;
    private final int distance;
    public K5(int distance) {
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
