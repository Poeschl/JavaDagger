package io.github.poeschl.example.javadagger;

/**
 * Created on 23.06.2016.
 */
public class SimplePump implements Pump {

    @Override
    public void pump() {
        System.out.println("=> => pumping => =>");
    }
}