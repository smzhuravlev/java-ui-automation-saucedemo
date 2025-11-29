package com.example.saucedemo.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class InventoryItem {

    private final SelenideElement root;

    public InventoryItem(SelenideElement root) {
        this.root = root;
    }

    @Step("Add item to cart")
    public InventoryItem addToCart() {
        root.$("button").shouldBe(visible).click();
        return this;
    }

    public String getName() {
        return root.$(".inventory_item_name").text();
    }
}
