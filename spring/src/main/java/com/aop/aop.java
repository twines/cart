package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aop {
    public static void main(String[] args) {
        ApplicationContext context = new  org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        productService.doSOmeThing();

    }
}
