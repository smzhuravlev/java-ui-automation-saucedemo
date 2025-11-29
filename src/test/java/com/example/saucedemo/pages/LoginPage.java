package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.example.saucedemo.data.User;

public class LoginPage {

    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    @Step("Login as user '{username}'")
    public ProductsPage loginAs(String username, String password) {
        fillCredentials(username, password);
        loginButton.click();
        return new ProductsPage();
    }

    @Step("Login as user '{user}'")
    public ProductsPage loginAs(User user) {
        return loginAs(user.getUsername(), user.getPassword());
    }

    @Step("Try to login with invalid credentials: '{username}' / '{password}'")
    public LoginPage loginWithInvalidCredentials(String username, String password) {
        fillCredentials(username, password);
        loginButton.click();
        return this;
    }

    @Step("Verify error message text is '{expectedText}'")
    public LoginPage assertErrorMessageText(String expectedText) {
        errorMessage.shouldBe(visible).shouldHave(text(expectedText));
        return this;
    }

    private void fillCredentials(String username, String password) {
        usernameInput.shouldBe(visible).setValue(username);
        passwordInput.shouldBe(visible).setValue(password);
    }
}
