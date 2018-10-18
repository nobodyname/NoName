package me.unknow.noname.api;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import me.unknow.noname.app.App;
import me.unknow.noname.util.NetworkUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    // 设置缓存有效期为1天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24;
    // 查询缓存的Cache-Control设置，为if-only-cache时查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    private static final String ZHIHU_HOST = "http://news-at.zhihu.com/api/4/";

    public static ZhihuApis mZhihuApis;

    public static void init() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // 指定缓存目录，缓存大小为 10Mb
        Cache cache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 10);
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(sReWriteCacheControlInterceptor)
                .addNetworkInterceptor(sReWriteCacheControlInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZHIHU_HOST)
                .build();
        mZhihuApis = retrofit.create(ZhihuApis.class);
    }

    /**
     * 云端相应头拦截器，用来配置缓存策略
     */
    private static final Interceptor sReWriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (NetworkUtil.isNetworkAvailable(App.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Logger.e("No network");
            }
            Response response = chain.proceed(request);

            if (NetworkUtil.isNetworkAvailable(App.getContext())) {
                // 有网的时候读接口上的@Headers里的配置，在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return response.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return response.newBuilder()
                        .header("Cache-Control", "public, " + CACHE_CONTROL_CACHE)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    // =======================================================================


}
