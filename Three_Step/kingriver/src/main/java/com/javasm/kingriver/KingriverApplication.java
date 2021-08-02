package com.javasm.kingriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KingriverApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingriverApplication.class, args);
    }

}
