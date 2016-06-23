package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created on 23.06.2016.
 */
public class SimpleHeaterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private SimpleHeater heaterToTest;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        heaterToTest = new SimpleHeater();
    }

    @Test
    public void turnOn() {
        heaterToTest.turnOn();
        assertEquals("~ ~ ~ heating ~ ~ ~", outContent.toString().trim());
        assertTrue("Heater should be on", heaterToTest.isHot());
    }

    @Test
    public void turnOff() {
        heaterToTest.turnOff();
        assertFalse("Heater should be cooled down", heaterToTest.isHot());
    }
}