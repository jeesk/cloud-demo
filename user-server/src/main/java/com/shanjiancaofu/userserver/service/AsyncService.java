package com.shanjiancaofu.userserver.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    // 异步调用 无返回值
    @Async("taskExecutor") // 使用配置的线程池子
    public void asyncNoReturn() {
        System.out.println("hello");
    }

    // 异步调用　有返回值得
    @Async("taskExecutor")
    public boolean asyncReturn() {
        return true;
    }


}
