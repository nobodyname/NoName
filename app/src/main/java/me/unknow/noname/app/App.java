package me.unknow.noname.app;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.HashSet;
import java.util.Set;

import me.unknow.noname.api.RetrofitService;
import me.unknow.noname.di.app.AppComponent;
import me.unknow.noname.di.app.AppModule;
import me.unknow.noname.di.app.DaggerAppComponent;

public class App extends Application {

    private static App sApp;

    private static AppComponent sAppComponent;

    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        init();
    }

    public synchronized static App getInstance() {
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

    // ==================================================================

    public void addActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (allActivities != null) {
            allActivities.remove(activity);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity activity : allActivities) {
                    activity.finish();
                }
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
