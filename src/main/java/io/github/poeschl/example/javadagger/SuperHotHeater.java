package io.github.poeschl.example.javadagger;

public class SuperHotHeater implements Heater {

    private PowerPlug powerPlug;
    private boolean heating;

    public SuperHotHeater(PowerPlug powerPlug) {
        this.powerPlug = powerPlug;
    }

    @Override
    public void turnOn() {
        accessPowerPlug();

        System.out.println("~ ~ ~ heating ~ ~ ~");

        //Simulate the heating up time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //Bad catch
        }

        this.heating = true;
    }

    @Override
    public boolean isHot() {
        return heating;
    }

    @Override
    public void turnOff() {
        this.heating = false;
    }

    private void accessPowerPlug() {
        powerPlug.getEnergy();
    }
}
