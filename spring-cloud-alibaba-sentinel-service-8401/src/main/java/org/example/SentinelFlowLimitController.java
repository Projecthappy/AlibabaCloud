package org.example;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SentinelFlowLimitController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testA")
    public String testA() {
        return testAbySphU();
    }

    @GetMapping("/testB")
    public String testB() {
        return testBbySphO();
    }

    /**
     * 通过 SphU 手动定义资源
     *
     * @return
     */
    public String testAbySphU() {
        try (Entry entry = SphU.entry("testAbySphU")) {
            //您的业务逻辑 - 开始
            log.info("服务访问成功------testA：" + serverPort);
            return "服务访问成功------testA：" + serverPort;
            //您的业务逻辑 - 结束
        } catch (BlockException e1) {
            //流控逻辑处理 - 开始
            log.info("testA 服务被限流");
            return "testA 服务被限流";
            //流控逻辑处理 - 结束
        }
//        finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
    }
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("testAbySphU");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(3);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
    /**
     * 通过 SphO 手动定义资源
     *
     * @return
     */
    public String testBbySphO() {
        if (SphO.entry("testBbySphO")) {
            // 务必保证finally会被执行
            try {
                log.info("服务访问成功------testB：" + serverPort);
                return "服务访问成功------testB：" + serverPort;
            } finally {
                SphO.exit();
            }
        } else {
            // 资源访问阻止，被限流或被降级
            //流控逻辑处理 - 开始
            log.info("testB 服务被限流");
            return "testB 服务被限流";
            //流控逻辑处理 - 结束
        }
    }
}
