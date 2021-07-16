package com.javasm.commons.cache;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.javasm.commons.utils.DataProcessUtil;
import com.javasm.sys.dao.CrmAreaDao;
import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.service.GoodsManagerService;
import com.javasm.sys.service.MenuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:巴晓磊
 * @className:InitMethod
 * @description:
 * @date:2021/6/22 11:19
 * @version:0.1
 * @since:1.8
 */
@Component
public class InitMethod implements InitializingBean {
    //如果想在tomcat启动时候，把某些东西加载到spring容器中，可以在这afterPropertiesSet这个方法中写逻辑
    @Resource
    private RedisService rs;
    @Resource
    private GoodsManagerService goodsManagerService;
    @Resource
    private CrmAreaDao areaDao;
    @Resource
    private VindicteMainTainDatas mainTain;

    @Override
    public void afterPropertiesSet() throws Exception {
        //将菜单数据更新到redis中

//        List<Menu> menus = menuService.treeMenu(new Menu());
//        rs.set("menuTree",JSON.toJSONString(menus));

        //  将商品类型数据插入到redis中
        List<GoodsManager> goodsManagers = goodsManagerService.selectList(new GoodsManager());
        List<List<Map<String, String>>> goodData = DataProcessUtil.getGoodData(goodsManagers);
        rs.set("goodsDatas",JSON.toJSONString(goodData));

        //  如果redis中没有全国地点数据，则从数据库中搜索添加
        List<CrmArea> crmAreas = null;
        String allAreaTree = rs.get("allAreaTree");
        String allAreasList = rs.get("allAreasList");


        if (allAreasList==null){
            crmAreas = areaDao.selectList(new CrmArea());
            rs.set("allAreasList",JSON.toJSONString(crmAreas));
        }
        if (allAreaTree==null){
            mainTain.addRedisArea(crmAreas);
        }
        mainTain.addRedisMainTain(JSON.parseObject(allAreasList, new TypeReference<ArrayList<CrmArea>>(){}));
    }


}














