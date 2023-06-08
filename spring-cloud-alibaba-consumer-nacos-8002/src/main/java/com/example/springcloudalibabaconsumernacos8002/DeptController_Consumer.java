package com.example.springcloudalibabaconsumernacos8002;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    Get get;
    @Qualifier("com.example.springcloudalibabaconsumernacos8002.SentinelRemote")
    @Autowired
    SentinelRemote sentinelRemote;
    @Value("${config.info}")
    private String ConfigInfo;

    @RequestMapping("/getSentinelRemote")
    public String getSentinelRemote() {
        return sentinelRemote.testC();
    }

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo() {
        return ConfigInfo;
    }

    @GetMapping("/nacos/{id}")
    public String paymentInfo(@PathVariable("id") int id) {
        return get.getPayment(id);
    }

    @RequestMapping("/timeout/{id}")
    public int timeout(@PathVariable("id") int id) {
        return get.getTimeOutTest(id);
    }

}