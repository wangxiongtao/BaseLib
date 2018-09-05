package com.dawn.baselib.mvp;

import com.dawn.baselib.http.HttpCallBack;
import com.dawn.baselib.http.HttpManager;
import com.dawn.baselib.http.request.OkRequest;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class IModel {

    private static IModel iModel;

    public static IModel getInstance() {
        if (iModel == null) {
            iModel = new IModel();
        }
        return iModel;
    }

    public void get(OkRequest request, HttpCallBack callBack) {
        HttpManager.getInstance().setCallBack(callBack).sendGetRequest(request);
    }
    public void post(OkRequest request, HttpCallBack callBack) {
        HttpManager.getInstance().setCallBack(callBack).sendPostRequest(request);
    }

    public void download(OkRequest request, HttpCallBack callBack) {
        HttpManager.getInstance().setCallBack(callBack).sendDownloadRequest(request);
    }


}
