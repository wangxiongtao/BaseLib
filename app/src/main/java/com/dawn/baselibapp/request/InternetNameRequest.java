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

public class InternetNameRequest extends OkRequest<BaseResult<List<InternetNameBean>>> {
    public String page;

    public InternetNameRequest(int tag) {
        super(tag);
    }

    @Override
    public String getUrl() {
        return "femaleNameApi";
    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String,String>map=super.getParamMap();
        map.put("page",page);
        map.put("page1","dd");
        map.put("page3","ddADasd");
        return map;
    }
}
