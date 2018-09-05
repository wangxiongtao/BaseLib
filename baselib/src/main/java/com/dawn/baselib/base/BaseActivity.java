package com.dawn.baselib.base;

import android.app.ProgressDialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.dawn.baselib.R;
import com.dawn.baselib.mvp.IView;
import com.dawn.baselib.util.StatusBarUtil;
import com.dawn.baselib.util.ToastUtil;


/**
 * 基类Activity 定义了Activity中的常用方法
 * 封装了公共的Toolbar 的初始化，
 * 布局文件初始化
 */

public abstract class BaseActivity extends AppCompatActivity implements IView {
    private ViewGroup mRootLayout;
    protected TextView mBaseTitleTv;
    protected TextView mBaseRightTv;
    protected View mToolbar_line_Txt;
    protected Toolbar mToolbar;
//    private EmptyView mEmptyView;
    protected BasePresenter presenter;
    private ProgressDialog dialog;
    private BaseDialog loadDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        if (getLayoutId() > 0) {

            initPresenter();
            setContentView(getLayoutId());
            initToolbar();
//            initEmptyView();
            initView(savedInstanceState);
            setListener();
            initData();
//            StatusBarUtil.setStatusbarColor(this, getResources().getColor(R.color.white));
            StatusBarUtil.setStatusbarColor(this, getResources().getColor(R.color.red));
//            StatusBarUtil.setContentToStatusbar(this);
        }


    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (mToolbar == null) {
            return;
        }
        mBaseTitleTv = (TextView) findViewById(R.id.include_toolbar_title_txt);
        mBaseRightTv = (TextView) findViewById(R.id.include_toolbar_right_txt);
        mToolbar_line_Txt = findViewById(R.id.include_toolbar_line_view);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                onBackPressed();
            }
        });

    }
    protected abstract int getLayoutId();//加载的布局文件id


    protected abstract void initView(Bundle savedInstanceState);//初始化view

    protected  void  initPresenter(){
       presenter=new BasePresenter(this);
    }

    protected abstract void setListener();//添加的各种监听

    protected abstract void initData();//获取数据等逻辑操作

    public BasePresenter getPresenter() {
        return presenter;
    }
    public abstract BaseDialog getLoadDialog();

//   private void initEmptyView(){
//        mEmptyView=new EmptyView();
//        mEmptyView.init(this);
//   }
//   protected void showNodataLayout(View contentView){
//       mEmptyView.showNodataLayout(contentView);
//   }

    @Override
    public void showLoading() {
        if(loadDialog==null){
            loadDialog = getLoadDialog();
        }
       loadDialog.show();

    }

    @Override
    public void closeLoading() {
        loadDialog.dismiss();
    }

    @Override
    public void handlerView(int tag, Object data) {

    }

    @Override
    public void handlerDownload(int tag, long total, long current, int percent) {

    }

    @Override
    public void handlerError(int tag, String errorMsg) {
        ToastUtil.showShort(this,errorMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
            presenter = null;
        }
    }
}
