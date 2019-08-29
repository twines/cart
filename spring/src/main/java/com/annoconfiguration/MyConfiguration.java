package com.annoconfiguration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
 public class MyConfiguration {


    //这是一种手动添加Bean的方式
//    也也可以将User申明为@Component
   /*
    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    User getUser() {
        return new User();
    }

    */
}
