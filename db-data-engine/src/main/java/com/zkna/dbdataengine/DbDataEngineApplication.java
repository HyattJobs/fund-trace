package com.zkna.dbdataengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DbDataEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbDataEngineApplication.class, args);
    }

}
