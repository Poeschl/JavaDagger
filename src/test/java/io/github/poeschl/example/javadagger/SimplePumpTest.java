package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SimplePumpTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private SimplePump pumpToTest;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        pumpToTest = new SimplePump();
    }

    @Test
    public void pump() {
        pumpToTest.pump();
        assertEquals("=> => pumping => =>", outContent.toString().trim());
    }

}