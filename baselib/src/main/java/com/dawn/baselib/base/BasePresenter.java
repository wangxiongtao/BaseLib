package com.dawn.baselib.base;

import com.dawn.baselib.http.HttpCallBack;
import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.mvp.IModel;
import com.dawn.baselib.mvp.IPresenter;
import com.dawn.baselib.mvp.IView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public  class BasePresenter implements IPresenter,HttpCallBack {
    private WeakReference<IView> viewRef;
    private Disposable d;

    public BasePresenter(IView view){
        viewRef=new WeakReference<>(view);
    }

    @Override
    public IView getView() {
        if(viewRef==null){
            return null;
        }
        return viewRef.get();
    }

    @Override
    public void sendGetRequest(OkRequest request) {
        IModel.getInstance().get(request,this);
    }

    @Override
    public void sendPostRequest(OkRequest request) {
        IModel.getInstance().post(request,this);
    }

    @Override
    public void onHttpStart(int tag,Disposable d) {
        this.d=d;
        if(getView()!=null){
            getView().showLoading();
        }
    }

    @Override
    public void onHttpSuccess( int tag,Object response) {
        if(getView()!=null){
            getView().closeLoading();
            getView().handlerView(tag,response);
        }
    }

    @Override
    public void onHttpFail(int tag,String errorMsg) {
        if(getView()!=null){
            getView().closeLoading();
            getView().handlerError(tag,errorMsg);
        }

    }

    @Override
    public void onProgress(int tag,long total, long current,int percent) {
        if(getView()!=null){
            getView().closeLoading();
            getView().handlerDownload(tag,total,current,percent);
        }

    }

    @Override
    public void onHttpEnd() {

    }

    @Override
    public void onDestroy() {
       if(viewRef!=null){
           if(d!=null){
               d.dispose();
           }
           viewRef.clear();
           viewRef=null;
       }
    }
}
