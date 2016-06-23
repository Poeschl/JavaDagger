package io.github.poeschl.example.javadagger;

/**
 * Created on 23.06.2016.
 */
public class CoffeeMachine {

    private Heater heater;
    private Pump pump;


    CoffeeMachine(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.turnOn();
        if (heater.isHot()) {
            pump.pump();
            System.out.println(" [_]P coffee! [_]P ");
        }
        heater.turnOff();
    }
}
