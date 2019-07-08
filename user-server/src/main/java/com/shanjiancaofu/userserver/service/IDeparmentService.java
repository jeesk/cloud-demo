package com.shanjiancaofu.userserver.service;

import com.shanjiancaofu.userserver.bean.Department;

import java.util.List;


public interface IDeparmentService {

    int insert(Department department);


    Department update(Department department);


    int delete(Long id);


    Department selectByPrimaryKey(Long id);


    List<Department> listAll();
}

