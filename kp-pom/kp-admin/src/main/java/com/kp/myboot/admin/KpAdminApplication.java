package com.kp.myboot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kp.myboot.admin"})
public class KpAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(KpAdminApplication.class, args);
    }

}
