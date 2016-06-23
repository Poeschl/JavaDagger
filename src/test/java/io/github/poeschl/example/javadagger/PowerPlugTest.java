package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created on 23.06.2016.
 */
public class PowerPlugTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PowerPlug plugToTest;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        plugToTest = new PowerPlug();
    }

    @Test
    public void getEnergy() {
        plugToTest.getEnergy();
        assertEquals("- - - Powering - -", outContent.toString().trim());
    }

}