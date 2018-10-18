package me.unknow.noname.di;

import android.content.Context;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();
}
