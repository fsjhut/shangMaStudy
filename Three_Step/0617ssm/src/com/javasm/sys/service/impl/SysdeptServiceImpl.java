package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Sysdept;
import com.javasm.sys.dao.SysdeptDao;
import com.javasm.sys.service.SysdeptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.javasm.commons.base.BaseServiceImpl;

@Service("sysdeptService")
public class SysdeptServiceImpl extends BaseServiceImpl<SysdeptDao, Sysdept> implements SysdeptService {
    @Override
    public boolean hasChilds(String id) {
        Sysdept d = new Sysdept();
        d.setDparentid(Integer.parseInt(id));
        List<Sysdept> sysdepts = dao.selectList(d);
        return sysdepts.size()>0?true:false;
    }

    @Override
    public List<Sysdept> createTree(List<Sysdept> list) {
        //找到顶级节点
        Set<Integer> parentids = new HashSet<>();
        List<Integer> ids = new ArrayList<>();
        for (Sysdept sysdept : list) {
            Integer dparentid = sysdept.getDparentid();
            parentids.add(dparentid);
            ids.add(sysdept.getDid());
        }
        parentids.removeAll(ids);

        //从顶级节点递归集合,找到子部门的结合,
        List<Sysdept> t = tree(list,parentids);
        return t ;
    }

    private List<Sysdept> tree(List<Sysdept> list,Set<Integer> parentids){
        List<Sysdept> result = new ArrayList<>();
        for (Sysdept sysdept : list) {
            Integer dparentid = sysdept.getDparentid();
            if(parentids.contains(dparentid)){
                //查找子部门集合(递归调用)
                List<Sysdept> c = childs(list,sysdept.getDid());
                if(c.size()>0){
                    sysdept.setChildren(c);
                }
                result.add(sysdept);
            }
        }
        return result;
    }

    private List<Sysdept> childs(List<Sysdept> sysdepts,Integer parentid){
        List<Sysdept> childs = new ArrayList<>();
        for (Sysdept sysdept : sysdepts) {
            if(sysdept.getDparentid().equals(parentid)){
                List<Sysdept> c = childs(sysdepts,sysdept.getDid());
                if(c.size()>0){
                    sysdept.setChildren(c);
                }
                childs.add(sysdept);
            }
        }
        return childs;
    }
}
