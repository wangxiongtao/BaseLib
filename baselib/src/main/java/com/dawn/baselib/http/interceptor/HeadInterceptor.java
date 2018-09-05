package com.dawn.baselib.http.interceptor;

import com.dawn.baselib.http.HeaderValues;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class HeadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return addHeader(chain);
    }
    private Response addHeader(Interceptor.Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("storeId", "20001000001")
                .header("vendorId","20001" )
                .header("token", HeaderValues.TOKEN );
        Request request = requestBuilder.build();
        Response response;
        response = chain.proceed(request);


        ResponseBody responseBody = response.body();
        return response;
    }

}
