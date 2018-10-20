package me.unknow.noname.ui.zhihu.daily;

import me.unknow.noname.R;
import me.unknow.noname.base.BaseFragment;
import me.unknow.noname.bean.DailyListBean;

public class DailyFragment extends BaseFragment<DailyPresenter> implements DailyContract.View {

    @Override
    protected int getLayoutRes() {
        return R.layout.common_item;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initInject() {
        mPresenter.getData();
    }

    @Override
    public void showContent(DailyListBean bean) {

    }
}
