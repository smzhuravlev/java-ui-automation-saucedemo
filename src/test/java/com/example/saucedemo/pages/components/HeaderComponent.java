package com.example.saucedemo.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.example.saucedemo.pages.CartPage;
import com.example.saucedemo.pages.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    private final SelenideElement cartLink = $(".shopping_cart_link");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");
    private final SelenideElement burgerMenuButton = $("#react-burger-menu-btn");
    private final SelenideElement logoutLink = $("#logout_sidebar_link");

    @Step("Open cart from header")
    public CartPage openCart() {
        cartLink.click();
        return new CartPage();
    }

    @Step("Verify cart badge shows '{expectedCount}' items")
    public HeaderComponent assertCartBadge(String expectedCount) {
        cartBadge.shouldBe(visible).shouldHave(text(expectedCount));
        return this;
    }

    @Step("Open burger menu")
    public HeaderComponent openMenu() {
        burgerMenuButton.click();
        return this;
    }

    @Step("Logout via header menu")
    public LoginPage logout() {
        openMenu();
        logoutLink.shouldBe(visible).click();
        return new LoginPage();
    }
}
