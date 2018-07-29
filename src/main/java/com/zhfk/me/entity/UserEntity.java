package com.zhfk.me.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UserEntity {
    @Id@GeneratedValue
    private int id;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String country;
    private String city;
    private String roles;
}
