package org.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationDefine {

    @RequestMapping("/annotation/{id}")
    @SentinelResource(value = "annotationType", blockHandler = "myBlockHandler")
    public String get(@PathVariable String id) {
        return "annotation访问成功" + id;
    }

    public String myBlockHandler(String id, BlockException e) {
        return "annotation服务降级";
    }

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功！");
        return "生成订单";
    }

    @RequestMapping("/get")
    public String get() {
        return "查询订单";
    }


}
