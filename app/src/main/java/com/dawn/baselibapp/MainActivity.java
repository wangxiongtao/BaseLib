package com.dawn.baselibapp;


import android.content.ContentProviderClient;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dawn.baselib.http.HeaderValues;
import com.dawn.baselib.util.CountDowntimerUtil;
import com.dawn.baselib.util.StatusBarUtil;
import com.dawn.baselib.util.ToastUtil;
import com.dawn.baselibapp.base.OHBaseActivity;
import com.dawn.baselibapp.bean.InternetNameBean;
import com.dawn.baselibapp.bean.WeatherBean;
import com.dawn.baselibapp.request.InternetNameRequest;
import com.dawn.baselibapp.request.WeatherRequest;

import java.util.List;


public class MainActivity extends OHBaseActivity {
    private static final int TAG_REQUEST_WEATHER=101;
    private static final int TAG_REQUEST_INTERNETNAME=111;
    private Button postButton;
    private Button getButton;
    private TextView contentTv;
    int a=0;
    private int page=1;
//    ContentProviderClient


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBaseTitleTv.setText("测试");
//        MainActivity activity=new MainActivity();
//        activity.onResume();



        postButton=findViewById(R.id.post_btn);
        getButton=findViewById(R.id.get_btn);
        contentTv=findViewById(R.id.content_tv);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InternetNameRequest request=new InternetNameRequest(TAG_REQUEST_INTERNETNAME);
                request.page=page+"";
                getPresenter().sendPostRequest(request);

            }
        });
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WeatherRequest request = new WeatherRequest(TAG_REQUEST_WEATHER);
                request.city = "杭州";
                getPresenter().sendGetRequest(request);
            }
        });






    }


    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        Log.i("aaa", "======initData======>");



    }

    @Override
    public void handlerView(int tag, Object data) {
        super.handlerView(tag, data);
        switch (tag){
            case TAG_REQUEST_WEATHER:
                WeatherBean bean= (WeatherBean) data;
                contentTv.setText(bean.toString());
                break;
            case TAG_REQUEST_INTERNETNAME:
                List<InternetNameBean> bean2= (List<InternetNameBean>) data;
                contentTv.setText(bean2.toString());
                page++;
                break;
        }


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i("aaa", "======onPostCreate======>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CountDowntimerUtil.destory();
    }
}
