package com.shanjiancaofu.userserver.bean;

import java.io.Serializable;

public class Department implements Serializable {

    private Long id;
    private String departmentName;


    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Department(Long id, String departmentName) {
        super();
        this.id = id;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + departmentName + "]";
    }


}
