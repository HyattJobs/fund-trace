package com.zkna.eurekazone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //服务发现中心
public class EurekaZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZoneApplication.class, args);
    }

}
