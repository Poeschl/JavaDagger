package io.github.poeschl.example.javadagger;

import dagger.Module;
import dagger.Provides;

@Module
public class HeaterModule {

    @Provides
    Heater provideHeater(SuperHotHeater superHotHeater) {
        return superHotHeater;
    }

    @Provides
    SimpleHeater provideSimpleHeater() {
        return new SimpleHeater();
    }

    @Provides
    SuperHotHeater provieSuperHotHeater(PowerPlug powerPlug) {
        return new SuperHotHeater(powerPlug);
    }

}
