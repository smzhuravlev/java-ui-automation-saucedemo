package com.example.saucedemo.tests;

import com.example.saucedemo.config.TestBase;
import com.example.saucedemo.pages.CartPage;
import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.pages.ProductsPage;
import com.example.saucedemo.data.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .loginAs(Users.STANDARD)
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
                .loginWithInvalidCredentials(Users.LOCKED_OUT.getUsername(), Users.LOCKED_OUT.getPassword())
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
                .addProductToCart(productName);

        CartPage cartPage = productsPage
                .header()
                .assertCartBadge("1")
                .openCart()
                .assertPageIsOpened()
                .assertProductInCart(productName);
    }

    @Test
    @DisplayName("User can logout via header menu")
    void userCanLogoutViaHeaderMenu() {
        LoginPage loginPage = new LoginPage();

        ProductsPage productsPage = loginPage
                .loginAs("standard_user", "secret_sauce")
                .assertPageIsOpened();

        productsPage
                .header()
                .logout();

        // Here we can assert that login button is visible again,
        // if we want to add assertion in LoginPage.
    }

}
