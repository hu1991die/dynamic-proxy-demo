package com.feizi.demo.impl;

import com.feizi.demo.Hello;

/**
 * Created by feizi on 2018/1/11.
 */
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String str) {
        return "HelloImpl: " + str;
    }
}
