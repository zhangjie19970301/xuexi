package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application8080 {
    public static void main(String[] args) {
        SpringApplication.run(Application8080.class);
    }
}
