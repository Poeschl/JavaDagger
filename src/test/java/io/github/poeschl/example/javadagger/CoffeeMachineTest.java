package io.github.poeschl.example.javadagger;

import dagger.Lazy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoffeeMachineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private Lazy<Heater> mockedLazyHeater;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void brewHot() {
        Heater hotHeater = Mockito.mock(Heater.class);
        when(hotHeater.isHot()).thenReturn(true);
        when(mockedLazyHeater.get()).thenReturn(hotHeater);

        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine hotMachine = new CoffeeMachine(mockedLazyHeater, pump);
        hotMachine.brew();

        assertEquals("[_]P coffee! [_]P", outContent.toString().trim());
        verify(hotHeater).isHot();
        verify(hotHeater).turnOff();
    }

    @Test
    public void brewCold() {
        Heater coldHeater = Mockito.mock(Heater.class);
        when(coldHeater.isHot()).thenReturn(false);
        when(mockedLazyHeater.get()).thenReturn(coldHeater);



        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine coldMachine = new CoffeeMachine(mockedLazyHeater, pump);
        coldMachine.brew();

        assertEquals("", outContent.toString().trim());
        verify(coldHeater).isHot();
        verify(coldHeater).turnOff();
    }

}