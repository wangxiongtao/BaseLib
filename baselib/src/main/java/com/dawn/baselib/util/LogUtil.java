package com.dawn.baselib.util;

import android.util.Log;

import com.dawn.baselib.BuildConfig;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class LogUtil {
    private static final  String TAG="OH";
    private static boolean DEBUG= BuildConfig.DEBUG;
    public static void  i(String msg){
        if(DEBUG){
            Log.i(TAG, msg);
        }

    }

}
