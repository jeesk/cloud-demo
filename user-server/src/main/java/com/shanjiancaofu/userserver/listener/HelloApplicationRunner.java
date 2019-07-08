package com.shanjiancaofu.userserver.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run....");
    }
}


// ApplicationRunner 和 CommandRunner 都是 一样的, 在应用 启动成功后最后一步回调。
 //