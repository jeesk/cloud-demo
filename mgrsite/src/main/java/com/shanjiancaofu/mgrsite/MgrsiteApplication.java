package com.shanjiancaofu.mgrsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MgrsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgrsiteApplication.class, args);
    }

}
