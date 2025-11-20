package com.example.saucedemo.tests;

import com.example.saucedemo.config.TestBase;
import com.example.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginAs("standard_user", "secret_sauce")
                .assertPageIsOpened();
    }
}