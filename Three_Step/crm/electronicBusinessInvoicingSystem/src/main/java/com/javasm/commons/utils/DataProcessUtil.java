package com.javasm.commons.utils;

import cn.hutool.json.JSONArray;
import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.MaintainManager;
import com.sun.xml.bind.v2.TODO;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DataUtil.java
 * @Description TODO
 * @createTime 2021年07月05日 14:52:00
 */
public class DataProcessUtil {

    //  处理商品数据，封装符合前端的数据格式
    public static List<List<Map<String, String>>> getGoodData(List<GoodsManager> list) {

        ArrayList<List<Map<String, String>>> lists = new ArrayList<>();
        //  商品分类
        List<Map<String, String>> goodsType = new ArrayList<>();
        list.stream().map(o -> o.getGoodsType()).distinct().forEach(o -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("value", o);
            map.put("lable", o);
            goodsType.add(map);
        });
        List<Map<String, String>> goodsColor = new ArrayList<>();
        list.stream().map(o -> o.getGoodsColor()).distinct().forEach(o -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("value", o);
            map.put("lable", o);
            goodsColor.add(map);
        });
        List<Map<String, String>> goodsBrand = new ArrayList<>();
        list.stream().map(o -> o.getGoodsBrand()).distinct().forEach(o -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("value", o);
            map.put("lable", o);
            goodsBrand.add(map);
        });

        lists.add(goodsType);
        lists.add(goodsColor);
        lists.add(goodsBrand);

        return lists;
    }

    //  处理地点数据
    public static Object getAreas(List<CrmArea> list) {

        List<Object> collect = list.stream().map(p -> {
            ArrayList<CrmArea> crmAreas = new ArrayList<>();
            list.stream().forEach(c -> {
                if (p.getId() == c.getPid()) {
                    crmAreas.add(c);
                }
                getAreas(list);
            });
            p.setList(crmAreas);
            return p;
        }).collect(Collectors.toList());
        return collect;

    }

    //  NO1  获取树形方法
    public static List<CrmArea> getList(List<CrmArea> list) {

        //获取父节点，0表示父节点
        List<CrmArea> collect = list.stream().filter(e -> e.getPid() == 0).peek(e -> {
            e.setList(getChildrens(e, list));
            System.out.println(e);
        }).collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    //  NO2
    private static List<CrmArea> getChildrens(CrmArea parent, List<CrmArea> list) {
        List<CrmArea> childrenList = list.stream().filter(e -> Objects.equals(e.getPid(), parent.getId())).peek(
                e -> {
                    e.setList(getChildrens(e, list));
                }
        ).collect(Collectors.toList());

        return childrenList;
    }


    //  按指定length分隔list
    public static <T> List<List<T>> subList(List<T> list, Integer length) {
        if (list == null || list.isEmpty() || length < 1) {
            return Collections.emptyList();
        }

        ArrayList<List<T>> resultList = new ArrayList<>();
        int size = list.size();
        int count = (size + length - 1) / length;

        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * length, (i + 1) * length > size ? size : length * (i + 1));
            resultList.add(subList);
        }

        return resultList;
    }

    //  将地点树形中的空值置为null
    public static List<CrmArea> delNull(List<CrmArea> list) {
        for (CrmArea crmArea : list) {
            List<CrmArea> list1 = crmArea.getList();
            if (list1 == null || list1.size() == 0) {
                crmArea.setList(null);
            } else {
                delNull(list1);
            }
        }
        return list;
    }


    //  NO1 反向遍历线性寻找，组成线性结构
    public static CrmArea getParent(List<CrmArea> listAll, CrmArea child) {

        for (CrmArea parent : listAll) {
            if (child.getPid().equals(parent.getId())) {
                parent.getList().add(child);
                if (parent.getPid() == 0) {
                    return parent;
                } else {
                    getParent(listAll, parent);
                }
            }
        }
        return null;
    }

    //  NO2 线性结构组成树状
    public static HashSet<CrmArea> getParents(List<CrmArea> listAll, List<Integer> listChild) {

        List<CrmArea> list = listAll.stream().filter(o -> listChild.contains(o.getId())).collect(Collectors.toList());

//        ArrayList<CrmArea> crmAreas = new ArrayList<>();
        HashSet<CrmArea> crmAreas = new HashSet<>();
        CrmArea parent = null;
        for (CrmArea crmArea : list) {
            parent = getParent(listAll, crmArea);
            crmAreas.add(parent);
        }
        return crmAreas;

    }


}