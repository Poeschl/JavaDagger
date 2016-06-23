package io.github.poeschl.example.javadagger;

import dagger.Lazy;

import javax.inject.Inject;

public class CoffeeMachine {

    private final Lazy<Heater> heater;
    private final Pump pump;


    @Inject
    CoffeeMachine(Lazy<Heater> heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        Heater heaterInstance = heater.get();
        heaterInstance.turnOn();
        if (heaterInstance.isHot()) {
            pump.pump();
            System.out.println(" [_]P coffee! [_]P ");
        }
        heaterInstance.turnOff();
    }
}
