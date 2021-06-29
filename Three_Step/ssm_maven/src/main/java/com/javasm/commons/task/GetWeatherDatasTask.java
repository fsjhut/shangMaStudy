package com.javasm.commons.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class GetWeatherDatasTask {
    private RestTemplate t = new RestTemplate();

    @Resource
    private RedisService rs;
    //cron表达式,是配合定时任务组件使用的一种日期定义字符串
    //秒 分 时 日 月 周 年(可省略)
//    @Scheduled(cron = "0 * * ? * *")
    public void getWeather(){
        //全国各城市天气数据,一个城市一个hash.前端按照城市,日期来获取天气
        //避免多台tomcat同时执行一个任务.
        Long isok = rs.setnx(Keys.WEATHER_TASK, "runing");
        if(isok!=null){
            String cityName="郑州市";
            String key= Keys.WEATHERS+cityName;
            String path= "http://api.tianapi.com/txapi/tianqi/index?key=db3d22eebbff236d1b3b424ea12c3dd6&city="+cityName;
            String result = t.getForObject(path, String.class);
            JSONObject jsonObject = JSON.parseObject(result);
            Integer code = jsonObject.getInteger("code");
            if(code==200){
                JSONArray newslist = jsonObject.getJSONArray("newslist");
                for(int i=0;i<newslist.size();i++){
                    JSONObject day = newslist.getJSONObject(i);
                    String date = day.getString("date");
                    rs.hset(key,date,day.toJSONString());
                }
            }
            rs.del(Keys.WEATHER_TASK);
        }
        //删除10天之前的所有数据.
    }
}
