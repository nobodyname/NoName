package me.unknow.noname.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import me.unknow.noname.R;
import me.unknow.noname.app.Constants;
import me.unknow.noname.util.SnackbarUtil;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_perfs);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences spf = getPreferenceScreen().getSharedPreferences();
        spf.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences spf = getPreferenceScreen().getSharedPreferences();
        spf.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (Constants.SP_BOTTOM_NAV.equals(key)) {
            SnackbarUtil.showSnackbar(getView(), R.string.bottom_nav_tint_tip);
        } else if (Constants.SP_NO_IMAGE.equals(key)) {
            if (sharedPreferences.getBoolean(Constants.SP_NO_IMAGE, false)) {
                SnackbarUtil.showSnackbar(getView(), R.string.no_image_turn_on_tip);
            } else {
                SnackbarUtil.showSnackbar(getView(), R.string.no_image_turn_off_tip);
            }
        }
    }
}
