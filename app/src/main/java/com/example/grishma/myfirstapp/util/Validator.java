package com.example.grishma.myfirstapp.util;

/**
 * Validates username and password
 */

public class Validator {
    /**
     * Validates username of user
     * @param username is a string,
     * @return true if length of username is <= 10, else false
     */
    public Boolean validateUsername(String username) {
        return (username.length() <= 10 ? true : false);
    }

    /**
     * Validates password of user
     * @param password is a string
     * @return true if length of password is exactly 4
     */

    public Boolean validatePassword(String password) {
        return (password.length() == 4 ? true : false);
    }
}
