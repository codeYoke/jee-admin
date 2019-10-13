package com.fjh.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAdminServer //监听服务
@EnableDiscoveryClient//开启服务发现支持
@SpringBootApplication
public class YcuMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcuMonitorApplication.class, args);
    }

}
