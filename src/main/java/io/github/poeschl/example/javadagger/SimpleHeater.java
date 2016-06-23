package io.github.poeschl.example.javadagger;

/**
 * Created on 23.06.2016.
 */
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
