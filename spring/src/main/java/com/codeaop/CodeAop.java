package com.codeaop;

import com.codeaop.code.Broker;
import com.codeaop.code.CodeConfig;
import com.codeaop.code.Landlord;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CodeAop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CodeConfig.class);
        Landlord landlord = context.getBean(Landlord.class);
        landlord.service();
    }
}
