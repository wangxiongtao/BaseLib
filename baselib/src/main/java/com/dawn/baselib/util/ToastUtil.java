package com.dawn.baselib.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class ToastUtil {
    private static Toast toast;
    public static  void  showShort(Context context,String msg){
        if(toast==null){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
