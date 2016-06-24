package io.github.poeschl.example.javadagger;

import dagger.Lazy;

import javax.inject.Inject;
import javax.inject.Provider;

public class CoffeeMachine {

    private final Lazy<Heater> heater;
    private final Pump pump;
    private final Provider<Filter> filterProvider;


    @Inject
    CoffeeMachine(Lazy<Heater> heater, Pump pump, Provider<Filter> filterProvider) {
        this.heater = heater;
        this.pump = pump;
        this.filterProvider = filterProvider;
    }

    public void brew() {
        Heater heaterInstance = heater.get();
        heaterInstance.turnOn();
        if (heaterInstance.isHot()) {
            filterProvider.get().insert();
            pump.pump();
            System.out.println(" [_]P coffee! [_]P ");
        }
        heaterInstance.turnOff();
    }
}
