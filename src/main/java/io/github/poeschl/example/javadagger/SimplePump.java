package io.github.poeschl.example.javadagger;

public class SimplePump implements Pump {

    @Override
    public void pump() {
        System.out.println("=> => pumping => =>");
    }
}