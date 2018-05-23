package com.feizi.proxy.cglib;

import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * CGLIB动态代理
 * Created by feizi on 2018/1/11.
 */
public class MyMethodInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMethodInterceptor.class);

    /**
     * 1. 首先实现一个MethodInterceptor，方法调用会被转发到该类的intercept()方法。
     * @param obj
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        LOGGER.info("You said: " + Arrays.toString(args));
        return methodProxy.invokeSuper(obj, args);
    }
}
