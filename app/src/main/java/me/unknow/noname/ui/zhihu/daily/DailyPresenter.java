package me.unknow.noname.ui.zhihu.daily;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import me.unknow.noname.api.RetrofitService;
import me.unknow.noname.bean.DailyListBean;
import me.unknow.noname.util.RxUtil;

public class DailyPresenter implements DailyContract.Presenter {

    private DailyContract.View mView;

    @Inject
    public DailyPresenter(DailyContract.View view) {
        mView = view;
    }

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
                });
    }
}
