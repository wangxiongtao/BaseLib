package com.dawn.baselib.http;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface API {

//    String BASE_URL = "https://www.apiopen.top/";
    String BASE_URL = "http://gc.ditu.aliyun.com/";


    @GET
    Observable<Response<ResponseBody>> doGet(@Url String Url);

    @FormUrlEncoded
    @POST
    Observable<Response<ResponseBody>> doPost(@Url String Url, @FieldMap HashMap<String, String> map);

    @Streaming
    @GET
    Observable<Response<ResponseBody>> doDownload(@Url String Url);
}
