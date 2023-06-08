package org.example;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelFlowLimitController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/testA")
    public String testA() {
        try (Entry entry = SphU.entry("testAbySphU")) {
            //您的业务逻辑 - 开始
            return "服务访问成功------testA：" + serverPort;
            //您的业务逻辑 - 结束
        } catch (BlockException e1) {
            //流控逻辑处理 - 开始
            log.info("testA 服务被限流");
            return "testA 服务被限流";
            //流控逻辑处理 - 结束
        }
    }

    @RequestMapping("/testC")
    public String testC() {
        int a = 5 / 0;
        return "服务访问成功------testC：" + serverPort;
    }

//    @PostConstruct
//    private static void initFlowRules(){
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule = new FlowRule();
//        rule.setResource("testAbySphU");
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule.setCount(3);
//        rules.add(rule);
//        FlowRuleManager.loadRules(rules);
//    }
}
