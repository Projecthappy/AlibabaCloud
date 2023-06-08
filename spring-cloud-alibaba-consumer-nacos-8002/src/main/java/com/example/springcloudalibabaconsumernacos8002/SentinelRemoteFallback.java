package com.example.springcloudalibabaconsumernacos8002;

import org.springframework.stereotype.Component;

@Component
public class SentinelRemoteFallback implements SentinelRemote{
    @Override
    public String testC() {
        return "testA暂时无法访问";
    }
}
