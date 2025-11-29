package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {

    private final SelenideElement title = $(".title");
    private final SelenideElement completeHeader = $(".complete-header");

    @Step("Verify Checkout Complete page is opened")
    public CheckoutCompletePage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Checkout: Complete!"));
        return this;
    }

    @Step("Verify order is completed successfully")
    public CheckoutCompletePage assertOrderCompleted() {
        completeHeader.shouldBe(visible).shouldHave(text("Thank you for your order!"));
        return this;
    }
}
