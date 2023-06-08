package com.example.springcloudalibabaconsumernacos8002;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sentinel-service", fallback = SentinelRemoteFallback.class)
public interface SentinelRemote {
    @GetMapping("/testC")
    String testC();
}
