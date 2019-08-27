package com.bean.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //根据类型来查找到符合条件的
    @Autowired

    //自动装配的时候还可以从符合条件的bean中指定某一个具体的
    //如 我们有两个 bean 分别为 a1 a2 那么可以制定哪个
    // a1 a2的bean也是有优先级的，默认是注入优先级搞的Primary
    @Qualifier("student")
    Student student;

    public Student getStudent() {
        return student;
    }



}
