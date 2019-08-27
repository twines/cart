package com.bean;

import com.bean.code.Student;
import com.bean.code.StudentConfig;
import com.bean.code.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Service;

public class AnnBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        Student student1 = context.getBean(Student.class);
        System.out.println(student1);
        StudentService service = context.getBean(StudentService.class);
        service.getStudent();
    }
}
