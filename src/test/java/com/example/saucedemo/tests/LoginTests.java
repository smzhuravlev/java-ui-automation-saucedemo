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

    @Test
    @DisplayName("User cannot login with invalid password")
    void userCannotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginWithInvalidCredentials("standard_user", "wrong_password")
                .assertErrorMessageText("Username and password do not match any user in this service");
    }

    @Test
    @DisplayName("Locked out user sees appropriate error message")
    void lockedOutUserCannotLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginWithInvalidCredentials("locked_out_user", "secret_sauce")
                .assertErrorMessageText("Sorry, this user has been locked out.");
    }
}
