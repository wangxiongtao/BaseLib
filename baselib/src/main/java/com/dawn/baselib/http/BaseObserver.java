package com.dawn.baselib.http;
import com.dawn.baselib.http.handler.ResponseHandler;
import com.dawn.baselib.http.log.OkLogPrinter;
import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.http.response.OkResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public  class BaseObserver implements Observer<OkResponse> {
    private HttpCallBack callBack;
    private OkRequest request;
    private boolean isDownload;

    public BaseObserver(OkRequest request, HttpCallBack callBack) {
        this.request = request;
        this.callBack = callBack;

    }

    public Observer<OkResponse> isDownload(boolean download) {
        isDownload = download;
        return this;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if(callBack!=null){
            callBack.onHttpStart(request.getTag(),d);
        }

    }

    @Override
    public void onNext(OkResponse value) {
        OkLogPrinter.logSucess(isDownload,value);
        if(callBack!=null){
            if(isDownload){
                callBack.onProgress(request.getTag(),value.getTotalSize(),value.getCurrentSize(),value.getPercent());
                return;
            }
            callBack.onHttpSuccess(request.getTag(),value.getBaseResult().data);
        }


    }

    @Override
    public void onError(Throwable e) {
        e= ResponseHandler.checkException(e,request);
        OkLogPrinter.logFail(e);
        if(callBack!=null){
            callBack.onHttpFail(request.getTag(),e.getMessage() );
        }

    }

    @Override
    public void onComplete() {

    }
}
