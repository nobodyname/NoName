package me.unknow.noname.ui.zhihu.theme;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import me.unknow.noname.R;
import me.unknow.noname.base.BaseFragment;

public class ThemeFragment extends BaseFragment {

    @BindView(R.id.rv_common)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;

    @Override
    protected int getLayoutRes() {
        return R.layout.common_list;
    }

    @Override
    protected void initViews() {

    }
}
