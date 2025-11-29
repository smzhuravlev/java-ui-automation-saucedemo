package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.saucedemo.pages.components.HeaderComponent;
import com.example.saucedemo.pages.components.InventoryList;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement title = $(".title");
    private final HeaderComponent header = new HeaderComponent();
    private final InventoryList inventoryList = new InventoryList();

    @Step("Verify Products page is opened")
    public ProductsPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Products"));
        return this;
    }

    public HeaderComponent header() {
        return header;
    }

    public InventoryList inventory() {
        return inventoryList;
    }
}
