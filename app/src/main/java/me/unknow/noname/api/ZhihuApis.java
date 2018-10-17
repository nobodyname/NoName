package me.unknow.noname.api;

import io.reactivex.Observable;
import me.unknow.noname.bean.DailyListBean;

public interface ZhihuApis {

    Observable<DailyListBean> getDailyList();
}
