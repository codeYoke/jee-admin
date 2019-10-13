package com.fjh.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YcuBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcuBackupApplication.class, args);
    }

}
