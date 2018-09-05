package com.dawn.baselibapp;

import android.app.Application;
import android.content.res.Configuration;

import com.dawn.baselib.util.LogUtil;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i("===App=====>");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
