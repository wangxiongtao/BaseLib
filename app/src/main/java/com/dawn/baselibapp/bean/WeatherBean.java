package com.dawn.baselibapp.bean;

/**
 * Created by Administrator on 2018/5/24 0024.
 */

public class WeatherBean {
    public String city;//": "",
    public String aqi;//": "80",
    public String ganmao;//": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。",
    public String wendu;//": "26"

    @Override
    public String toString() {
        return "WeatherBean{" +
                "city='" + city + '\'' +
                ", aqi='" + aqi + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                '}';
    }
}
