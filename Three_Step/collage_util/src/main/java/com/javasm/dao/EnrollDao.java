package com.javasm.dao;


import com.javasm.entity.Enroll;

import java.util.List;

public interface EnrollDao extends BaseDao<Enroll> {

    List<String> selectAllSchoolIds();
}
