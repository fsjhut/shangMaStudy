package com.javasm.dao;

import com.javasm.entity.MyArea;

import java.util.List;

public interface AreaDao {

    List<MyArea> getAreaByParentCode(Integer pcode);

}
