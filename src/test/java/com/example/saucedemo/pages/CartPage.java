package com.example.saucedemo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement title = $(".title");
    private final ElementsCollection cartItems = $$(".cart_item");

    @Step("Verify Cart page is opened")
    public CartPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Your Cart"));
        return this;
    }

    @Step("Verify product '{productName}' is present in cart")
    public CartPage assertProductInCart(String productName) {
        cartItems.findBy(text(productName))
                .shouldBe(visible);
        return this;
    }
}
