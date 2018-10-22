package me.unknow.noname.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import me.unknow.noname.app.Constants;

public class ImageLoaderUtil {

    private ImageLoaderUtil() {
        throw new RuntimeException("ImageLoaderUtil cannot be initialized");
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        if (!PreferenceUtil.getBoolean(context, Constants.SP_NO_IMAGE, false) ||
                NetworkUtil.isWifiConnected(context)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RequestOptions options = new RequestOptions()
                    .placeholder(DefIconFactory.provideIcon())
                    .fitCenter();
            Glide.with(context).load(url).apply(options).into(imageView);
        } else {
            imageView.setImageResource(DefIconFactory.provideIcon());
        }
    }


}
