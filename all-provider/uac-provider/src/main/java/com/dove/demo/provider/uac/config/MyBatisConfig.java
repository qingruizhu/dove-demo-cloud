package com.dove.demo.provider.uac.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.dove.demo.bgd.uac.mapper", "com.dove.demo.provider.uac.dao"})
public class MyBatisConfig {


}
