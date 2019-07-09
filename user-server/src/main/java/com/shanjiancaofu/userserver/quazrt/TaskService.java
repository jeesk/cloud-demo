package com.shanjiancaofu.userserver.quazrt;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// 定时任务主键
@Component
public class TaskService {


    @Scheduled(cron = "0/5 0 * * * *")
    public void print() {
        System.out.println("hello world");
    }
}
