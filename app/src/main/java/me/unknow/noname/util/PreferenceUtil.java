package me.unknow.noname.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtil {

    public static boolean getBoolean(Context context, String tag) {
        return getBoolean(context, tag, false);
    }

    public static boolean getBoolean(Context context, String tag, boolean defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(tag, defaultValue);
    }

    public static void putBoolean(Context context, String tag, boolean value) {
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = spf.edit();
        edit.putBoolean(tag, value);
        edit.apply();
    }
}
