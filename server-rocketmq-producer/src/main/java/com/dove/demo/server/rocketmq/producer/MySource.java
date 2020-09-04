package com.dove.demo.server.rocketmq.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/3 16:34
 */

public interface MySource {

    @Output("output1")
    MessageChannel output1();

    @Output("output2")
    MessageChannel output2();
}
