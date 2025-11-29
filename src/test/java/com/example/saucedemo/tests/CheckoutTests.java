package com.example.saucedemo.tests;

import com.example.saucedemo.config.TestBase;
import com.example.saucedemo.data.Users;
import com.example.saucedemo.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckoutTests extends TestBase {

    @Test
    @DisplayName("User can complete full checkout flow")
    void userCanCompleteCheckoutFlow() {
        String productName = "Sauce Labs Backpack";

        LoginPage loginPage = new LoginPage();

        ProductsPage productsPage = loginPage
                .loginAs(Users.STANDARD)
                .assertPageIsOpened()
                .addProductToCart(productName);

        CartPage cartPage = productsPage
                .header()
                .openCart()
                .assertPageIsOpened()
                .assertProductInCart(productName);

        CheckoutInformationPage checkoutInformationPage = cartPage
                .proceedToCheckout()
                .assertPageIsOpened()
                .fillForm("Sergei", "Zhuravlev", "21000");

        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage
                .continueToOverview()
                .assertPageIsOpened();

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage
                .finishCheckout()
                .assertPageIsOpened()
                .assertOrderCompleted();
    }
}
