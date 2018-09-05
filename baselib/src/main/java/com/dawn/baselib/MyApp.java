package com.dawn.baselib;

import android.app.Application;

import com.dawn.baselib.util.LogUtil;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i("===MyApp=====>");
    }
}
