package com.dawn.baselibapp.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dawn.baselib.base.BaseDialog;
import com.dawn.baselibapp.R;

/**
 * Created by Administrator on 2018/3/23 0023.
 */

public class LoadingDialog extends BaseDialog {

    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.trans_Dialog);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading_layout);
    }
}
