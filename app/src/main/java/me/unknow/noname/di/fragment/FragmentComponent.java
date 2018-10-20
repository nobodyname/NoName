package me.unknow.noname.di.fragment;

import dagger.Component;
import me.unknow.noname.di.app.AppComponent;
import me.unknow.noname.di.scope.FragmentScope;
import me.unknow.noname.ui.zhihu.daily.DailyFragment;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(DailyFragment fragment);
}
