package com.simao.application.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.simao.service")
@ComponentScan(basePackages = {"com.simao.application", "com.simao.service"})
@RefreshScope
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }
}
