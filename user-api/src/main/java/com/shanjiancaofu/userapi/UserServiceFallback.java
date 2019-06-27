package com.shanjiancaofu.userapi;

import java.util.Collections;
import java.util.List;


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
