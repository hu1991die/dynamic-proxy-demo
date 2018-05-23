package com.feizi.proxy.dynamic;

import com.feizi.demo.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * JAVA动态代理
 * Created by feizi on 2018/1/11.
 */
public class LogInvocationHandler implements InvocationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogInvocationHandler.class);

    private Hello hello;

    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1. 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法。
        if("sayHello".equals(method.getName())){
            LOGGER.info("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }
}
