package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    private final SelenideElement title = $(".title");
    private final SelenideElement finishButton = $("#finish");

    @Step("Verify Checkout Overview page is opened")
    public CheckoutOverviewPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Checkout: Overview"));
        return this;
    }

    @Step("Finish checkout")
    public CheckoutCompletePage finishCheckout() {
        finishButton.shouldBe(visible).click();
        return new CheckoutCompletePage();
    }
}
