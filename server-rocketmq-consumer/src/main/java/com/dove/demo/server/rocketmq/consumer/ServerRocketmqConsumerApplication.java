package com.dove.demo.server.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(MySource.class)
public class ServerRocketmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRocketmqConsumerApplication.class, args);
    }

}
