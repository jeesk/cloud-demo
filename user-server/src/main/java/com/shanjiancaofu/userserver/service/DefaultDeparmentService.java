package com.shanjiancaofu.userserver.service;

import com.shanjiancaofu.userserver.bean.Department;
import com.shanjiancaofu.userserver.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/*spring cache 的使用*/
@Service
@CacheConfig(cacheNames = "dept", cacheManager = "cacheManager")
public class DefaultDeparmentService implements IDeparmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @CachePut(cacheNames = "dept")
    public int insert(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    @CachePut(cacheNames = "dept", key = "#result.id") // 更新缓存
    public Department update(Department department) {
        if (departmentMapper.update(department) != 1) {
            throw new RuntimeException("修改失败");
        }
        return department;
    }

    @Override
    @CacheEvict(cacheNames = "dept", key = "#id") // 更新缓存
    public int delete(Long id) {
        return departmentMapper.delete(id);
    }

    @Override
    //    否定缓存 满足条件就不会被缓存
    @Cacheable(cacheNames = "dept", key = "#id", condition = "#id>0", /*sync = true,*/ unless = "#result == null")
    public Department selectByPrimaryKey(Long id) {
        System.out.println("查询单个数据");
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.listAll();
    }
}
