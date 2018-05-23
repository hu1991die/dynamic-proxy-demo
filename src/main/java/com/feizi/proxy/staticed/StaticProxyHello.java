package com.feizi.proxy.staticed;

import com.feizi.demo.Hello;
import com.feizi.demo.impl.HelloImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理方式
 * Created by feizi on 2018/1/11.
 */
public class StaticProxyHello implements Hello{
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticProxyHello.class);

    private Hello hello = new HelloImpl();

    @Override
    public String sayHello(String str) {
        LOGGER.info("You said: " + str);
        return hello.sayHello(str);
    }
}
