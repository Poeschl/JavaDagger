package io.github.poeschl.example.javadagger;

import dagger.Module;
import dagger.Provides;

@Module
public class EnergyModule {

    @Provides
    PowerPlug providePowerPlug() {
        return new PowerPlug();
    }
}
