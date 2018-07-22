package com.ccab;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "persent")
public class PersentProperties {
    private String sex;

    private Integer age;

    public PersentProperties() {
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {

        return sex;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersentProperties{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
