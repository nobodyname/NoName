package me.unknow.noname.app;

import android.app.Application;

import me.unknow.noname.api.RetrofitService;
import me.unknow.noname.di.app.AppComponent;
import me.unknow.noname.di.app.AppModule;
import me.unknow.noname.di.app.DaggerAppComponent;

public class App extends Application {

    private static App sApp;

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        init();
    }

    public static App getContext() {
        return sApp;
    }

    public static AppComponent getAppComponent() {
        if (sAppComponent == null) {
            sAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(sApp))
                    .build();
        }
        return sAppComponent;
    }

    private void init() {
        RetrofitService.init();
    }
}
