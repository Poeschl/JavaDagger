package io.github.poeschl.example.javadagger;

import dagger.Module;
import dagger.Provides;

@Module
public class FilterModule {

    @Provides
    Filter provideFilter() {
        return new Filter();
    }
}
