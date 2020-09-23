package com.zkna.dbdataengine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//springBoot2.1以上版本 (如果不加 注册不了)
@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.requestMatchers()
                    .antMatchers("/userInfo/**","/userInfoPlus/**")
                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/userInfo/**").authenticated()
//                    .and()
                    .csrf().disable();
        }
}