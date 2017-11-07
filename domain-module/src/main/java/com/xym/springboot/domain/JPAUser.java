package com.xym.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JPAUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 5)//最大长度为5
    private String name;
    @Column(nullable = false)
    private Integer age;

    public JPAUser() {

    }

    public JPAUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
