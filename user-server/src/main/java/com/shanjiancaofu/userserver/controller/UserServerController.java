package com.shanjiancaofu.userserver.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shanjiancaofu.userapi.IUserService;
import com.shanjiancaofu.userapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Random;


@RestController
public class UserServerController implements IUserService {

    private final static Random ran = new Random();
    @Qualifier("userInMemoryService")
    @Autowired
    private IUserService userService;


    @Override
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            }, fallbackMethod = "fallbackForGetUsers"

    )
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/user/list")
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            }, fallbackMethod = "fallbackForGetUsers"

    )
    public List<User> getUser() {
        int i = ran.nextInt(200);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current time : " + i);
        return userService.findAll();
    }


    public List<User> fallbackForGetUsers() {

        System.out.println("23");
        return

                Collections.emptyList();
    }


}
