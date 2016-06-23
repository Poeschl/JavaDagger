package io.github.poeschl.example.javadagger;

public class CoffeeApp {

    public static void main(String... args) {

        CoffeeMachineComponent machineComponent = DaggerCoffeeMachineComponent.Initializer.init();
        CoffeeMachine coffeeMachine = machineComponent.coffeeMachine();
        coffeeMachine.brew();
    }
}
