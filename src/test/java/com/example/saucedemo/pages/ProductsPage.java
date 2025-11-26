package com.example.saucedemo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private final SelenideElement title = $(".title");
    private final ElementsCollection products = $$(".inventory_item");
    private final SelenideElement cartLink = $(".shopping_cart_link");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");

    @Step("Verify Products page is opened")
    public ProductsPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Products"));
        return this;
    }

    @Step("Add product '{productName}' to cart")
    public ProductsPage addProductToCart(String productName) {
        products.findBy(text(productName))
                .shouldBe(visible)
                .$("button")
                .click();
        return this;
    }

    @Step("Open cart page")
    public CartPage openCart() {
        cartLink.click();
        return new CartPage();
    }

    @Step("Verify cart badge shows '{expectedCount}' items")
    public ProductsPage assertCartBadge(String expectedCount) {
        cartBadge.shouldBe(visible).shouldHave(text(expectedCount));
        return this;
    }
}
