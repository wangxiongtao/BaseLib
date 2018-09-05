package com.dawn.baselib.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public abstract class BaseDialog extends Dialog{
    private Context context;


    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context=context;
    }

    @Override
    public void show() {
        if(isShowing()){
           return;
        }
        super.show();
    }

    @Override
    public void dismiss() {
        if(context instanceof Activity){
            Activity activity= (Activity)context;
            if(activity.isFinishing()&&!isShowing()){
                return;
            }
            super.dismiss();
        }

    }
}
