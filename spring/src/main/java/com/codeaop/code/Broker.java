package com.codeaop.code;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Broker {

    @Pointcut("execution(* com.codeaop.code.Landlord.service())")
    public void lService() {
        //该方法就是一个标识方法，为pointcut提供一个依附的地方，每部需要为空
    }

    //只关注包租婆的租房业务
    //采用*代表关注全部
    @Before("lService()")
    public void before() {
        System.out.println("带租客看房");
        System.out.println("谈价格");
    }

    @After("lService()")
    public void after() {
        System.out.println("交钥匙");
    }
}
