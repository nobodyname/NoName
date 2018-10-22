package me.unknow.noname.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.unknow.noname.app.App;
import me.unknow.noname.app.Constants;
import me.unknow.noname.R;
import me.unknow.noname.util.PreferenceUtil;
import me.unknow.noname.widget.EmptyLayout;

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements BaseView, EmptyLayout.OnRetryListener {

    @Inject
    protected T mPresenter;

    /**
     * 把EmptyLayout放在基类统一处理
     */
    @Nullable
    @BindView(R.id.empty_layout)
    protected EmptyLayout mEmptyLayout;

    @Nullable
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    private Unbinder mUnbinder;

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        if (PreferenceUtil.getBoolean(this, Constants.SP_BOTTOM_NAV, true)
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        mUnbinder = ButterKnife.bind(this);
        initViews();
        initInject();

        App.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    protected void initInject() {

    }

    @Override
    public void showLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
        }
    }

    @Override
    public void hideLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.hide();
        }
    }

    @Override
    public void showNetError() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
            mEmptyLayout.setOnRetryListener(this);
        }
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

    @Override
    public void onRetry() {

    }

    private void initRefreshLayout() {
        if (mRefreshLayout != null) {
            mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshLayout) {

                }
            });
        }
    }

    /**
     * 添加 Fragment
     * @param containerViewId
     * @param fragment
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(containerViewId, fragment);
        ft.commit();
    }

    /**
     * 添加 Fragment
     * @param containerViewId
     * @param fragment
     * @param tag
     */
    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 设置 tag, 不然下面的 findFragmentByTag(tag) 找不到
        ft.add(containerViewId, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    /**
     * 替换 Fragment
     * @param containerViewId
     * @param fragment
     */
    protected void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerViewId, fragment);
        //设置简单的过度动画
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(containerViewId, fragment, tag);
            //设置简单的过度动画
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            // 这里要设置tag，上面也要设置tag
            ft.addToBackStack(tag);
            ft.commit();
        } else {
            // 存在则弹出在它上面的所有 Fragment，并显示对应的 Fragment
            getSupportFragmentManager().popBackStack(tag, 0);
        }
    }
}
