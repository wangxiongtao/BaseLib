package com.dawn.baselib.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dawn.baselib.R;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class SharePreUtil {
    private static SharedPreferences preferences;
    private static void init(Context context) {
        if (null == preferences) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static String getString(Context context, String key, final String defaultValue) {
        init(context);
      
        return preferences.getString(key, defaultValue);
    }

    public static void setString(Context context, final String key, final String value) {
        init(context);
        preferences.edit().putString(key, value).apply();
    }

    public static boolean getBoolean(Context context, final String key, final boolean defaultValue) {
        init(context);
       return preferences.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(Context context, final String key) {
        init(context);
        return preferences.contains(key);
    }

    public static void setBoolean(Context context, final String key, final boolean value) {
        init(context);
         preferences.edit().putBoolean(key, value).apply();
    }

    public static void setInt(Context context, final String key, final int value) {
        init(context);
         preferences.edit().putInt(key, value).apply();
    }

    public static int getInt(Context context, final String key, final int defaultValue) {
        init(context);
        return preferences.getInt(key, defaultValue);
    }

    public static void setFloat(Context context, final String key, final float value) {
        init(context);
         preferences.edit().putFloat(key, value).apply();
    }

    public static float getFloat(Context context, final String key, final float defaultValue) {
        init(context);
        return preferences.getFloat(key, defaultValue);
    }

    public static void setLong(Context context, final String key, final long value) {
        init(context);
         preferences.edit().putLong(key, value).apply();
    }

    public static long getLong(Context context, final String key, final long defaultValue) {
        init(context);
        return preferences.getLong(key, defaultValue);
    }
}

