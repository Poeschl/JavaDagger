package io.github.poeschl.example.javadagger;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                HeaterModule.class,
                PumpModule.class,
                EnergyModule.class,
                FilterModule.class
        }
)
public interface CoffeeMachineComponent {

    CoffeeMachine coffeeMachine();

    final class Initializer {

        private Initializer() {
        }

        public static CoffeeMachineComponent init() {
            return DaggerCoffeeMachineComponent.builder()
                    .heaterModule(new HeaterModule())
                    .pumpModule(new PumpModule())
                    .energyModule(new EnergyModule())
                    .filterModule(new FilterModule())
                    .build();
        }
    }
}
