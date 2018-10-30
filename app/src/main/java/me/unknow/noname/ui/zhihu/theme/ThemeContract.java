package me.unknow.noname.ui.zhihu.theme;

import me.unknow.noname.base.BasePresenter;
import me.unknow.noname.base.BaseView;
import me.unknow.noname.bean.ThemeListBean;

public interface ThemeContract {

    interface View extends BaseView {

        void showContent(ThemeListBean bean);
    }

    interface Presenter extends BasePresenter<View> {

        void getData();
    }
}
