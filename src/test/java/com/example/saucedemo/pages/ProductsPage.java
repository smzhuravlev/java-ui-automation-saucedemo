package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement title = $(".title");

    @Step("Verify Products page is opened")
    public ProductsPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Products"));
        return this;
    }
}