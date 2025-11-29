package com.example.saucedemo.data;

public final class Users {

    private Users() {
    }

    public static final User STANDARD = new User("standard_user", "secret_sauce");
    public static final User LOCKED_OUT = new User("locked_out_user", "secret_sauce");
    public static final User PROBLEM = new User("problem_user", "secret_sauce");
}
