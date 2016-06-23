package io.github.poeschl.example.javadagger;

import javax.inject.Inject;

public class CoffeeMachine {

    private final Heater heater;
    private final Pump pump;


    @Inject
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
