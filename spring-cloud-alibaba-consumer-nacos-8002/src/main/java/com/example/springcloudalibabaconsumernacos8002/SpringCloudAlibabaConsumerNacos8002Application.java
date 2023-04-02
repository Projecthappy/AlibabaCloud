package com.example.springcloudalibabaconsumernacos8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SpringCloudAlibabaConsumerNacos8002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAlibabaConsumerNacos8002Application.class, args);
	}

}
