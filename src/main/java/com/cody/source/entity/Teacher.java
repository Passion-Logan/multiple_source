package com.cody.source.entity;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author wql
 * @since 2021-05-14 23:17:11
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = -33858677799290426L;

    private Long id;

    private String name;

    private Integer age;


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
