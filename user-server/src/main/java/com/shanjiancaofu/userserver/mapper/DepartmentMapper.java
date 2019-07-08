package com.shanjiancaofu.userserver.mapper;

import com.shanjiancaofu.userserver.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    //@Insert("insert into department (id,departmentName) value (#{id},#{departmentName})")
    @Insert("insert into department value (#{id},#{departmentName})")
    int insert(Department department);

    @Update("update department set departmentName  = #{departmentName} where id = #{id}")
    int update(Department department);

    @Delete("delete from department where id = #{id}")
    int delete(Long id);


    @Select("select id,departmentName from department where id  = #{id}")
    Department selectByPrimaryKey(Long id);


    @Select("select id,departmentName from department")
    List<Department> listAll();
}
