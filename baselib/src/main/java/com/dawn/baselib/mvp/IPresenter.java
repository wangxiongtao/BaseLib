package com.dawn.baselib.mvp;

import com.dawn.baselib.http.request.OkRequest;


/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface IPresenter {
    IView getView();

    void sendGetRequest(OkRequest request);
    void sendPostRequest(OkRequest request);

    void onDestroy();

}
