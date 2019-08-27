package com.bean;

import com.aop.LogAspect;
import com.aop.ProductService;
import com.bean.code.XmlBeanExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.annotation.XmlElement;

public class XmlBean {
    public static void main(String[] args) {
        //xml配置的可以通过import导入另一个xml配置的context
        ApplicationContext context = new ClassPathXmlApplicationContext("beanXmlContext.xml");
        LogAspect logAspect = context.getBean(LogAspect.class);
        ProductService productService = (ProductService) context.getBean("productService");
        productService.doSOmeThing();
        XmlBeanExample example = context.getBean(XmlBeanExample.class);
        XmlBeanExample example1 = (XmlBeanExample) context.getBean("beanExample");
        System.out.println(example);
    }
}
