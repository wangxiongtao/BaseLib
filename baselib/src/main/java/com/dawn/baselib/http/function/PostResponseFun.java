package com.dawn.baselib.http.function;

import com.dawn.baselib.http.exception.HttpException;
import com.dawn.baselib.http.handler.ResponseHandler;
import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.http.response.BaseResult;
import com.dawn.baselib.http.response.OkResponse;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.dawn.baselib.http.exception.HttpException.RESULT_NO_ERROR_CODE;


/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class PostResponseFun implements Function<Response<ResponseBody>, OkResponse> {
    private OkRequest request;

    public PostResponseFun(OkRequest request) {
        this.request = request;
    }

    @Override
    public OkResponse apply(Response<ResponseBody> o) throws Exception {
        OkResponse response=new OkResponse(request,o,o.body().string());
        HttpException exception= ResponseHandler.checkResult(response,request.getGenericSuperclass());
        if(exception.getCode() != RESULT_NO_ERROR_CODE){
            throw exception;
        }

        BaseResult result = exception.getResult();
        result.tag=request.getTag();
        response.setBaseResult(result);

        return response;
    }
}
