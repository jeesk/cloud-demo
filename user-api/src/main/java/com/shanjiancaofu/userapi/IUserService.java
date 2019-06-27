package com.shanjiancaofu.userapi;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author jeesk
 */
@FeignClient(name = "${user.service.name}", fallback = UserServiceFallback.class) // 利用占位符避免未来整合硬编码
public interface IUserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    boolean saveUser(@RequestBody User user);


    /**
     * 查询所有的用户列表
     * @return non-null
     */
    @GetMapping("/user/find/all")
    List<User> findAll();


}
