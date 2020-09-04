package com.dove.demo.server.rocketmq.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/3 16:46
 */

@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    SendService sendService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(String msg) {
        sendService.send(msg);
        return "字符串消息发送成功!";
    }

    @RequestMapping(value = "/sendWithTags", method = RequestMethod.GET)
    public String sendWithTags(String msg) {
        sendService.sendWithTags(msg, "tagStr");
        return "带tag字符串消息发送成功!";
    }

    @RequestMapping(value = "/sendObject", method = RequestMethod.GET)
    public String sendObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhuqingrui");
        jsonObject.put("age", 10);
        sendService.sendObject(jsonObject, "tagObj");
        return "Object对象消息发送成功!";
    }
}
