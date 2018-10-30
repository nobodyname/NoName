package me.unknow.noname.ui.zhihu.daily;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import me.unknow.noname.R;
import me.unknow.noname.base.BaseFragment;
import me.unknow.noname.bean.DailyListBean;
import me.unknow.noname.util.DefIconFactory;

public class DailyFragment extends BaseFragment<DailyPresenter> implements DailyContract.View {

    @BindView(R.id.rv_common)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;

    private DailyAdapter mAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.common_list;
    }

    @Override
    protected void initViews() {
        mPresenter.getData();
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getData();
            }
        });
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

            }
        });
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onRetry() {
        mPresenter.getData();
    }

    @Override
    public void showContent(DailyListBean bean) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.header_daily, null);
        SliderLayout adSlider = view.findViewById(R.id.slider_top_stories);
        initAdSlider(adSlider, bean);
        mAdapter = new DailyAdapter(bean.getStories());
        mAdapter.addHeaderView(view);
        mAdapter.openLoadAnimation();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdSlider(SliderLayout sliderLayout, DailyListBean bean) {
        for (DailyListBean.TopStoriesBean topStories : bean.getTop_stories()) {
            TextSliderView textSliderView = new TextSliderView(mContext);
            textSliderView.description(topStories.getTitle())
                    .image(topStories.getImage())
                    .empty(DefIconFactory.provideIcon())
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                        }
                    });
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
    }
}
