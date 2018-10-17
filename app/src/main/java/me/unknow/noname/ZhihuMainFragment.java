package me.unknow.noname;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import me.unknow.noname.base.BaseFragment;

public class ZhihuMainFragment extends BaseFragment {

    @BindView(R.id.tab_zhihu)
    TabLayout mTabLayout;
    @BindView(R.id.vp_zhihu)
    ViewPager mViewPager;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_zhihu_main;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initInject() {

    }
}
