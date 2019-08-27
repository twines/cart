package com.bean.code;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class XmlBeanExample {
    List<String> list;
    String name;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
