package io.github.poeschl.example.javadagger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on 23.06.2016.
 */
public class CoffeeMachineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void brewHot() {
        Heater hotHeater = Mockito.mock(Heater.class);
        when(hotHeater.isHot()).thenReturn(true);

        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine hotMachine = new CoffeeMachine(hotHeater, pump);
        hotMachine.brew();

        assertEquals("[_]P coffee! [_]P", outContent.toString().trim());
        verify(hotHeater).isHot();
        verify(hotHeater).turnOff();
    }

    @Test
    public void brewCold() {
        Heater coldHeater = Mockito.mock(Heater.class);
        when(coldHeater.isHot()).thenReturn(false);

        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine coldMachine = new CoffeeMachine(coldHeater, pump);
        coldMachine.brew();

        assertEquals("", outContent.toString().trim());
        verify(coldHeater).isHot();
        verify(coldHeater).turnOff();
    }

}