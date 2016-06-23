package io.github.poeschl.example.javadagger;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                HeaterModule.class,
                PumpModule.class,
                EnergyModule.class
        }
)
public interface CoffeeMachineComponent {

    final class Initializer {
        private Initializer() {
        }

        public static CoffeeMachineComponent init() {
            return DaggerCoffeeMachineComponent.builder()
                    .heaterModule(new HeaterModule())
                    .pumpModule(new PumpModule())
                    .build();
        }
    }

    CoffeeMachine coffeeMachine();
}
