package com.dove.demo.server.rocketmq.producer;

import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/3 16:38
 */
@Service
public class SendService {

    @Autowired
    private MySource mySource;

    public void send(String msg) {
        Message<String> build = MessageBuilder.withPayload(msg).build();
        mySource.output1().send(build);
    }

    public void sendWithTags(String msg, String tag) {
        Message<String> build = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag).build();
        mySource.output1().send(build);
    }

    /**
     * 发送对象
     *
     * @param msg
     * @param tag
     * @param <T>
     */
    public <T> void sendObject(T msg, String tag) {
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        mySource.output2().send(message);
    }
}
