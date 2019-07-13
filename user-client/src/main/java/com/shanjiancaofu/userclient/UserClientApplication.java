package com.shanjiancaofu.userclient;

import com.shanjiancaofu.userapi.IUserService;
import com.shanjiancaofu.userclient.loadbalance.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.shanjiancaofu.userclient","com.shanjiancaofu.userapi"})
@EnableDiscoveryClient // 制定调用的class 类
@EnableFeignClients(clients = IUserService.class, basePackages = "com.shanjiancaofu.userapi")
// 申明IUserService 为feign 的客户端
@RibbonClient(value = "user-server", configuration = MySelfRule.class) // 指定目标应用名称 的轮训策略 */
@EnableCircuitBreaker // 开启Hystrix
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})

/*@RibbonClient("user-server")*/
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
