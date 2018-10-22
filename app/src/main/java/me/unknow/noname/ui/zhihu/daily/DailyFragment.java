package me.unknow.noname.ui.zhihu.daily;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import me.unknow.noname.R;
import me.unknow.noname.base.BaseFragment;
import me.unknow.noname.bean.DailyListBean;

public class DailyFragment extends BaseFragment<DailyPresenter> implements DailyContract.View {

    @BindView(R.id.rv_common)
    RecyclerView mRecyclerView;

    private DailyAdapter mAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.common_list;
    }

    @Override
    protected void initViews() {
        mPresenter.getData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(DailyListBean bean) {
        mAdapter = new DailyAdapter(bean.getStories());
        mAdapter.openLoadAnimation();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }
}
