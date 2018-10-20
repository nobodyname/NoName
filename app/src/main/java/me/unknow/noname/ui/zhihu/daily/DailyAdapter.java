package me.unknow.noname.ui.zhihu.daily;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import me.unknow.noname.R;
import me.unknow.noname.bean.DailyListBean;

public class DailyAdapter extends BaseQuickAdapter<DailyListBean.StoriesBean, BaseViewHolder> {

    public DailyAdapter(@Nullable List<DailyListBean.StoriesBean> data) {
        super(R.layout.common_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyListBean.StoriesBean item) {
        helper.setText(R.id.tv_item_text, item.getTitle());
    }
}
