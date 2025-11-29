package com.example.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {

    private final SelenideElement title = $(".title");
    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");

    @Step("Verify Checkout Information page is opened")
    public CheckoutInformationPage assertPageIsOpened() {
        title.shouldBe(visible).shouldHave(text("Checkout: Your Information"));
        return this;
    }

    @Step("Fill checkout form: {firstName} {lastName}, zip {postalCode}")
    public CheckoutInformationPage fillForm(String firstName, String lastName, String postalCode) {
        firstNameInput.shouldBe(visible).setValue(firstName);
        lastNameInput.shouldBe(visible).setValue(lastName);
        postalCodeInput.shouldBe(visible).setValue(postalCode);
        return this;
    }

    @Step("Continue to checkout overview")
    public CheckoutOverviewPage continueToOverview() {
        continueButton.shouldBe(visible).click();
        return new CheckoutOverviewPage();
    }
}
