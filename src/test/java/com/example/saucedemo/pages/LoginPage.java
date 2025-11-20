package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    @Step("Login as user {username}")
    public ProductsPage loginAs(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return new ProductsPage();
    }

    @Step("Verify error message is visible")
    public LoginPage assertErrorVisible() {
        errorMessage.shouldBe(visible);
        return this;
    }
}