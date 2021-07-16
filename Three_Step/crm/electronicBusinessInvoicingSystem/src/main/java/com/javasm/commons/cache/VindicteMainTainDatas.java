package com.javasm.commons.cache;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.utils.DataProcessUtil;
import com.javasm.sys.dao.CrmAreaDao;
import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.entity.MaintainManager;
import com.javasm.sys.service.MaintainManagerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName VindicteMainTainDatas.java
 * @Description TODO
 * @createTime 2021年07月07日 13:50:00
 */
@Component
public class VindicteMainTainDatas {

    @Resource
    private RedisService rs;
    @Resource
    private MaintainManagerService mainTain;
    @Resource
    private CrmAreaDao areaDao;

    public void addRedisArea(List<CrmArea> crmAreas){
        // 将树状地点信息存储到redis中
            List<CrmArea> list = DataProcessUtil.getList(crmAreas);
            List<CrmArea> crmAreas1 = DataProcessUtil.delNull(list);
            rs.set("allArea", JSON.toJSONString(crmAreas1));

    }
    public List<CrmArea> addRedisMainTain(List<CrmArea> crmAreas){

        if (crmAreas==null){
            crmAreas=areaDao.selectList(new CrmArea());
        }
        List<MaintainManager> maintainManagers = mainTain.selectList(null);
        List<Integer> collect = maintainManagers.stream().map(o -> o.getMaintainCity()).collect(Collectors.toList());
        HashSet<CrmArea> parents = DataProcessUtil.getParents(crmAreas, collect);
        ArrayList<CrmArea> crmAreas1 = new ArrayList<>(parents);
        List<CrmArea> collect1 = crmAreas1.stream().filter(o -> o != null).collect(Collectors.toList());
        rs.set("AllMainTainArea",JSON.toJSONString(collect1));
        //  返回树形维修点
        return collect1;
        }
}