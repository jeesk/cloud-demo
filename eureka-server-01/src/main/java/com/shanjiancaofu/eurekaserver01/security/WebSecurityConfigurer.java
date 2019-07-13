package com.shanjiancaofu.eurekaserver01.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//    因为Eureka Server默认开启了CsrfFilter，导致微服务不能注册成功。因此只需要关闭Eureka Server的CsrfFilter即可
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}