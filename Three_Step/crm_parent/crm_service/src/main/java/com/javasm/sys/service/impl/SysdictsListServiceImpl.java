package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.base.BaseServiceImpl;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.dao.SysdictsListDao;
import com.javasm.sys.entity.SysdictsList;
import com.javasm.sys.service.SysdictsListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysdictsListService")
public class SysdictsListServiceImpl extends BaseServiceImpl<SysdictsListDao, SysdictsList> implements SysdictsListService {

    @Resource
    private RedisService redisService;

    @Override
    public List<SysdictsList> selectListByDkey(String dkey) {
        String key = Keys.DICTS_LIST+dkey;
        List<String> result = redisService.lrange(key, 0, -1);//{},{}
        if(result!=null){
            String jsonStr = result.toString();
            return JSON.parseArray(jsonStr, SysdictsList.class);
        }

        SysdictsList l = new SysdictsList();
        l.setDkey(dkey);
        List<SysdictsList> sysdictsLists = selectList(l);//按照lsort排序
        if(sysdictsLists!=null &&sysdictsLists.size()>0){
            for (SysdictsList sysdictsList : sysdictsLists) {
                redisService.lpush(key,JSON.toJSONString(sysdictsList));
            }
        }
        return sysdictsLists;
    }
}
