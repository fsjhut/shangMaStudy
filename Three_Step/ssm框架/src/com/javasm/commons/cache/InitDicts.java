package com.javasm.commons.cache;

import com.alibaba.fastjson.JSON;
import com.javasm.sys.entity.SysdictsList;
import com.javasm.sys.entity.SysdictsType;
import com.javasm.sys.service.SysdictsListService;
import com.javasm.sys.service.SysdictsTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SunHang
 * @className: InitDicts
 * @description:
 * @createTime 2021/6/21 22:41
 */
@Component
public class InitDicts implements InitializingBean {

    @Resource
    private SysdictsListService listService;
    @Resource
    private SysdictsTypeService typeService;
    @Resource
    private RedisService rs;

    // 初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        // 字典项数据该保存为何种类型数据
        List<SysdictsType> sysdictsTypes = typeService.selectList(null);
        for (SysdictsType sysdictsType : sysdictsTypes) {
            String dkey = sysdictsType.getDkey();
            String key = Keys.DICTS_LIST + dkey;
            if (!rs.exists(key)) {
                SysdictsList sysdictsList = new SysdictsList();
                sysdictsList.setDkey(dkey);
                List<SysdictsList> sysdictsLists = listService.selectList(sysdictsList);
                for (SysdictsList list : sysdictsLists) {
                    rs.lpush(key, JSON.toJSONString(list));
                }
            }
        }

    }
}
