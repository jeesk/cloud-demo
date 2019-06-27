package com.shanjiancaofu.userclient.controller;

import com.shanjiancaofu.userapi.IUserService;
import com.shanjiancaofu.userapi.User;
import com.shanjiancaofu.userclient.hystrix.UserRibbonhystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController implements IUserService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUserService userService;


    private UserRibbonhystrixCommand userRibbonhystrixCommand;

    @PostConstruct
    public void init() {
    }

    @Override
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @Override
    public List<User> findAll() {
        return userService.findAll();
    }


    // 编程形式调用

    @GetMapping("user-server/user/list")
    public List<User> getUserLisr() {
        // List forObject = restTemplate.getForObject("http://user-server/user/list", List.class);
        return new UserRibbonhystrixCommand("user-server", restTemplate).execute();
    }

}
