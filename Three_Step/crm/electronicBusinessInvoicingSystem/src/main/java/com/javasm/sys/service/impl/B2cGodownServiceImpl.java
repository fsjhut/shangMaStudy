package com.javasm.sys.service.impl;

import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.javasm.commons.docx.DocxUtil;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import com.javasm.commons.utils.MD5Util;
import com.javasm.sys.dao.B2cGodownDao;
import com.javasm.sys.entity.B2cGodown;
import com.javasm.sys.entity.B2cOrder;
import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.service.B2cGodownService;
import com.javasm.sys.service.B2cOrderService;
import com.javasm.sys.service.GoodsInfoService;
import com.mchange.util.StringObjectMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("b2cGodownService")
public class B2cGodownServiceImpl extends BaseServiceImpl<B2cGodownDao, B2cGodown> implements B2cGodownService {

    @Resource
    B2cOrderService b2cOrderService;
    @Resource
    GoodsInfoService goodsInfoService;

    @Override
    public Map<String, Object> selectOrderDetailById(String oderId) {
        Map<String, Object> stringObjectMap = b2cOrderService.selectOrderDetailById(oderId);
        B2cGodown b2cGodown = dao.selectByOrderId(oderId);
        stringObjectMap.put("goDownMsg", JSONArray.toJSON(b2cGodown));
        return stringObjectMap;
    }

    @Override
    @Transactional
    public boolean outputWord(String orderId) {
        // 利用默认的路径
        if(!outputFunc(orderId,null)){
            throw new MvcException(S.ERROR);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean outputRar(List<String> orderIdsStr) {

        String zipName = DateUtil.getYMDHMS().
                replaceAll(":", "-").
                replaceAll("\\s", "_");
        String path = "D:/出库单文件夹/"+zipName+"/";
        boolean isFlag = true;
        for (String orderId : orderIdsStr) {
            // 定义一个延时1s的方法
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = outputFunc(orderId, path);
            if(!b){
                isFlag = false;
            }
        }
        if (!isFlag){
            throw new MvcException(S.ERROR);
        }
        // 将path文件下的所有文件生成一个压缩包
        ZipUtil.zip(path, "D:/出库单文件夹/"+zipName+".zip");
        // 将源文件夹删除
        deleteDir(path);
        return true;
    }
    private  boolean deleteDir(String path){
        File file = new File(path);
        if(!file.exists()){//判断是否待删除目录是否存在
            System.err.println("The dir are not exists!");
            return false;
        }

        String[] content = file.list();//取得当前目录下所有文件和文件夹
        for(String name : content){
            File temp = new File(path, name);
            if(temp.isDirectory()){//判断是否是目录
                deleteDir(temp.getAbsolutePath());//递归调用，删除目录里的内容
                temp.delete();//删除空目录
            }else{
                if(!temp.delete()){//直接删除文件
                    System.err.println("Failed to delete " + name);
                }
            }
        }
        return true;
    }

    private boolean outputFunc(String orderId, String path) {

        Map<String, Object> stringObjectMap = b2cOrderService.selectOrderDetailById(String.valueOf(orderId));
        Object productDate = stringObjectMap.get("productDate"); // list<Map<>> 订单对应的商品列表
        Object orderDeatail = stringObjectMap.get("orderDeatail");
        // 利用当前时间生成一个md5串码。
        // 更新商品数据
        List<GoodsInfo> goodsInfos = JSONArray.parseArray(productDate.toString(), GoodsInfo.class);
        for (GoodsInfo goodsInfo : goodsInfos) {
            String encodeStr = MD5Util.md5EncodeStr(DateUtil.getYMDHMS());
            goodsInfo.setGoodsIem(encodeStr);
            boolean b = goodsInfoService.updateById(goodsInfo);
            if (!b) {
                throw new MvcException(S.ERROR);
            }
        }
        // 更新订单的状态
        B2cOrder b2cOrder = JSONArray.parseObject(orderDeatail.toString(), B2cOrder.class);
        b2cOrder.setOrderState("已出库");
        b2cOrderService.updateById(b2cOrder);

        // 生成出库单
        if (path == null) {
            path = "D:/出库单文件夹/";
        }
        String target = "出库单"+DateUtil.getYMDHMS().
                replaceAll(":", "-").
                replaceAll("\\s", "_") + ".doc";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String fullPath = path + target;
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fullPath), "UTF-8");

            List<Map<String, Object>> data = new ArrayList<>();
            for (int i = 0; i < goodsInfos.size(); i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("sort", String.valueOf(i + 1));
                map.put("product_code", goodsInfos.get(i).getGoodsCode());
                map.put("product_name", goodsInfos.get(i).getGoodsName());
                map.put("product_num", goodsInfos.get(i).getGoodsCount().toString());
                map.put("product_price", goodsInfos.get(i).getGoodsPrice().toString());
                map.put("all_money", goodsInfos.get(i).getTotalAmount());
                map.put("market", goodsInfos.get(i).getGoodsIem());
                data.add(map);
            }
            Map<String, Object> map2 = new HashMap<>();
            map2.put("data", data);
            DocxUtil.createDocx("出库单模板.xml", map2, out);
            System.out.println(out.getEncoding());
            out.flush();
            out.close();
            // 生成一个出库记录
            B2cGodown b2cGodown = new B2cGodown();
            b2cGodown.setCreateTime(DateUtil.getYMDHMS());
            b2cGodown.setOperatePerson(CurrentLoginUser.getUname());
            b2cGodown.setOrderId(Integer.parseInt(orderId));
            int add = dao.add(b2cGodown);
            if (add != 1) {
                throw new MvcException(S.ERROR);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
