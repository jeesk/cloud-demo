package com.shanjiancaofu.userserver.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll().
                antMatchers("/level1/**").hasRole("VIP1").
                antMatchers("/level2/**").hasRole("VIP2").
                antMatchers("/level3/**").hasRole("VIP3").
                requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ENDPOINT_ADMIN").and()
                .httpBasic();


        // 来到登录页面
        http.formLogin();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().
                withUser("zhangshan").password("123456").roles("VIP1", "ENDPOINT_ADMIN").and().
                withUser("daming").password("123456").roles("VIP2").and().
                withUser("hello").password("123456").roles("VIP3");


    }


}