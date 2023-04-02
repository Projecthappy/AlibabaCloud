package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaSentinelService8402Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaSentinelService8402Application.class, args);
    }
}
