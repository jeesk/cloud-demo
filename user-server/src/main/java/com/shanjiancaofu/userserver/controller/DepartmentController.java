package com.shanjiancaofu.userserver.controller;

import com.shanjiancaofu.userserver.bean.Department;
import com.shanjiancaofu.userserver.service.DefaultDeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DefaultDeparmentService defaultDeparmentService;

    @PostMapping("dept/save")
    public int insert(Department department) {
        System.out.println("插入数据");
        return defaultDeparmentService.insert(department);
    }

    @PutMapping("dept/update")
    public int update(Department department) {
        System.out.println("修改数据");
        defaultDeparmentService.update(department);
        return 1;
    }

    @DeleteMapping("dept/{id}")
    public int delete(@PathVariable("id") Long id) {
        System.out.println("删除数据");
        return defaultDeparmentService.delete(id);
    }


    @GetMapping("dept/list")
    public Department selectByPrimaryKey(Long id) {

        return defaultDeparmentService.selectByPrimaryKey(id);
    }


    @GetMapping("dept/listAll")
    public List<Department> listAll() {
        System.out.println("查询所有数据");
        return defaultDeparmentService.listAll();
    }
}
