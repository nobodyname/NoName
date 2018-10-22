package me.unknow.noname.ui;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import me.unknow.noname.R;
import me.unknow.noname.app.App;
import me.unknow.noname.base.BaseActivity;
import me.unknow.noname.ui.zhihu.ZhihuMainFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private SparseArray<String> mSparseTags = new SparseArray<>();
    private int mNavItemId = -1;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case R.id.zhihu:
                    replaceFragment(R.id.fl_container, new ZhihuMainFragment(), mSparseTags.get(R.id.zhihu));
                    break;
                case R.id.collection:
                    break;
                case R.id.settings:
                    replaceFragment(R.id.fl_container, new SettingsFragment(), mSparseTags.get(R.id.settings));
                    break;
                default:
                    break;
            }
            mNavItemId = -1;
            return true;
        }
    });

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            showExitDialog();
        }
    }

    @Override
    protected void initViews() {
        addFragment(R.id.fl_container, new ZhihuMainFragment());
        mSparseTags.put(R.id.zhihu, "Zhihu");
        mSparseTags.put(R.id.settings, "Settings");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                if (item.isChecked()) {
                    return true;
                } else {
                    mNavItemId = item.getItemId();
                    return true;
                }
            }
        });

        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                mHandler.sendEmptyMessage(mNavItemId);
            }
        });
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出吗？");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                App.getInstance().exitApp();
            }
        });
        builder.show();
    }
}
