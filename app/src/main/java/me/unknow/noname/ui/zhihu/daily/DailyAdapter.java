package me.unknow.noname.ui.zhihu.daily;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import me.unknow.noname.R;
import me.unknow.noname.bean.DailyListBean;
import me.unknow.noname.util.ImageLoaderUtil;
import me.unknow.noname.widget.RippleView;

public class DailyAdapter extends BaseQuickAdapter<DailyListBean.StoriesBean, BaseViewHolder> {

    DailyAdapter(@Nullable List<DailyListBean.StoriesBean> data) {
        super(R.layout.common_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyListBean.StoriesBean item) {
        ImageView icon = helper.getView(R.id.iv_icon);
        ImageLoaderUtil.loadImage(mContext, item.getImages().get(0), icon);
        helper.setText(R.id.tv_text, item.getTitle());
        RippleView rippleView = helper.getView(R.id.item_ripple);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {

            }
        });
    }
}
