package me.unknow.noname.app;

import android.app.Application;
import android.content.Context;

import me.unknow.noname.api.RetrofitService;

public class App extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        init();
    }

    public static Context getContext() {
        return sContext;
    }

    private void init() {
        RetrofitService.init();
    }
}
