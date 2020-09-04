package com.dove.demo.server.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 熔断
 * @Auther: qingruizhu
 * @Date: 2020/5/12 20:33
 */
@RestController
public class FallBackController {

    @RequestMapping(value = "/goFallBack", produces = "application/json;charset=UTF-8")
    public Map<String, Object> allBack() {
        Map<String, Object> back = new HashMap<>();
        back.put("success", false);
        back.put("code", 702);
        back.put("message", "【gateway】超时,请稍后再试");
        return back;
    }
}

