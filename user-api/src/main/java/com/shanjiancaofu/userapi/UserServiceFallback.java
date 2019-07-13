package com.shanjiancaofu.userapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceFallback implements IUserService {

    @Override
    public boolean saveUser(User user) {

        System.out.println("调用超时");
        return false;
    }

    @Override
    public List<User> findAll() {

        System.out.println("调用超时");
        return Collections.emptyList();
    }
}
