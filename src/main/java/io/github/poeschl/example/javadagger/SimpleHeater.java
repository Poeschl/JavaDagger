package io.github.poeschl.example.javadagger;

public class SimpleHeater implements Heater {
    private boolean heating;

    @Override
    public void turnOn() {
        System.out.println("~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    @Override
    public void turnOff() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}
