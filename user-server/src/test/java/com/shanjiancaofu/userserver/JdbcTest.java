package com.shanjiancaofu.userserver;

import com.shanjiancaofu.springboot.shanjiancaofuspringbootautoconfigurer.HelloService;
import com.shanjiancaofu.userserver.bean.Department;
import com.shanjiancaofu.userserver.bean.Employee;
import com.shanjiancaofu.userserver.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private HelloService helloService;

    @Test
    public void connTest() throws SQLException {
        System.out.println(dataSource);
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
            connection.close();
        }
    }

    @Test
    public void saveDepartment() {
        Department department = new Department();
        department.setDepartmentName("小卖部");
        department.setId(2L);
        int insert = departmentMapper.insert(department);
        System.out.println(insert == 1);
    }


    @Test
    public void helloServiceTest() {
        String result = helloService.sayHello("师姐你好");
        System.out.println(result);
    }


/*    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void setRedisTemplateTest() {
        Employee hello = (Employee) redisTemplate.opsForValue().get("hello");
        System.out.println(hello);

    }*/

/*    @Autowired
    DruidServletProperties druidServletProperties;


    @Test
    public void druidServletPropertiesTest(){
        String allow = druidServletProperties.getAllow();
        System.out.println(druidServletProperties);
    }*/
}
