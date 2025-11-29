package com.example.saucedemo.data;

public class User {

    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // JavaBean-style getters for Allure and other tools
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Optional: nice representation in logs / reports
    @Override
    public String toString() {
        return username;
    }
}
