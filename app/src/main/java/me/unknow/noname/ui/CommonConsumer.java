package me.unknow.noname.ui;

import io.reactivex.observers.ResourceObserver;
import me.unknow.noname.base.BaseView;

public abstract class CommonConsumer<T> extends ResourceObserver<T> {

    private BaseView mBaseView;

    public CommonConsumer(BaseView baseView) {
        this.mBaseView = baseView;
    }

    @Override
    public void onComplete() {
        if (mBaseView == null) {
            return;
        }
        mBaseView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        if (mBaseView == null) {
            return;
        }
        mBaseView.showNetError();
    }
}
