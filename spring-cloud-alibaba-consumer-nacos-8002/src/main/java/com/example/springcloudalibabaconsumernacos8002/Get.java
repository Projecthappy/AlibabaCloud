package com.example.springcloudalibabaconsumernacos8002;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-alibaba-provider")
public interface Get {
    @GetMapping("/dept/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);

    @RequestMapping("/TimeOutTest/{id}")
    int getTimeOutTest(@PathVariable("id") Integer id);
}
