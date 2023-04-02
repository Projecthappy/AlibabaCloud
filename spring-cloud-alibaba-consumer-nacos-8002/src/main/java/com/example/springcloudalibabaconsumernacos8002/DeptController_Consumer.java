package com.example.springcloudalibabaconsumernacos8002;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class DeptController_Consumer {
//    @Resource
//    private RestTemplate restTemplate;
//    @Value("${service-url.nacos-user-service}")
//    private String serverURL; //服务提供者的服务名

    @Autowired
    Get get;
    @Value("${config.info}")
    private String ConfigInfo;

    @RequestMapping("/1get")
    public String get() {
        return ConfigInfo;
    }
    @GetMapping("/consumer/dept/nacos/{id}")
    public String paymentInfo(@PathVariable("id") int id) {
//        return restTemplate.getForObject(serverURL + "/dept/nacos/" + id, String.class);
        return get.getPayment(id);
    }


}