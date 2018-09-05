package com.dawn.baselibapp.base;

import android.app.Dialog;
import android.os.Bundle;

import com.dawn.baselib.base.BaseActivity;
import com.dawn.baselib.base.BaseDialog;
import com.dawn.baselibapp.view.dialog.LoadingDialog;

/**
 * Created by Administrator on 2018/3/23 0023.
 */

public abstract class OHBaseActivity extends BaseActivity {
    @Override
    public BaseDialog getLoadDialog() {
        return new LoadingDialog(this);
    }

}
