package com.heights.auditapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AuditappApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditappApplication.class, args);
    }

}
