package me.unknow.noname.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

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

    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();
}
