package me.unknow.noname.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.unknow.noname.app.App;

@Module
public class AppModule {

    private final App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    Context provideApplication() {
        return mApp.getApplicationContext();
    }
}
