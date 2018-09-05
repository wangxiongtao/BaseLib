package com.dawn.baselib.http.function;

import com.dawn.baselib.http.handler.DownloadHandler;
import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.http.response.OkResponse;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

import retrofit2.Response;

/**
 * Created by Administrator on 2018/2/9 0009.
 */

public class DownloadFun implements Function<Response<ResponseBody>, ObservableSource<OkResponse>> {
    private OkRequest iRequest;

    public DownloadFun(OkRequest iRequest) {
        this.iRequest = iRequest;
    }

    @Override
    public ObservableSource<OkResponse> apply(Response<ResponseBody> response) throws Exception {
        return DownloadHandler.downloadFile(response,iRequest);
    }
}
