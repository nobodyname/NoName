package me.unknow.noname.ui.zhihu.daily;

import me.unknow.noname.base.BasePresenter;
import me.unknow.noname.base.BaseView;
import me.unknow.noname.bean.DailyListBean;

public interface DailyContract {

    interface View extends BaseView {

        void showContent(DailyListBean bean);
    }

    interface Presenter extends BasePresenter<View> {

        void getData();
    }
}
