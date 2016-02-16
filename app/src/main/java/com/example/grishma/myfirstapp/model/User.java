package com.example.grishma.myfirstapp.model;

import java.io.Serializable;

/**
 * This is a model representing User
 * User has username and password
 * The getter and setter methods are used to manipulate its attributes
 */
public class User implements Serializable {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
