package com.fanter.samplebackend.domain;

import lombok.Data;


@Data
public class User {

    private String userName;
    private String email;
    private int age;

    public User(String userName, String email, int age) {
        this.userName = userName;
        this.email = email;
        this.age = age;
    }
}
