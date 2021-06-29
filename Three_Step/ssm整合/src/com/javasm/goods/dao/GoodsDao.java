package com.javasm.goods.dao;

import com.javasm.goods.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: GoodsDao
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 19:11
 */
public interface GoodsDao {
    int addObj(Goods t);
    // 批量添加对象
    int batchAddObjs(Goods[] ts);
    // 根据id删除单个对象
    int delObj(int id);
    // 根据id批量删除
//    int batchDelObjs(@Param("ids") List<Integer> ids);
    // 更新对象
    int updateObj(Goods t);
    // 根据id查询对象
    Goods selectById(int id);
    // 查询所有的对象
    @Select("select * from sysgoods")
    List<Goods> selectList();
}
