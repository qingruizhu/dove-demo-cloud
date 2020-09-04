package com.dove.demo.server.rocketmq.consumer;

import com.alibaba.fastjson.JSONPObject;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/3 17:30
 */
@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 接收到了消息：" + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input2 接收到了消息：" + receiveMsg);
    }

    @StreamListener("input3")
    public void receiveInput3(@Payload JSONPObject object) {
        System.out.println("input3 接收到了消息：" + object);
    }

}
