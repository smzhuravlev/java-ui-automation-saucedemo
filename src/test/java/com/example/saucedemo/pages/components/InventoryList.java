package com.example.saucedemo.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Optional;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryList {

    private final ElementsCollection items = $$(".inventory_item");

    public InventoryItem item(String productName) {
        Optional<SelenideElement> element = items.stream()
                .filter(el -> el.$(".inventory_item_name").has(text(productName)))
                .findFirst();

        return element
                .map(InventoryItem::new)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));
    }

    public int count() {
        return items.size();
    }
}
