package io.github.poeschl.example.javadagger;

import dagger.Module;
import dagger.Provides;

@Module
public class HeaterModule {

    @Provides
    Heater provideHeater(SimpleHeater simpleHeater) {
        return simpleHeater;
    }

    @Provides
    SimpleHeater provideSimpleHeater() {
        return new SimpleHeater();
    }

}
