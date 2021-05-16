package com.javasm.service;

import com.javasm.entity.MyArea;

import java.util.List;

public interface AreaService {

    List<MyArea> getAreaByParentCode(Integer pcode);

}
