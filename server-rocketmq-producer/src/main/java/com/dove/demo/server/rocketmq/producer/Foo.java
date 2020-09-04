package com.dove.demo.server.rocketmq.producer;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/9/3 16:48
 */
public class Foo implements Serializable {

    private Integer index;
    private String foo;

    public Foo(int index, String foo) {
        this.index = index;
        this.foo = foo;
    }

}
