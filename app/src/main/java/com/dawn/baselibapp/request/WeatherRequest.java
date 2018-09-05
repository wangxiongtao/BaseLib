package com.dawn.baselibapp.request;

import com.dawn.baselib.http.request.OkRequest;
import com.dawn.baselib.http.response.BaseResult;
import com.dawn.baselibapp.bean.InternetNameBean;
import com.dawn.baselibapp.bean.WeatherBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/3/23 0023.
 */

public class WeatherRequest extends OkRequest<BaseResult<WeatherBean>> {
    public String city;

    public WeatherRequest(int tag) {
        super(tag);
    }

    @Override
    public String getUrl() {
        return "weatherApi";
    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String,String>map=super.getParamMap();
        map.put("city",city);
        return map;
    }
}
