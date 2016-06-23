package io.github.poeschl.example.javadagger;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PumpModule {

    @Singleton
    @Provides
    Pump providePump() {
        return new SimplePump();
    }
}
