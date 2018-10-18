package me.unknow.noname.ui.zhihu;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import me.unknow.noname.R;

public class CommonAdapter<M> extends BaseQuickAdapter<M, BaseViewHolder> {

    public CommonAdapter(@Nullable List<M> data) {
        super(R.layout.common_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, M item) {

    }
}
