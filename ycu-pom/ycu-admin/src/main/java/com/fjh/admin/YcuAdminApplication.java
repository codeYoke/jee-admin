package com.fjh.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YcuAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcuAdminApplication.class, args);
    }

}
