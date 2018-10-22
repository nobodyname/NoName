package me.unknow.noname.ui.zhihu.daily;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.observers.ResourceObserver;
import me.unknow.noname.api.RetrofitService;
import me.unknow.noname.base.BasePresenterImpl;
import me.unknow.noname.bean.DailyListBean;
import me.unknow.noname.ui.CommonConsumer;
import me.unknow.noname.util.RxUtil;

public class DailyPresenter extends BasePresenterImpl<DailyContract.View> implements DailyContract.Presenter {

    @Inject
    public DailyPresenter() {}

    @Override
    public void getData() {
        RetrofitService.mZhihuApis.getDailyList()
                .compose(RxUtil.<DailyListBean>rxSchedulerHelper())
                .compose(mView.<DailyListBean>bindToLife())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showLoading();
                    }
                })
                .subscribeWith(new CommonConsumer<DailyListBean>(mView) {
                    @Override
                    public void onNext(DailyListBean bean) {
                        if (bean != null) {
                            mView.showContent(bean);
                        } else {
                            mView.showNetError();
                        }
                    }
                });
    }
}
