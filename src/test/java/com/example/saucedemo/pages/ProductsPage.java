package com.example.saucedemo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.saucedemo.pages.components.HeaderComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private final SelenideElement title = $(".title");
    private final ElementsCollection products = $$(".inventory_item");
    private final HeaderComponent header = new HeaderComponent();

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

    public HeaderComponent header() {
        return header;
    }
}
