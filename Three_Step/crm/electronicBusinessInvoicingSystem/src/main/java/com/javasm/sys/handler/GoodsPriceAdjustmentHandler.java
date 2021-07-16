package com.javasm.sys.handler;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.GoodsPriceAdjustment;
import com.javasm.sys.service.GoodsPriceAdjustmentService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goodsPriceAdjustment")
public class GoodsPriceAdjustmentHandler extends BaseHandler {

    @Resource
    private GoodsPriceAdjustmentService service;
    @Resource
    private RedisService rs;


    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsPriceAdjustment obj = service.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsPriceAdjustment obj) {
        startPage();
//        obj.setJudge(2);
        obj.setUname(CurrentLoginUser.getUname());
        List<GoodsPriceAdjustment> list = this.service.selectList(obj);
        AxiosResult axiosResult = toTableDatas(list);
        return axiosResult;
    }



    @PostMapping
    public AxiosResult add(@RequestBody GoodsPriceAdjustment good) {

        boolean add = service.add(good);
        if (add) return suc();
        return error();

    }

//    @Transactional
//    @AuditLogs
    @PutMapping
    public Object updateById(@RequestBody Map map) {
        if (map.get("verifyStatus")==null) {
            String name = CurrentLoginUser.getUname();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String time = format.format(date);
            map.put("updateBy", name);
            map.put("updateTime", time);
        }
        GoodsPriceAdjustment good = new GoodsPriceAdjustment();
        try {
            BeanUtils.populate(good,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean r = this.service.updateById(good);
        return r?"true":"false";
    }

    @DeleteMapping("{ids}")
    public AxiosResult delByIds(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.service.delByIds(Arrays.asList(split));
        return result(r);
    }

    @GetMapping("type")
    public AxiosResult getType(){

        String goodsDatas = rs.get("goodsDatas");
        Object parse = JSON.parse(goodsDatas);
        return suc(parse);
    }


}
