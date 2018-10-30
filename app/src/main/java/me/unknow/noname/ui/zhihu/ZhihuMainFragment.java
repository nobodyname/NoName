package me.unknow.noname.ui.zhihu;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.unknow.noname.R;
import me.unknow.noname.base.BaseFragment;
import me.unknow.noname.ui.zhihu.daily.DailyFragment;
import me.unknow.noname.ui.zhihu.theme.ThemeFragment;

public class ZhihuMainFragment extends BaseFragment {

    @BindView(R.id.tab_zhihu)
    TabLayout mTabLayout;
    @BindView(R.id.vp_zhihu)
    ViewPager mViewPager;

    private ViewPagerAdapter mAdapter;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_zhihu_main;
    }

    @Override
    protected void initViews() {
        mFragments.add(new DailyFragment());
        mFragments.add(new ThemeFragment());
        mFragments.add(new SectionFragment());
        mFragments.add(new HotFragment());
        mAdapter = new ViewPagerAdapter(getChildFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;
        private String[] mTitles = new String[]{"日报", "主题", "专栏", "热门"};

        ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
