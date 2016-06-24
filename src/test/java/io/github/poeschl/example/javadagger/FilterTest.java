package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FilterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Filter filterToTest;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        filterToTest = new Filter();
    }

    @Test
    public void pump() {
        filterToTest.insert();
        assertEquals("# Insert Filter #", outContent.toString().trim());
    }

}