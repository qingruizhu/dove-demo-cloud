package com.dove.demo.server.rocketmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(MySource.class)
public class ServerRocketmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRocketmqProducerApplication.class, args);
    }

}
