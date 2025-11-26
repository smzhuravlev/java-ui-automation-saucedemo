package com.example.saucedemo.tests;

import com.example.saucedemo.config.TestBase;
import com.example.saucedemo.pages.CartPage;
import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginAs("standard_user", "secret_sauce")
                .assertPageIsOpened();
    }

    @Test
    @DisplayName("User cannot login with invalid password")
    void userCannotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginWithInvalidCredentials("standard_user", "wrong_password")
                .assertErrorMessageText("Username and password do not match any user in this service");
    }

    @Test
    @DisplayName("Locked out user sees appropriate error message")
    void lockedOutUserCannotLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginWithInvalidCredentials("locked_out_user", "secret_sauce")
                .assertErrorMessageText("Sorry, this user has been locked out.");
    }

    @Test
    @DisplayName("User can add product to cart and see it in Cart page")
    void userCanAddProductToCart() {
        String productName = "Sauce Labs Backpack";

        LoginPage loginPage = new LoginPage();

        ProductsPage productsPage = loginPage
                .loginAs("standard_user", "secret_sauce")
                .assertPageIsOpened()
                .addProductToCart(productName)
                .assertCartBadge("1");

        CartPage cartPage = productsPage
                .openCart()
                .assertPageIsOpened()
                .assertProductInCart(productName);
    }
}
