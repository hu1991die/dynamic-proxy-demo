package com.feizi;

import com.feizi.demo.Hello;
import com.feizi.demo.HelloConcrete;
import com.feizi.demo.impl.HelloImpl;
import com.feizi.proxy.cglib.MyMethodInterceptor;
import com.feizi.proxy.dynamic.LogInvocationHandler;
import com.feizi.proxy.staticed.StaticProxyHello;
import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
//        testStaticedProxy();
//        testDynamicProxy();
        testCglibProxy();
    }

    /**
     * 测试静态代理
     */
    public static void testStaticedProxy(){
        StaticProxyHello staticProxyHello = new StaticProxyHello();
        String content = staticProxyHello.sayHello("feizi");
        LOGGER.info("content: " + content);
    }

    /**
     * 测试Java动态代理
     */
    public static void testDynamicProxy(){
        //2. 然后在需要使用Hello的时候，通过JDK动态代理获取Hello的代理对象。
        Hello hello = (Hello) Proxy.newProxyInstance(
                //1、类加载器
                App.class.getClassLoader(),
                //2、代理需要实现的接口，可以有多个
                new Class[]{Hello.class},
                //3、方法调用的实际处理者
                new LogInvocationHandler(new HelloImpl()));

        String content = hello.sayHello("feizi");
        LOGGER.info(content);
    }

    /**
     * 测试CGLIB动态代理
     */
    public static void testCglibProxy(){
        //2. 然后在需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete helloConcrete = (HelloConcrete) enhancer.create();
        String content = helloConcrete.sayHello("feizi");
        LOGGER.info(content);
    }
}
