package me.unknow.noname.di.activity;

import dagger.Component;
import me.unknow.noname.di.app.AppComponent;
import me.unknow.noname.di.scope.ActivityScope;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {


}
