package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.sys.entity.GoodType;
import com.javasm.sys.dao.GoodTypeDao;
import com.javasm.sys.service.GoodTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (GoodType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-30 16:21:49
 */
@Service("goodTypeService")
public class GoodTypeServiceImpl extends BaseServiceImpl<GoodTypeDao,GoodType> implements GoodTypeService {

    @Override
    public boolean hasChilds(String id) {
        GoodType d=new GoodType();
        d.setPid(Integer.parseInt(id));
        List<GoodType> goodTypes = dao.selectList(d);
        return goodTypes.size()>0?true:false;
    }

    @Override
    public List<GoodType> createTree(List<GoodType> list) {
        Set<Integer> pids=new HashSet<>();
        List<Integer> ids=new ArrayList<>();

        for (GoodType goodType : list) {
            pids.add(goodType.getPid());
            ids.add(goodType.getTid());
        }
        pids.remove(ids);
        List<GoodType> typeList=tree(list,pids);
        return typeList;
    }
    private List<GoodType> tree(List<GoodType> list,Set<Integer> pids){

        List<GoodType> result=new ArrayList<>();
        for (GoodType goodType : list) {
            Integer pid=goodType.getPid();
            if (pids.contains(pid)) {
                List<GoodType> childList = childs(list, goodType.getTid());
                if (childList.size()>0) {
                    goodType.setChilds(childList);
                }
                result.add(goodType);
            }
        }
        return result;
    }

    private List<GoodType> childs(List<GoodType> goodTypes,Integer pid){
        List<GoodType> childs=new ArrayList<>();
        for (GoodType goodType : goodTypes) {
            if (goodType.getPid().equals(pid)) {
                List<GoodType> childList=childs(goodTypes,goodType.getTid());
                if (childList.size()>0){
                    goodType.setChilds(childList);
                }
                childs.add(goodType);
            }
        }
        return childs;

    }

}
