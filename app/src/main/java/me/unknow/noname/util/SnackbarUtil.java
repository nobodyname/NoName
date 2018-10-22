package me.unknow.noname.util;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackbarUtil {

    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackbar(View view, @StringRes int resId) {
        Snackbar.make(view, resId, Snackbar.LENGTH_SHORT).show();
    }
}
