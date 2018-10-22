package me.unknow.noname.api;

import io.reactivex.Observable;
import me.unknow.noname.bean.DailyListBean;
import retrofit2.http.GET;

public interface ZhihuApis {

    /**
     * 最新日报
     * @return
     */
    @GET("news/latest")
    Observable<DailyListBean> getDailyList();
}
