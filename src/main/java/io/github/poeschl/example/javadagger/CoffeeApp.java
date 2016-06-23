package io.github.poeschl.example.javadagger;

/**
 * Created on 23.06.2016.
 */
public class CoffeeApp {

    public static void main(String... args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine(new SimpleHeater(), new SimplePump());
        coffeeMachine.brew();
    }
}
