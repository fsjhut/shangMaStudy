package com.javasm.commons.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.commons.entity.TableDatas;
import com.javasm.commons.utils.ServletUtil;

import java.util.List;

/**
 * @className: BaseHandlers
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 20:59
 */
public class BaseHandler {
    public void startPage(){
        Integer pageNum = ServletUtil.getParameter("pageNum", 1);
        Integer pageSize = ServletUtil.getParameter("pageSize", 2);
        PageHelper.startPage(pageNum,pageSize);
    }

    public AxiosResult suc(Object data){
        return AxiosResult.suc(data);
    }

    public AxiosResult suc(){
        return AxiosResult.suc();
    }

    public AxiosResult suc(S s){
        return AxiosResult.suc(s);
    }

    public AxiosResult suc(S s,Object data){
        return AxiosResult.suc(s,data);
    }

    public AxiosResult error(S s){
        return AxiosResult.error(s);
    }
    public AxiosResult error(){
        return AxiosResult.error();
    }

    public AxiosResult result(boolean r){
        return r ? suc() : error();
    }
    public AxiosResult toTableDatas(List list){
        PageInfo info = new PageInfo(list);
        return suc(new TableDatas(info.getPageNum(),info.getPageSize(),info.getTotal(),list));
    }

}
