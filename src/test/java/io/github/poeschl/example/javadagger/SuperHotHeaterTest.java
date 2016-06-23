package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SuperHotHeaterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void turnOn() {
        PowerPlug mockedPlug = Mockito.mock(PowerPlug.class);
        SuperHotHeater heaterToTest = new SuperHotHeater(mockedPlug);

        heaterToTest.turnOn();
        assertEquals("~ ~ ~ heating ~ ~ ~", outContent.toString().trim());
        assertTrue("Heater should be on", heaterToTest.isHot());
        verify(mockedPlug).getEnergy();
    }

    @Test
    public void turnOff() {
        SuperHotHeater heaterToTest = new SuperHotHeater(Mockito.mock(PowerPlug.class));

        heaterToTest.turnOff();
        assertFalse("Heater should be cooled down", heaterToTest.isHot());
    }
}
