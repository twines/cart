package com.bean.code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Component(value = "student1")
@Primary

public class Student {

    String name;
    @Value(value = "12")
    String age;

}
