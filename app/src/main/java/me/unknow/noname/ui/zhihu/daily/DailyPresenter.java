package me.unknow.noname.ui.zhihu.daily;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import me.unknow.noname.api.RetrofitService;
import me.unknow.noname.base.BasePresenterImpl;
import me.unknow.noname.bean.DailyListBean;
import me.unknow.noname.util.RxUtil;

public class DailyPresenter extends BasePresenterImpl<DailyContract.View> implements DailyContract.Presenter {

    @Inject
    public DailyPresenter() {}

    @Override
    public void getData() {
        RetrofitService.mZhihuApis.getDailyList()
                .compose(RxUtil.<DailyListBean>rxSchedulerHelper())
                .compose(mView.<DailyListBean>bindToLife())
                .subscribe(new Consumer<DailyListBean>() {
                    @Override
                    public void accept(DailyListBean bean) throws Exception {
                        mView.showContent(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
