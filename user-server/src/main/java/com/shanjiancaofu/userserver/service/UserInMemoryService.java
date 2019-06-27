package com.shanjiancaofu.userserver.service;

import com.shanjiancaofu.userapi.IUserService;
import com.shanjiancaofu.userapi.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("userInMemoryService")
public class UserInMemoryService implements IUserService {

    private final static Random ran = new Random();

    List<User> list = new CopyOnWriteArrayList<>();

    @Value("${server.port}")
    String port;

    @Override
    public boolean saveUser(User user) {
        return list.add(user);
    }


    @Override
    public List<User> findAll() {
        System.out.println(port);
        try {
            Thread.sleep(ran.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }


}
