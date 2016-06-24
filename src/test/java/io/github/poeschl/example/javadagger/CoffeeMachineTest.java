package io.github.poeschl.example.javadagger;

import dagger.Lazy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Provider;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CoffeeMachineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private Lazy<Heater> mockedLazyHeater;

    @Mock
    private Provider<Filter> mockedFilterProvider;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void brewHot() {
        Heater hotHeater = Mockito.mock(Heater.class);
        Filter mockedFilter = Mockito.mock(Filter.class);
        when(hotHeater.isHot()).thenReturn(true);
        when(mockedLazyHeater.get()).thenReturn(hotHeater);
        when(mockedFilterProvider.get()).thenReturn(mockedFilter);

        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine hotMachine = new CoffeeMachine(mockedLazyHeater, pump, mockedFilterProvider);
        hotMachine.brew();

        assertEquals("[_]P coffee! [_]P", outContent.toString().trim());
        verify(hotHeater).isHot();
        verify(hotHeater).turnOff();
        verify(mockedFilter).insert();
    }

    @Test
    public void brewCold() {
        Heater coldHeater = Mockito.mock(Heater.class);
        Filter mockedFilter = Mockito.mock(Filter.class);
        when(coldHeater.isHot()).thenReturn(false);
        when(mockedLazyHeater.get()).thenReturn(coldHeater);
        when(mockedFilterProvider.get()).thenReturn(mockedFilter);

        Pump pump = Mockito.mock(Pump.class);
        CoffeeMachine coldMachine = new CoffeeMachine(mockedLazyHeater, pump, mockedFilterProvider);
        coldMachine.brew();

        assertEquals("", outContent.toString().trim());
        verify(coldHeater).isHot();
        verify(coldHeater).turnOff();
        verify(mockedFilter, never()).insert();
    }

}