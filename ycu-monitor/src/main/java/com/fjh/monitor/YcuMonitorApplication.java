package com.fjh.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer //监听服务
@SpringBootApplication
public class YcuMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcuMonitorApplication.class, args);
    }

}
