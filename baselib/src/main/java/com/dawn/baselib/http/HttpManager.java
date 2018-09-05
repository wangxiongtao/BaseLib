package com.dawn.baselib.http;


import com.dawn.baselib.http.interceptor.HeadInterceptor;
import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.http.function.DownloadFun;
import com.dawn.baselib.http.function.PostResponseFun;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class HttpManager {
    private Retrofit retrofit;
    private HttpCallBack callBack;


    private static class SingletonHolder {
        private static HttpManager instance = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.instance;
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new HeadInterceptor())
                .build();
    }

    private HttpManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    public HttpManager sendGetRequest(OkRequest request) {
        HashMap<String,String>paramsMap=request.getParamMap();
        StringBuilder tempParams = new StringBuilder();
        int pos = 0;
        for (String key : paramsMap.keySet()) {
            if (pos > 0) {
                tempParams.append("&");
            }
            tempParams.append(String.format("%s=%s", key, paramsMap.get(key)));
            pos++;
        }

        retrofit.create(API.class)
                .doGet(request.getUrl()+"?"+tempParams.toString())
                .map(new PostResponseFun( request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver(request, callBack));
        return this;

    }
    public HttpManager sendPostRequest(OkRequest request) {
        HashMap<String,String>map=request.getParamMap();
        retrofit.create(API.class)
                .doPost(request.getUrl(), map)
                .map(new PostResponseFun( request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver(request, callBack));
        return this;

    }

    public HttpManager sendDownloadRequest(OkRequest request) {
        retrofit.create(API.class)
                .doDownload(request.getUrl())
                .flatMap(new DownloadFun(request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver(request, callBack).isDownload(true));
        return this;
    }


    public HttpManager setCallBack(HttpCallBack callBack) {
        this.callBack = callBack;
        return this;
    }
}
