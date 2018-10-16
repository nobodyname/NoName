package me.unknow.noname.base;

public interface BaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载动画
     */
    void hideLoading();

    /**
     * 显示网络错误
     */
    void showNetError();
}