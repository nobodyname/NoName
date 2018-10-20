package me.unknow.noname.base;

public interface BasePresenter<T> {

    void attachView(T view);

    void detachView();
}
