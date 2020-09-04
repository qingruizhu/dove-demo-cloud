package com.dove.demo.provider.uac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UacProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UacProviderApplication.class, args);
    }

}
